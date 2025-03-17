package _03_intermediate_II._09_concurrence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _04_SyncRaceCondLockObj {
	static class Bank {
		private final double[] accounts;
		private final Lock bankLock = new ReentrantLock();

		public Bank(int numAccounts, double initialBalance) {
			accounts = new double[numAccounts];
			for (int i = 0; i < numAccounts; i++) {
				accounts[i] = initialBalance;
			}
		}

		// Method to transfer money safely between accounts
		public void transfer(int from, int to, double amount) {
			bankLock.lock(); // Lock the critical section
			try {
				if (accounts[from] < amount)
					return; // Check if enough balance
				System.out.print(Thread.currentThread());
				accounts[from] -= amount;
				System.out.printf(" %10.2f from %d to %d", amount, from, to);
				accounts[to] += amount;
				System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
			} finally {
				bankLock.unlock(); // Ensure the lock is released
			}
		}

		// Method to calculate total balance to check for inconsistencies
		public double getTotalBalance() {
			double sum = 0;
			for (double a : accounts) {
				sum += a;
			}
			return sum;
		}

		public int size() {
			return accounts.length;
		}
	}

	static class TransferTask implements Runnable {
		private final Bank bank;
		private final int fromAccount;
		private final double maxAmount;

		public TransferTask(Bank bank, int from, double max) {
			this.bank = bank;
			this.fromAccount = from;
			this.maxAmount = max;
		}

		@Override
		public void run() {
			try {
				while (true) {
					int toAccount = (int) (bank.size() * Math.random());
					double amount = maxAmount * Math.random();
					bank.transfer(fromAccount, toAccount, amount);
					Thread.sleep((int) (Math.random() * 10));
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	public static class BankSimulation {
		public static void main(String[] args) {
			final int NUM_ACCOUNTS = 10;
			final double INITIAL_BALANCE = 10000;

			Bank bank = new Bank(NUM_ACCOUNTS, INITIAL_BALANCE);
			for (int i = 0; i < NUM_ACCOUNTS; i++) {
				Thread t = new Thread(new TransferTask(bank, i, INITIAL_BALANCE));
				t.start();
			}
		}
	}

}
