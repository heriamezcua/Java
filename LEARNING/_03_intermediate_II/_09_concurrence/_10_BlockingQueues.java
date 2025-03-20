package _03_intermediate_II._09_concurrence;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class _10_BlockingQueues {
	public static void main(String[] args) {
		// Define a blocking queue with a fixed size
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

		// Producer thread
		Thread producer = new Thread(() -> {
			try {
				for (int i = 1; i <= 10; i++) {
					System.out.println("Producing: Item " + i);
					queue.put("Item " + i);
					Thread.sleep(500); // Simulate work
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		// Consumer thread
		Thread consumer = new Thread(() -> {
			try {
				for (int i = 1; i <= 10; i++) {
					String item = queue.take();
					System.out.println("Consuming: " + item);
					Thread.sleep(1000); // Simulate work
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		});

		// Start both threads
		producer.start();
		consumer.start();

		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
