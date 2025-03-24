package _05_advanced._01_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class _03_FilterMapFlatMap {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("stream", "functional", "programming", "java", "lambda", "monads",
				"flatMap");

		// 1. FILTER: Select words with more than 6 letters
		Stream<String> longWords = words.stream().filter(w -> w.length() > 6);
		System.out.println("Long words:");
		longWords.forEach(System.out::println);

		// 2. MAP: Convert words to lowercase
		Stream<String> lowercaseWords = words.stream().map(String::toLowerCase);
		System.out.println("\nLowercase words:");
		lowercaseWords.forEach(System.out::println);

		// 3. MAP: Extract first letter of each word
		Stream<String> firstLetters = words.stream().map(s -> s.substring(0, 1));
		System.out.println("\nFirst letters:");
		firstLetters.forEach(System.out::println);

		// 4. FLATMAP: Convert words into a stream of letters
		Stream<String> flatResult = words.stream().flatMap(_03_FilterMapFlatMap::letters);
		System.out.println("\nFlattened letters:");
		flatResult.forEach(System.out::print); // Print in one line for clarity
		System.out.println();
	}

	// Function to split a word into a stream of its letters
	public static Stream<String> letters(String s) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			result.add(s.substring(i, i + 1));
		}
		return result.stream();
	}
}
