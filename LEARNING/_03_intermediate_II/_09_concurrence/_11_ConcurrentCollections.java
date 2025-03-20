package _03_intermediate_II._09_concurrence;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class _11_ConcurrentCollections {
	public static void main(String[] args) throws Exception {
		// 1. ConcurrentHashMap Example
		ConcurrentHashMap<String, Long> concurrentMap = new ConcurrentHashMap<>();
		concurrentMap.put("apple", 1L);
		concurrentMap.put("banana", 2L);
		concurrentMap.put("cherry", 3L);

		// Demonstrating atomic updates
		concurrentMap.merge("apple", 1L, Long::sum);
		concurrentMap.compute("banana", (k, v) -> (v == null) ? 1 : v + 1);

		// Concurrent iteration (Weakly Consistent Iterator)
		concurrentMap.forEach((k, v) -> System.out.println(k + " -> " + v));

		// 2. ConcurrentSkipListMap Example
		ConcurrentSkipListMap<Integer, String> skipListMap = new ConcurrentSkipListMap<>();
		skipListMap.put(1, "One");
		skipListMap.put(3, "Three");
		skipListMap.put(2, "Two");

		// Sorted Order
		skipListMap.forEach((k, v) -> System.out.println(k + " : " + v));

		// 3. ConcurrentSkipListSet Example
		ConcurrentSkipListSet<String> skipListSet = new ConcurrentSkipListSet<>();
		skipListSet.add("Java");
		skipListSet.add("Python");
		skipListSet.add("C++");

		// Ordered Set
		skipListSet.forEach(System.out::println);

		// 4. ConcurrentLinkedQueue Example
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
		queue.offer("Task1");
		queue.offer("Task2");
		queue.offer("Task3");

		while (!queue.isEmpty()) {
			System.out.println("Processing: " + queue.poll());
		}

		// 5. CopyOnWriteArrayList Example
		CopyOnWriteArrayList<String> copyOnWriteList = new CopyOnWriteArrayList<>(List.of("A", "B", "C"));
		for (String s : copyOnWriteList) {
			System.out.println("Reading: " + s);
			copyOnWriteList.add("D"); // Safe but inefficient for frequent writes
		}

		// 6. Parallel Sorting
		String[] words = { "apple", "orange", "banana", "grape" };
		Arrays.parallelSort(words);
		System.out.println("Sorted Words: " + Arrays.toString(words));

		// 7. Parallel Set All
		int[] values = new int[10];
		Arrays.parallelSetAll(values, i -> i * 2);
		System.out.println("Parallel SetAll: " + Arrays.toString(values));

		// 8. Parallel Prefix
		int[] nums = { 1, 2, 3, 4, 5 };
		Arrays.parallelPrefix(nums, (x, y) -> x * y);
		System.out.println("Parallel Prefix: " + Arrays.toString(nums));
	}
}
