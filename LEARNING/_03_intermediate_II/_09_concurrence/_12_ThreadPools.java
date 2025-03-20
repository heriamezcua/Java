package _03_intermediate_II._09_concurrence;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _12_ThreadPools {
	
	public static void main(String[] args) throws Exception {
		// 1. Thread Pool Example
		ExecutorService fixedPool = Executors.newFixedThreadPool(3);
		ExecutorService cachedPool = Executors.newCachedThreadPool();
		ExecutorService singleThread = Executors.newSingleThreadExecutor();

		// 2. Runnable Example (No return value)
		Runnable runnableTask = () -> System.out.println("Runnable task executed");
		fixedPool.execute(runnableTask);

		// 3. Callable and Future Example (Returns a value)
		Callable<Integer> callableTask = () -> 42;
		Future<Integer> future = fixedPool.submit(callableTask);
		System.out.println("Callable result: " + future.get());

		// 4. FutureTask Example
		FutureTask<Integer> futureTask = new FutureTask<>(callableTask);
		Thread thread = new Thread(futureTask);
		thread.start();
		System.out.println("FutureTask result: " + futureTask.get());

		// 5. invokeAll Example (Executing multiple tasks in parallel)
		List<Callable<Integer>> taskList = List.of(() -> {
			Thread.sleep(1000);
			return 10;
		}, () -> {
			Thread.sleep(2000);
			return 20;
		}, () -> {
			Thread.sleep(3000);
			return 30;
		});
		List<Future<Integer>> results = fixedPool.invokeAll(taskList);
		for (Future<Integer> result : results) {
			System.out.println("invokeAll result: " + result.get());
		}

		// 6. invokeAny Example (First completed task wins)
		Integer firstResult = fixedPool.invokeAny(taskList);
		System.out.println("invokeAny result: " + firstResult);

		// 7. Shutting down executors
		fixedPool.shutdown();
		cachedPool.shutdown();
		singleThread.shutdown();
	}
	
    public static void main2(String[] args) {
        // Creating a ScheduledExecutorService with a pool size of 1
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // 1. Schedule a task to run after a fixed delay
        scheduler.schedule(() -> System.out.println("Executed after 5 seconds"), 5, TimeUnit.SECONDS);

        // 2. Schedule a task to run periodically at a fixed rate
        scheduler.scheduleAtFixedRate(() -> System.out.println("Executing every 2 seconds"), 0, 2, TimeUnit.SECONDS);

        // 3. Schedule a task with a fixed delay between executions
        scheduler.scheduleWithFixedDelay(() -> System.out.println("Executing with fixed delay of 3 seconds"), 0, 3, TimeUnit.SECONDS);
        
        // Scheduler will keep running indefinitely, so we add a delayed shutdown
        scheduler.schedule(() -> {
            System.out.println("Shutting down scheduler");
            scheduler.shutdown();
        }, 15, TimeUnit.SECONDS); // Shutdown after 15 seconds to allow tasks to run a few times
    }
}
