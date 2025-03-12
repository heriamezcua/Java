package _03_intermediate_II._07_maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class _07_CopiesAndViews {

	public static void main(String[] args) {
		// #
		// # Copies and Views
		// #
		// Create a HashMap with some values
		Map<String, Integer> scores = new HashMap<>();
		scores.put("Alice", 90);
		scores.put("Bob", 85);
		scores.put("Charlie", 88);

		// Obtain a view of the keys
		Set<String> keySet = scores.keySet();
		System.out.println("Original keys: " + keySet);

		// Remove an element from the view
		keySet.remove("Alice");
		System.out.println("Keys after removal: " + keySet);
		System.out.println("Map after removal: " + scores);

		// Attempt to add a new element (will throw an exception)
		try {
			keySet.add("David"); // UnsupportedOperationException
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot add new elements to keySet view.");
		}

		// #
		// # Small Collections
		// #
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

		// #
		// # Unmodifiable copies and views
		// #
		// Using copyOf to create an immutable copy
		List<String> names = new ArrayList<>(List.of("Peter", "Paul", "Mary"));
		Set<String> nameSet = Set.copyOf(names);
		List<String> nameList = List.copyOf(names);

		System.out.println("Immutable Set: " + nameSet);
		System.out.println("Immutable List: " + nameList);

		// Attempt to modify immutable collections (will throw exception)
		try {
			nameList.add("John");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify immutable list.");
		}

		// Using Collections.unmodifiableXXX
		var staff = new LinkedList<String>();
		staff.add("Alice");
		staff.add("Bob");

		List<String> unmodifiableStaff = Collections.unmodifiableList(staff);
		System.out.println("Unmodifiable List: " + unmodifiableStaff);

		try {
			unmodifiableStaff.add("Charlie");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify unmodifiable list.");
		}

		// Changes in original collection reflect in the unmodifiable view
		staff.add("Charlie");
		System.out.println("Updated Unmodifiable List: " + unmodifiableStaff);

		// #
		// # Subranges
		// #
		// Subrange in List using subList
		List<String> staff = new ArrayList<>(
				List.of("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hannah", "Ian", "Jack", "Karen",
						"Leo", "Mona", "Nancy", "Oscar", "Paul", "Quinn", "Rachel", "Steve", "Tom"));
		List<String> group2 = staff.subList(10, 15);
		System.out.println("SubList: " + group2);

		// Changes in subList affect the original list
		group2.set(0, "Kevin");
		System.out.println("Updated staff list: " + staff);

		// Subrange in SortedSet
		SortedSet<Integer> numbers = new TreeSet<>(Set.of(10, 20, 30, 40, 50));
		SortedSet<Integer> subset = numbers.subSet(20, 40);
		SortedSet<Integer> headset = numbers.headSet(30);
		SortedSet<Integer> tailset = numbers.tailSet(30);
		System.out.println("Subset: " + subset);
		System.out.println("HeadSet: " + headset);
		System.out.println("TailSet: " + tailset);

		// Subrange in SortedMap
		SortedMap<String, String> people = new TreeMap<>();
		people.put("Alice", "Manager");
		people.put("Bob", "Developer");
		people.put("Charlie", "Intern");
		SortedMap<String, String> submap = people.subMap("Alice", "Charlie");
		SortedMap<String, String> headmap = people.headMap("Bob");
		SortedMap<String, String> tailmap = people.tailMap("Bob");
		System.out.println("SubMap: " + submap);
		System.out.println("HeadMap: " + headmap);
		System.out.println("TailMap: " + tailmap);

		// Subrange with NavigableSet
		NavigableSet<Integer> navNumbers = new TreeSet<>(Set.of(10, 20, 30, 40, 50));
		NavigableSet<Integer> navSubset = navNumbers.subSet(20, true, 40, false);
		NavigableSet<Integer> navHeadset = navNumbers.headSet(30, true);
		NavigableSet<Integer> navTailset = navNumbers.tailSet(30, false);
		System.out.println("Navigable Subset: " + navSubset);
		System.out.println("Navigable HeadSet: " + navHeadset);
		System.out.println("Navigable TailSet: " + navTailset);

		// #
		// # Optional Operations
		// #
		// Creating a read-only list using List.of()
		List<String> readOnlyList = List.of("Alice", "Bob", "Charlie");
		System.out.println("Read-only List: " + readOnlyList);

		// Attempting to modify the read-only list (will throw
		// UnsupportedOperationException)
		try {
			readOnlyList.add("David");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify read-only list: add operation not supported.");
		}

		// Creating a modifiable list
		List<String> modifiableList = new ArrayList<>(readOnlyList);
		modifiableList.add("David");
		System.out.println("Modifiable List after addition: " + modifiableList);

		// Creating an unmodifiable view of a list
		List<String> unmodifiableList = Collections.unmodifiableList(modifiableList);
		System.out.println("Unmodifiable List: " + unmodifiableList);

		// Attempting to modify the unmodifiable list (will throw
		// UnsupportedOperationException)
		try {
			unmodifiableList.remove("Alice");
		} catch (UnsupportedOperationException e) {
			System.out.println("Cannot modify unmodifiable list: remove operation not supported.");
		}

		// Creating an iterator from an unmodifiable list
		Iterator<String> iterator = unmodifiableList.iterator();
		while (iterator.hasNext()) {
			System.out.println("Iterating: " + iterator.next());
		}
	}

}