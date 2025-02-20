package intermediate2._05_collections;

import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.*;

public class _10_QueuesAndDeques {
	public static void main(String[] args) {
		// Queue example (FIFO)
		Queue<Integer> queue = new ConcurrentLinkedQueue<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println("Queue: " + queue);
		System.out.println("Removed from queue: " + queue.poll()); // Removes 1
		System.out.println("Queue after poll: " + queue);

		// Deque example (add and remove from both ends)
		Deque<Integer> deque = new ConcurrentLinkedDeque<>();
		deque.offerFirst(1); // Add to the front
		deque.offerLast(2); // Add to the end
		deque.offerFirst(0); // Add to the front
		System.out.println("Deque: " + deque);
		System.out.println("Removed from front: " + deque.pollFirst()); // Removes 0
		System.out.println("Removed from end: " + deque.pollLast()); // Removes 2
		System.out.println("Deque after removals: " + deque);
	}
}