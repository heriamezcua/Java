package _05_advanced._01_streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _08_StreamCollector {

	public static void main(String[] args) {
		// Creating a sample stream
		Stream<String> stream = Stream.of("apple", "banana", "cherry", "date", "elderberry");

		// 1. Using iterator() to manually traverse elements
		Iterator<String> iterator = stream.iterator();
		System.out.println("Using iterator:");
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		// 2. Using forEach() (may not maintain order in parallel streams)
		System.out.println("\nUsing forEach:");
		Stream.of("apple", "banana", "cherry", "date", "elderberry").forEach(System.out::println);

		// 3. Using forEachOrdered() to maintain order
		System.out.println("\nUsing forEachOrdered:");
		Stream.of("apple", "banana", "cherry", "date", "elderberry").parallel().forEachOrdered(System.out::println);

		// 4. Collecting elements into different data structures
		List<String> list = Stream.of("apple", "banana", "cherry").collect(Collectors.toList());
		System.out.println("\nCollected as List: " + list);

		Set<String> set = Stream.of("apple", "banana", "cherry").collect(Collectors.toSet());
		System.out.println("Collected as Set: " + set);

		TreeSet<String> treeSet = Stream.of("apple", "banana", "cherry").collect(Collectors.toCollection(TreeSet::new));
		System.out.println("Collected as TreeSet: " + treeSet);

		// 5. Collecting elements into an array
		String[] array = Stream.of("apple", "banana", "cherry").toArray(String[]::new);
		System.out.println("Collected as Array: " + Arrays.toString(array));

		// 6. Joining elements into a single string
		String joined = Stream.of("apple", "banana", "cherry").collect(Collectors.joining());
		System.out.println("\nJoined String: " + joined);

		String joinedWithComma = Stream.of("apple", "banana", "cherry").collect(Collectors.joining(", "));
		System.out.println("Joined String with commas: " + joinedWithComma);

		// 7. Summarizing statistics (word lengths)
		IntSummaryStatistics stats = Stream.of("apple", "banana", "cherry")
				.collect(Collectors.summarizingInt(String::length));

		System.out.println("\nSummary Statistics:");
		System.out.println("Total Count: " + stats.getCount());
		System.out.println("Total Sum of Lengths: " + stats.getSum());
		System.out.println("Average Word Length: " + stats.getAverage());
		System.out.println("Max Word Length: " + stats.getMax());
		System.out.println("Min Word Length: " + stats.getMin());
	}
}
