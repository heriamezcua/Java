package _03_intermediate_II._09_concurrence;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _05_AwaitSignalSignalAll {

	static class Bank {
		private final double[] accounts;
		private final Lock bankLock = new ReentrantLock();
		private final Condition sufficientFunds = bankLock.newCondition();

		public Bank(int numAccounts, double initialBalance) {
			accounts = new double[numAccounts];
			for (int i = 0; i < numAccounts; i++) {
				accounts[i] = initialBalance;
			}
		}

		// Method to transfer money safely between accounts
		public void transfer(int from, int to, double amount) throws InterruptedException {
			bankLock.lock(); // Lock the critical section
			try {
				while (accounts[from] < amount) {
					System.out.println(Thread.currentThread().getName() + " waiting for funds...");
					sufficientFunds.await(); // Wait until there are enough funds
				}
				accounts[from] -= amount;
				accounts[to] += amount;
				System.out.printf("%s transferred %10.2f from %d to %d. Total Balance: %10.2f%n",
						Thread.currentThread().getName(), amount, from, to, getTotalBalance());
				sufficientFunds.signalAll(); // Notify all waiting threads that funds are available
			} finally {
				bankLock.unlock(); // Ensure the lock is released
			}
		}

		public double getTotalBalance() {
			double sum = 0;
			for (double a : accounts) {
				sum += a;
			}
			return sum;
		}

		public void deposit(int account, double amount) {
			bankLock.lock(); // Lock to ensure atomicity
			try {
				accounts[account] += amount;
				System.out.printf("%s deposited %10.2f to account %d. Total Balance: %10.2f%n",
						Thread.currentThread().getName(), amount, account, getTotalBalance());
				sufficientFunds.signal(); // Notify one waiting thread that funds are available
			} finally {
				bankLock.unlock();
			}
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

	static class DepositTask implements Runnable {
		private final Bank bank;
		private final int account;
		private final double maxAmount;

		public DepositTask(Bank bank, int account, double max) {
			this.bank = bank;
			this.account = account;
			this.maxAmount = max;
		}

		@Override
		public void run() {
			try {
				while (true) {
					double amount = maxAmount * Math.random();
					bank.deposit(account, amount);
					Thread.sleep((int) (Math.random() * 10));
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	static public class BankSimulation {
		public static void main(String[] args) {
			final int NUM_ACCOUNTS = 10;
			final double INITIAL_BALANCE = 10000;

			Bank bank = new Bank(NUM_ACCOUNTS, INITIAL_BALANCE);

			// Start transfer threads
			for (int i = 0; i < NUM_ACCOUNTS; i++) {
				Thread t = new Thread(new TransferTask(bank, i, INITIAL_BALANCE), "TransferThread-" + i);
				t.start();
			}

			// Start deposit threads to ensure there are funds
			for (int i = 0; i < NUM_ACCOUNTS; i++) {
				Thread t = new Thread(new DepositTask(bank, i, INITIAL_BALANCE), "DepositThread-" + i);
				t.start();
			}
		}
	}

}
