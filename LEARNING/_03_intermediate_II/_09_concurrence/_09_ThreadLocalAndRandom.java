package _03_intermediate_II._09_concurrence;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class _09_ThreadLocalAndRandom {
	// Flag to control suspension safely
	private volatile boolean suspendRequested = false;

	// Thread-local variable to ensure each thread has its own copy
	private static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

	// Thread-local variable for database connections
	private static final ThreadLocal<Connection> connection = ThreadLocal.withInitial(() -> null);

	public void safeSuspendResume() {
		new Thread(() -> {
			while (true) {
				synchronized (this) {
					while (suspendRequested) {
						try {
							wait(); // Wait until resumed
						} catch (InterruptedException e) {
							Thread.currentThread().interrupt();
							return;
						}
					}
				}
				System.out.println("Thread is running...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}).start();
	}

	public synchronized void requestSuspend() {
		suspendRequested = true;
	}

	public synchronized void resumeThread() {
		suspendRequested = false;
		notify();
	}

	public void demonstrateThreadLocal() {
		new Thread(() -> {
			String dateStamp = dateFormat.get().format(new Date());
			System.out.println("Formatted Date: " + dateStamp);
		}).start();
	}

	public void demonstrateThreadLocalRandom() {
		int random = ThreadLocalRandom.current().nextInt(100);
		System.out.println("Random Number: " + random);
	}

	public static void main(String[] args) {
		_09_ThreadLocalAndRandom test = new _09_ThreadLocalAndRandom();

		// Demonstrate controlled suspension and resumption
		test.safeSuspendResume();
		try {
			Thread.sleep(2000);
			test.requestSuspend();
			System.out.println("Thread suspended.");
			Thread.sleep(2000);
			test.resumeThread();
			System.out.println("Thread resumed.");
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		// Demonstrate Thread-Local variable
		test.demonstrateThreadLocal();

		// Demonstrate Thread-Local Random
		test.demonstrateThreadLocalRandom();
	}
}
