package _05_advanced._01_streams;

import java.util.Arrays;
import java.util.List;

public class _01_StreamVsIteration {

	private static final String TEXT = "This is an example text containing several words of different lengths including supercalifragilisticexpialidocious";

	public static void main(String[] args) {
		List<String> words = Arrays.asList(TEXT.split("\\PL+"));

		// Counts words longer than 12 characters using a traditional loop
		long loopCount = 0;
		for (String w : words) {
			if (w.length() > 12)
				loopCount++;
		}

		// Counts words longer than 12 characters using a stream
		long streamCount = words.stream().filter(w -> w.length() > 12).count();

		// Counts words longer than 12 characters using a parallel stream
		long parallelStreamCount = words.parallelStream().filter(w -> w.length() > 12).count();

		System.out.println("Count using loop: " + loopCount);
		System.out.println("Count using stream: " + streamCount);
		System.out.println("Count using parallel stream: " + parallelStreamCount);
	}

}
