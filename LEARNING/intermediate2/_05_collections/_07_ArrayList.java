package intermediate2._05_collections;

import java.util.ArrayList;

public class _07_ArrayList {
	public static void main(String[] args) {
		// Creating an ArrayList of Strings
		ArrayList<String> names = new ArrayList<>();

		// Adding elements to the ArrayList
		names.add("Ana");
		names.add("Carlos");
		names.add("Beatriz");
		names.add("David");

		// Accessing elements by index
		System.out.println("Element at position 2: " + names.get(2)); // Beatriz

		// Iterating through the ArrayList using for-each loop
		System.out.println("Iteration using for-each loop:");
		for (String name : names) {
			System.out.println(name);
		}

		// Iterating through the ArrayList using a classic for loop with indices
		System.out.println("Iteration using classic for loop:");
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}

		// Removing an element from the ArrayList
		names.remove("Carlos");
		System.out.println("After removing 'Carlos': " + names);
	}
}
