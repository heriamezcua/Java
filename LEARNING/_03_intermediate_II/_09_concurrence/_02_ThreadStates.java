package _03_intermediate_II._09_concurrence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _02_ThreadStates {

	public static void main(String[] args) {
		Thread newThread = new Thread(() -> {
		}); // New state
		System.out.println("New Thread State: " + newThread.getState());

		Runnable runnableTask = () -> {
			try {
				Thread.yield(); // Runnable state
				Thread.sleep(1000); // Timed Waiting state
				synchronized (_02_ThreadStates.class) {
					_02_ThreadStates.class.wait(); // Waiting state
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread thread = new Thread(runnableTask);
		thread.start();

		System.out.println("Runnable Thread State: " + thread.getState());

		Lock lock = new ReentrantLock();
		Thread blockedThread = new Thread(() -> {
			lock.lock();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		});

		lock.lock();
		try {
			blockedThread.start();
			Thread.sleep(500);
			System.out.println("Blocked Thread State: " + blockedThread.getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

		try {
			thread.join(); // Terminated state when thread finishes
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminated Thread State: " + thread.getState());
	}
}