package _05_advanced._01_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class _05_DistinctSortedPeek {

	public static void main(String[] args) {
		// Testing distinct() method
		System.out.println("Testing distinct():");
		Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
		uniqueWords.forEach(System.out::println); // Output: merrily, gently

		// Testing sorted() with Comparable elements (natural order)
		System.out.println("\nTesting sorted() with natural order:");
		Stream<Integer> sortedNumbers = Stream.of(5, 2, 8, 1, 3).sorted();
		sortedNumbers.forEach(System.out::println); // Output: 1, 2, 3, 5, 8

		// Testing sorted() with Comparator (sorting by length descending)
		System.out.println("\nTesting sorted() with custom Comparator:");
		List<String> words = Arrays.asList("short", "medium", "longer", "longest");
		Stream<String> longestFirst = words.stream().sorted(Comparator.comparing(String::length).reversed());
		longestFirst.forEach(System.out::println); // Output: longest, longer, medium, short

		// Testing peek() method (useful for debugging)
		System.out.println("\nTesting peek():");
		Object[] powers = Stream.iterate(1.0, p -> p * 2) // Generates an infinite stream of powers of 2
				.peek(e -> System.out.println("Fetching " + e)) // Prints each fetched element
				.limit(10) // Limits to 10 elements
				.toArray();

		// Printing final result of the peek() test
		System.out.println("\nFinal collected values:");
		System.out.println(Arrays.toString(powers));
	}
}
