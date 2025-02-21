package intermediate2._07_maps;

import java.util.Collection;
import java.util.Set;

public class _02_MapViews {

	public static void main(String[] args) {

		// ****
		// A Map in Java is not considered a collection directly, but it offers three
		// views that do function as collections.

		// The three main views of a map:

		// keySet
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key);
		}

		// values
		Collection<Employee> employees = map.values();
		for (Employee e : employees) {
			System.out.println(e);
		}

		// entrySet
		for (Map.Entry<String, Employee> entry : map.entrySet()) {
			System.out.println("Key: " + entry.getKey());
			System.out.println("Value: " + entry.getValue());
		}

		// ****
		// Important Restrictions

		// Remove elements in keySet
		keys.remove("key1"); // Remove "key1" and its associated value from the map

		// You cannot add items directly to views (keySet, entrySet).
		keys.add("newKey"); // Will throw UnsupportedOperationException

	}
}
