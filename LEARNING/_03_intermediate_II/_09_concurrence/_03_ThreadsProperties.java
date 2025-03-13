package _03_intermediate_II._09_concurrence;

public class _03_ThreadsProperties {
	public static void main(String[] args) {

		// 1. Handling Thread Interruption
		Thread interruptibleThread = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) { // Check if interrupted
				try {
					System.out.println("Thread running...");
					Thread.sleep(1000); // Sleep to simulate work
				} catch (InterruptedException e) {
					System.out.println("Thread interrupted while sleeping");
					Thread.currentThread().interrupt(); // Preserve interrupted status
				}
			}
			System.out.println("Thread exiting due to interruption");
		});
		interruptibleThread.start();

		// Interrupt the thread after 3 seconds
		new Thread(() -> {
			try {
				Thread.sleep(3000);
				interruptibleThread.interrupt(); // Interrupt the thread
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		// 2. Daemon Thread Example
		Thread daemonThread = new Thread(() -> {
			while (true) {
				System.out.println("I am a daemon thread running in the background");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		daemonThread.setDaemon(true); // Set as daemon before start
		daemonThread.start();

		// 3. Naming a Thread
		Thread namedThread = new Thread(() -> System.out.println("Thread execution"));
		namedThread.setName("Worker-1"); // Assign a name
		namedThread.start();
		System.out.println("Thread Name: " + namedThread.getName());

		// 4. Uncaught Exception Handler
		Thread exceptionThread = new Thread(() -> {
			throw new RuntimeException("Unhandled exception in thread");
		});
		exceptionThread.setUncaughtExceptionHandler(
				(thread, ex) -> System.out.println("Exception in " + thread.getName() + ": " + ex.getMessage()));
		exceptionThread.start();

		// 5. Thread Priority
		Thread priorityThread = new Thread(() -> System.out.println("Executing high priority thread"));
		priorityThread.setPriority(Thread.MAX_PRIORITY); // Set highest priority (10)
		priorityThread.start();
	}
}
