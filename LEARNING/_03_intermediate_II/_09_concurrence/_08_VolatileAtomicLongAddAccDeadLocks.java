package _03_intermediate_II._09_concurrence;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class _08_VolatileAtomicLongAddAccDeadLocks {
	// Volatile variable ensures visibility across threads
	private volatile boolean done = false;

	// Atomic counter for thread-safe operations
	private static final AtomicLong atomicCounter = new AtomicLong(0);

	// LongAdder for concurrent summation
	private static final LongAdder longAdder = new LongAdder();

	// LongAccumulator for general-purpose accumulation
	private static final LongAccumulator longAccumulator = new LongAccumulator(Long::sum, 0);

	// Locks to simulate potential deadlocks
	private final Lock lockA = new ReentrantLock();
	private final Lock lockB = new ReentrantLock();

	public void toggleDone() {
		done = !done; // Incorrect, not atomic
	}

	public void atomicIncrement() {
		atomicCounter.incrementAndGet();
	}

	public void addWithLongAdder() {
		longAdder.increment();
	}

	public void accumulateWithLongAccumulator(int value) {
		longAccumulator.accumulate(value);
	}

	public void causeDeadlock() {
		Thread thread1 = new Thread(() -> {
			lockA.lock();
			try {
				Thread.sleep(50); // Simulate work
				lockB.lock();
				try {
					System.out.println("Thread 1 acquired both locks");
				} finally {
					lockB.unlock();
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				lockA.unlock();
			}
		});

		Thread thread2 = new Thread(() -> {
			lockB.lock();
			try {
				Thread.sleep(50); // Simulate work
				lockA.lock();
				try {
					System.out.println("Thread 2 acquired both locks");
				} finally {
					lockA.unlock();
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			} finally {
				lockB.unlock();
			}
		});

		thread1.start();
		thread2.start();
	}

	public static void main(String[] args) {
		_08_VolatileAtomicLongAddAccDeadLocks test = new _08_VolatileAtomicLongAddAccDeadLocks();

		// Demonstrate volatile usage
		new Thread(() -> {
			while (!test.done) {
				// Wait until done is true
			}
			System.out.println("Thread detected change in 'done'");
		}).start();

		try {
			Thread.sleep(100); // Allow other thread to start
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		test.toggleDone(); // Improper use, should use atomic variable instead
		System.out.println("Main thread toggled 'done'");

		// Demonstrate atomic operations
		test.atomicIncrement();
		System.out.println("Atomic counter: " + atomicCounter.get());

		// Demonstrate LongAdder and LongAccumulator
		test.addWithLongAdder();
		System.out.println("LongAdder value: " + longAdder.sum());

		test.accumulateWithLongAccumulator(10);
		System.out.println("LongAccumulator value: " + longAccumulator.get());

		// Simulate deadlock (uncomment with caution)
		// test.causeDeadlock();
	}
}
