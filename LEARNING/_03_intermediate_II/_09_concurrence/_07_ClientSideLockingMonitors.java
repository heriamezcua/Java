package _03_intermediate_II._09_concurrence;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;


public class _07_ClientSideLockingMonitors {
	// Example demonstrating Client-Side Locking and Monitors in Java
	static public class ConcurrencyTest {
		public static void main(String[] args) {
			Vector<Double> accounts = new Vector<>();
			for (int i = 0; i < 10; i++) {
				accounts.add(1000.0); // Initialize each account with $1000
			}

			// Using an ExecutorService to manage multiple threads
			ExecutorService executor = Executors.newFixedThreadPool(5);

			// Incorrect client-side locking (race condition risk)
			executor.execute(() -> unsafeTransfer(accounts, 0, 1, 500));

			// Corrected client-side locking (fragile solution)
			executor.execute(() -> safeTransfer(accounts, 2, 3, 500));

			// Using a proper monitor with synchronized methods
			BankAccount account = new BankAccount(2000.0);
			executor.execute(() -> account.deposit(500));
			executor.execute(() -> System.out.println("Balance: " + account.getBalance()));

			executor.shutdown();
		}

		// Incorrect transfer method (Race Condition possible)
		public static void unsafeTransfer(Vector<Double> accounts, int from, int to, double amount) {
			if (accounts.get(from) >= amount) {
				accounts.set(from, accounts.get(from) - amount);
				accounts.set(to, accounts.get(to) + amount);
			}
			System.out.println("Unsafe Transfer Completed");
		}

		// Corrected but fragile transfer method using client-side locking
		public static void safeTransfer(Vector<Double> accounts, int from, int to, double amount) {
			synchronized (accounts) {
				if (accounts.get(from) >= amount) {
					accounts.set(from, accounts.get(from) - amount);
					accounts.set(to, accounts.get(to) + amount);
				}
			}
			System.out.println("Safe Transfer Completed");
		}
	}

	// Safer approach using Monitors
	static class BankAccount {
		private double balance;

		public BankAccount(double balance) {
			this.balance = balance;
		}

		// Synchronized method to ensure thread safety
		public synchronized void deposit(double amount) {
			balance += amount;
			System.out.println("Deposited: " + amount);
		}

		// Synchronized method to retrieve balance safely
		public synchronized double getBalance() {
			return balance;
		}
	}

}
