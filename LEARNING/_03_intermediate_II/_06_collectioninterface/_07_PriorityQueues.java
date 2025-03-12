package _03_intermediate_II._06_collectioninterface;

import java.util.PriorityQueue;

public class _07_PriorityQueues {

	static class Task implements Comparable<Task> {
		private String name;
		private int priority; // Lower value means higher priority

		public Task(String name, int priority) {
			this.name = name;
			this.priority = priority;
		}

		@Override
		public int compareTo(Task other) {
			return Integer.compare(this.priority, other.priority);
		}

		@Override
		public String toString() {
			return "Task{name='" + name + "', priority=" + priority + "}";
		}
	}

	public static void main(String[] args) {
		PriorityQueue<Task> taskQueue = new PriorityQueue<>();

		taskQueue.add(new Task("Write report", 3));
		taskQueue.add(new Task("Fix bug", 1));
		taskQueue.add(new Task("Attend meeting", 2));
		taskQueue.add(new Task("Code review", 4));

		// Iterating (order not guaranteed)
		System.out.println("Tasks in queue (unordered iteration):");
		for (Task task : taskQueue) {
			System.out.println(task);
		}

		// Removing tasks by priority (lower priority number first)
		System.out.println("\nProcessing tasks by priority:");
		while (!taskQueue.isEmpty()) {
			System.out.println("Processing: " + taskQueue.remove());
		}
	}
}
