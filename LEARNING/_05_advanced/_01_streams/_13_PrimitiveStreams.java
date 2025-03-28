package _05_advanced._01_streams;

import java.util.*;
import java.util.stream.*;

public class _13_PrimitiveStreams {

	public static void main(String[] args) {
		// Creating IntStream using of() and range methods
		IntStream intStream1 = IntStream.of(1, 2, 3, 4, 5);
		IntStream intStream2 = IntStream.range(1, 6); // Excludes 6
		IntStream intStream3 = IntStream.rangeClosed(1, 5); // Includes 5

		// Generating streams using generate() and iterate()
		IntStream randomInts = IntStream.generate(() -> (int) (Math.random() * 100)).limit(5);
		IntStream evenNumbers = IntStream.iterate(0, n -> n + 2).limit(5);

		// Converting Object Stream to Primitive Stream
		Stream<String> words = Stream.of("Java", "Streams", "API");
		IntStream wordLengths = words.mapToInt(String::length);

		// Converting Primitive Stream to Object Stream
		Stream<Integer> boxedInts = IntStream.range(1, 6).boxed();

		// Using reduction methods
		int sum = IntStream.rangeClosed(1, 5).sum();
		OptionalDouble avg = IntStream.rangeClosed(1, 5).average();
		OptionalInt max = IntStream.rangeClosed(1, 5).max();
		OptionalInt min = IntStream.rangeClosed(1, 5).min();

		// Summary statistics
		IntSummaryStatistics stats = IntStream.rangeClosed(1, 5).summaryStatistics();

		// Generating a stream of random numbers
		IntStream randomNumbers = new Random().ints(5, 1, 100);

		// Processing Unicode characters using codePoints()
		String sentence = "\uD835\uDD46 is the set of octonions.";
		IntStream unicodeStream = sentence.codePoints();

		// Printing results
		System.out.println("IntStream.of: " + Arrays.toString(intStream1.toArray()));
		System.out.println("IntStream.range: " + Arrays.toString(intStream2.toArray()));
		System.out.println("IntStream.rangeClosed: " + Arrays.toString(intStream3.toArray()));
		System.out.println("Random IntStream: " + Arrays.toString(randomInts.toArray()));
		System.out.println("Even Numbers: " + Arrays.toString(evenNumbers.toArray()));
		System.out.println("Word Lengths: " + Arrays.toString(wordLengths.toArray()));
		System.out.println("Boxed IntStream: " + boxedInts.collect(Collectors.toList()));
		System.out.println("Sum: " + sum);
		avg.ifPresent(value -> System.out.println("Average: " + value));
		max.ifPresent(value -> System.out.println("Max: " + value));
		min.ifPresent(value -> System.out.println("Min: " + value));
		System.out.println("Statistics: " + stats);
		System.out.println("Random Numbers: " + Arrays.toString(randomNumbers.toArray()));
		System.out.println("Unicode Code Points: "
				+ unicodeStream.mapToObj(c -> String.format("%X", c)).collect(Collectors.joining(" ")));
	}
}
