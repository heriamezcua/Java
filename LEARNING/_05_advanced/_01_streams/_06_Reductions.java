package _05_advanced._01_streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class _06_Reductions {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig", "grape");

		// Count elements in the stream
		long count = words.stream().count();
		System.out.println("Count: " + count);

		// Find the longest word using max()
		Optional<String> longestWord = words.stream().max(Comparator.comparing(String::length));
		System.out.println("Longest word: " + longestWord.orElse("No words"));

		// Find the shortest word using min()
		Optional<String> shortestWord = words.stream().min(Comparator.comparing(String::length));
		System.out.println("Shortest word: " + shortestWord.orElse("No words"));

		// Find the first word that starts with 'c'
		Optional<String> startsWithC = words.stream().filter(s -> s.startsWith("c")).findFirst();
		System.out.println("First word starting with 'c': " + startsWithC.orElse("Not found"));

		// Find any word that starts with 'b' (useful for parallel streams)
		Optional<String> startsWithB = words.parallelStream().filter(s -> s.startsWith("b")).findAny();
		System.out.println("Any word starting with 'b': " + startsWithB.orElse("Not found"));

		// Check if any word starts with 'g'
		boolean anyStartsWithG = words.stream().anyMatch(s -> s.startsWith("g"));
		System.out.println("Any word starts with 'g': " + anyStartsWithG);

		// Check if all words are lowercase
		boolean allLowerCase = words.stream().allMatch(s -> s.equals(s.toLowerCase()));
		System.out.println("All words are lowercase: " + allLowerCase);

		// Check if no word starts with 'z'
		boolean noneStartsWithZ = words.stream().noneMatch(s -> s.startsWith("z"));
		System.out.println("No word starts with 'z': " + noneStartsWithZ);
	}
}
