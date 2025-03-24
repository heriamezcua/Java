package _05_advanced._01_streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class _04_StreamOperations {

	public static void main(String[] args) {
		// 1. Using limit() to restrict stream size
		System.out.println("Using limit:");
		Stream<Double> randomNumbers = Stream.generate(Math::random).limit(10);
		randomNumbers.forEach(System.out::println); // Prints 10 random numbers

		// 2. Using skip() to remove the first element
		System.out.println("\nUsing skip:");
		String contents = " first second third fourth";
		Stream<String> words = Stream.of(contents.split("\\PL+")).skip(1);
		words.forEach(System.out::println); // Skips the first empty element

		// 3. Using concat() to merge two streams
		System.out.println("\nUsing concat:");
		Stream<String> combined = Stream.concat(letters("Hello"), letters("World"));
		combined.forEach(System.out::print); // Prints: HelloWorld
	}

	// Helper function to split a word into individual letters as a stream
	public static Stream<String> letters(String s) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			result.add(s.substring(i, i + 1));
		}
		return result.stream();
	}
}
