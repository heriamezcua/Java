package _03_intermediate_II._07_maps;

import java.util.HashMap;

public class _01_Map {
	public static void main(String[] args) {

		// example of use of hashmap

		var staff = new HashMap<String, Employee>();
		var harry = new Employee("Harry Hacker");
		staff.put("987-98-9996", harry);

		// ***
		// Basic operations

		staff.put("987-98-9996", harry);

		Employee e = staff.get("987-98-9996");

		staff.remove("987-98-9996");

		int size = staff.size();

		// ***
		// Handling new keys

		counts.put(word, counts.get(word) + 1); // This can cause problems if the key (word) does not exist yet.

		// Solution:

		// getOrDefault
		int score = scores.getOrDefault(id, 0); // Returns 0 if the key does not exist

		// putIfAbsent
		counts.putIfAbsent(word, 0); // Ensures that there is an initial value of 0
		counts.put(word, counts.get(word) + 1); // It is now safe to update

		// merge (the best)
		counts.merge(word, 1, Integer::sum);

		// ***
		// Loop through keys and values

		scores.forEach((k, v) -> System.out.println("key=" + k + ", value=" + v));

	}
}
