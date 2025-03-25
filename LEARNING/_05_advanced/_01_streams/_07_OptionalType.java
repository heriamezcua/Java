package _05_advanced._01_streams;

import java.util.Optional;

public class _07_OptionalType {

	public static void main(String[] args) {
		// Example: Creating Optional values
		Optional<String> optionalPresent = Optional.of("Hello, Optional!");
		Optional<String> optionalEmpty = Optional.empty();
		Optional<String> optionalNullable = Optional.ofNullable(null);

		// Accessing values safely
		System.out.println(optionalPresent.orElse("Default Value")); // Prints actual value
		System.out.println(optionalEmpty.orElse("Default Value")); // Prints "Default Value"

		// Using orElseGet to compute value lazily
		System.out.println(optionalEmpty.orElseGet(() -> "Computed Value"));

		// Using orElseThrow to throw an exception if empty
		try {
			System.out.println(optionalEmpty.orElseThrow(IllegalStateException::new));
		} catch (Exception e) {
			System.out.println("Exception caught: " + e);
		}

		// Using ifPresent to consume a value if present
		optionalPresent.ifPresent(value -> System.out.println("Value is present: " + value));
		optionalEmpty.ifPresent(value -> System.out.println("This won't print"));

		// Transforming Optional values using map
		Optional<Integer> stringLength = optionalPresent.map(String::length);
		System.out.println("Length of string: " + stringLength.orElse(0));

		// Chaining Optionals using flatMap
		Optional<Double> result = Optional.of(4.0).flatMap(_07_OptionalType::inverse)
				.flatMap(_07_OptionalType::squareRoot);
		System.out.println("Result of inverse and square root: " + result);

		// Demonstrating bad practices
		if (optionalPresent.isPresent()) {
			System.out.println(optionalPresent.get()); // Unsafe access
		}
	}

	// Method that returns an Optional inverse value
	public static Optional<Double> inverse(Double x) {
		return x == 0 ? Optional.empty() : Optional.of(1 / x);
	}

	// Method that returns an Optional square root
	public static Optional<Double> squareRoot(Double x) {
		return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
	}
}
