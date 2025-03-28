package _05_advanced._01_streams;

import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class _12_ReductionOperations {
    public static void main(String[] args) {
        // Sample list of integers
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);

        // Basic Reduction: Summing values (returns Optional)
        Optional<Integer> optionalSum = values.stream().reduce((x, y) -> x + y);
        optionalSum.ifPresent(sum -> System.out.println("Optional Sum: " + sum));

        // Using identity value to handle empty streams
        int sumWithIdentity = values.stream().reduce(0, (x, y) -> x + y);
        System.out.println("Sum with Identity: " + sumWithIdentity);

        // Associative operation: Finding the maximum value
        Optional<Integer> maxValue = values.stream().reduce(Integer::max);
        maxValue.ifPresent(max -> System.out.println("Max Value: " + max));

        // Associative operation: Finding the minimum value
        Optional<Integer> minValue = values.stream().reduce(Integer::min);
        minValue.ifPresent(min -> System.out.println("Min Value: " + min));

        // Reduction with different types: Summing string lengths
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        int totalLength = words.stream().reduce(0,
            (total, word) -> total + word.length(), // Accumulator
            Integer::sum // Combiner for parallel streams
        );
        System.out.println("Total Length of Words: " + totalLength);

        // Alternative approach using mapToInt for efficiency
        int totalLengthMap = words.stream().mapToInt(String::length).sum();
        System.out.println("Total Length using mapToInt: " + totalLengthMap);

        // Example where reduce is not enough: Using collect with BitSet
        Stream<Integer> bitStream = Stream.of(1, 2, 3, 5, 8);
        BitSet bitSet = bitStream.collect(BitSet::new, BitSet::set, BitSet::or);
        System.out.println("BitSet Result: " + bitSet);
    }
}
