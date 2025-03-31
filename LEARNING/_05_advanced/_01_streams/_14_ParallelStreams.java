package _05_advanced._01_streams;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;
import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class _14_ParallelStreams {

	    public static void main(String[] args) throws IOException {
	        // Read the content of a text file into a list of words
	        String contents = new String(Files.readAllBytes(
	                Paths.get("../gutenberg/alice30.txt")), StandardCharsets.UTF_8);
	        List<String> wordList = Arrays.asList(contents.split("\\PL+"));

	        // Bad practice: Race condition due to concurrent modification of shared array
	        int[] shortWords = new int[10];
	        wordList.parallelStream().forEach(s -> {
	            if (s.length() < 10) shortWords[s.length()]++;
	        });
	        System.out.println("Incorrect count due to race condition: " + Arrays.toString(shortWords));

	        // Proper way: Use groupingBy and counting to avoid concurrency issues
	        Map<Integer, Long> shortWordCounts = wordList.parallelStream()
	                .filter(s -> s.length() < 10)
	                .collect(groupingBy(String::length, counting()));
	        System.out.println("Correct short word count: " + shortWordCounts);

	        // Demonstrating unordered() to improve parallel performance
	        Stream<String> sample = wordList.parallelStream().unordered().limit(10);
	        System.out.println("Sample unordered words: " + sample.collect(toList()));

	        // Using groupingByConcurrent for better parallelism
	        Map<Integer, Long> wordCounts = wordList.parallelStream().collect(
	                groupingByConcurrent(String::length, counting()));
	        System.out.println("Word count with concurrent grouping: " + wordCounts);

	        // Demonstrating why modifying the original collection during stream processing is incorrect
	        try {
	            Stream<String> words = wordList.stream();
	            words.forEach(s -> { if (s.length() < 12) wordList.remove(s); }); // Incorrect: Causes interference
	        } catch (Exception e) {
	            System.out.println("Error due to collection modification: " + e.getMessage());
	        }

	        // Ensure that parallel streams are used only when computational workload is significant
	        long startTime = System.nanoTime();
	        long countSequential = wordList.stream().filter(s -> s.length() > 5).count();
	        long endTime = System.nanoTime();
	        System.out.println("Sequential count time: " + (endTime - startTime) + " ns");

	        startTime = System.nanoTime();
	        long countParallel = wordList.parallelStream().filter(s -> s.length() > 5).count();
	        endTime = System.nanoTime();
	        System.out.println("Parallel count time: " + (endTime - startTime) + " ns");
	    }
	}