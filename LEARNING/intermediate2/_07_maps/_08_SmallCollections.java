package intermediate2._07_maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _08_SmallCollections {

	public static void main(String[] args) {
		// Creating immutable collections using Java 9 methods
		List<String> names = List.of("Peter", "Paul", "Mary");
		Set<Integer> numbers = Set.of(2, 3, 5);
		Map<String, Integer> scores = Map.of("Peter", 2, "Paul", 3, "Mary", 5);

		System.out.println("Immutable List: " + names);
		System.out.println("Immutable Set: " + numbers);
		System.out.println("Immutable Map: " + scores);

		// Null elements are not allowed
		Set<Integer> numbers = Set.of(13, null); // Error: IllegalArgumentException

		// Duplicates are not allowed (in Set and Map keys):
		Map<String, Integer> scores = Map.of("Peter", 4, "Peter", 2); // Error: Duplicate key

		// Creating a mutable list from an immutable collection
		List<String> mutableList = new ArrayList<>(List.of("Peter", "Paul", "Mary"));
		mutableList.add("John");
		System.out.println("Mutable List: " + mutableList);

		// Using Collections.nCopies to create a repeated immutable list
		List<String> settings = Collections.nCopies(100, "DEFAULT");
		System.out.println("nCopies List (size: " + settings.size() + "): " + settings.get(0));

		// Using Map.entry as a simple key-value pair
		Map.Entry<String, Integer> pair = Map.entry("Peter", 2);
		System.out.println("Pair: " + pair.getKey() + " - " + pair.getValue());
	}

}