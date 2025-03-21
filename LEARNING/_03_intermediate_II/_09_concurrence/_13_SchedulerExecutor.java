package _03_intermediate_II._09_concurrence;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _13_SchedulerExecutor {
	public static void main(String[] args) {
		// Create a scheduled executor service with a single thread
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		// Task 1: Executes once after a delay of 5 seconds
		scheduler.schedule(() -> System.out.println("Task 1: Executed after 5 seconds"), 5, TimeUnit.SECONDS);

		// Task 2: Executes periodically every 2 seconds, starting immediately
		scheduler.scheduleAtFixedRate(() -> System.out.println("Task 2: Executing every 2 seconds (fixed rate)"), 0, 2,
				TimeUnit.SECONDS);

		// Task 3: Executes periodically with a 3-second delay after the previous
		// execution ends
		scheduler.scheduleWithFixedDelay(() -> {
			System.out.println("Task 3: Executing with a 3-second delay after the previous execution");
			try {
				Thread.sleep(1000); // Simulating task execution time
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 3, TimeUnit.SECONDS);

		// Shutdown the scheduler after 15 seconds to allow tests to complete
		scheduler.schedule(() -> {
			System.out.println("Shutting down the scheduler.");
			scheduler.shutdown();
		}, 15, TimeUnit.SECONDS);
	}
}
