package _05_advanced._01_streams;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _02_StreamCreation {

	public static <T> void show(String title, Stream<T> stream) {
		final int SIZE = 10;
		List<T> firstElements = stream.limit(SIZE + 1).collect(Collectors.toList());
		System.out.print(title + ": ");
		for (int i = 0; i < firstElements.size(); i++) {
			if (i > 0)
				System.out.print(", ");
			if (i < SIZE)
				System.out.print(firstElements.get(i));
			else
				System.out.print("...");
		}
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		// Creating a stream from a collection
		List<String> list = Arrays.asList("one", "two", "three", "four");
		Stream<String> collectionStream = list.stream();
		show("Collection Stream", collectionStream);

		// Creating a stream from an array
		Stream<String> arrayStream = Stream.of("apple", "banana", "cherry");
		show("Array Stream", arrayStream);

		// Creating an empty stream
		Stream<String> emptyStream = Stream.empty();
		show("Empty Stream", emptyStream);

		// Creating an infinite stream using generate
		Stream<String> echoStream = Stream.generate(() -> "Echo");
		show("Echo Stream", echoStream);

		Stream<Double> randomStream = Stream.generate(Math::random);
		show("Random Stream", randomStream);

		// Creating an infinite stream using iterate
		Stream<BigInteger> integerStream = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
		show("Integer Stream", integerStream);

		// Creating a stream from a pattern split
		String text = "This is a test sentence with several words.";
		Stream<String> patternStream = Pattern.compile("\\PL+").splitAsStream(text);
		show("Pattern Stream", patternStream);

		// Creating a stream from a file
		Path path = Paths.get("test.txt"); // Change this to a valid file path
		try (Stream<String> fileLines = Files.lines(path, StandardCharsets.UTF_8)) {
			show("File Lines Stream", fileLines);
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}

}
