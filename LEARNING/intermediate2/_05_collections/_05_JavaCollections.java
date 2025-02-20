package intermediate2._05_collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class _05_JavaCollections {

	// ****
	// * LIST INTERFACE
	// ****
	public static void main(String[] args) {
		// Using ArrayList (array-based, fast access but slow insertions)
		List<String> arrayList = new ArrayList<>();
		ArrayList<String> arrayList2 = new ArrayList<>(); // Not wrong but this is for noobs

		// Principal methods
		arrayList.add("A");
		arrayList.remove("B");
		arrayList.get(1);
		arrayList.set(1, "X");

		System.out.println("ArrayList: " + arrayList);

		// Using LinkedList (node-based, slower access but fast insertions)
		List<String> linkedList = new LinkedList<>(arrayList);
		linkedList.remove(2); // Removes the element at position 2
		linkedList.set(1, "Y"); // Replaces the element at position 1

		System.out.println("LinkedList: " + linkedList);

		// Using ListIterator (subinterface of Interator) to traverse and modify the
		// list
		ListIterator<String> iterator = linkedList.listIterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("Iterating: " + element);
			if (element.equals("Y")) {
				iterator.add("Z"); // Adds "Z" after "Y"
			}
		}

		System.out.println("LinkedList after iteration: " + linkedList);

		// Check if a list supports random access using RandomAccess
		checkRandomAccess(arrayList);
		checkRandomAccess(linkedList);
	}

	public static void checkRandomAccess(List<?> list) {
		// The RandomAccess interface (no methods) was introduced to distinguish whether
		// a collection supports efficient random access
		if (list instanceof RandomAccess) {
			System.out.println(list.getClass().getSimpleName() + " supports efficient random access.");
		} else {
			System.out.println(list.getClass().getSimpleName() + " does not support efficient random access.");
		}
	}

	public static void main2(String[] args) {
		// ****
		// * SET INTERFACE
		// ****

		// Using HashSet (unordered, no duplicates)
		Set<String> hashSet = new HashSet<>();
		hashSet.add("A");
		hashSet.add("B");
		hashSet.add("C");
		hashSet.add("A"); // Duplicate, will be ignored

		System.out.println("HashSet: " + hashSet);

		// Using TreeSet (sorted order, no duplicates)
		Set<String> treeSet = new TreeSet<>(hashSet);
		treeSet.add("D");
		treeSet.add("B"); // Duplicate, ignored

		System.out.println("TreeSet: " + treeSet);

		// Using LinkedHashSet (insertion order, no duplicates)
		Set<String> linkedHashSet = new LinkedHashSet<>(hashSet);
		linkedHashSet.add("E");
		linkedHashSet.add("A"); // Duplicate, ignored

		System.out.println("LinkedHashSet: " + linkedHashSet);

		// Checking hash codes consistency
		checkHashCodeConsistency(hashSet, treeSet, linkedHashSet);
	}

	public static void checkHashCodeConsistency(Set<?>... sets) {
		// The hashCode of equal sets must be the same
		for (Set<?> set : sets) {
			System.out.println(set.getClass().getSimpleName() + " hashCode: " + set.hashCode());
		}
	}

	public static void main3(String[] args) {
		// ****
		// * SORTEDSET AND SORTEDMAP INTERFACE
		// ****

		// Using TreeSet (sorted, no duplicates)
		SortedSet<Integer> sortedSet = new TreeSet<>();
		sortedSet.add(40);
		sortedSet.add(10);
		sortedSet.add(30);
		sortedSet.add(20);
		sortedSet.add(50);

		System.out.println("TreeSet: " + sortedSet);

		// Getting a subset with values less than 50
		SortedSet<Integer> subset = sortedSet.headSet(50);
		System.out.println("Subset (less than 50): " + subset);

		// Using TreeMap (sorted key-value pairs)
		SortedMap<Integer, String> sortedMap = new TreeMap<>();
		sortedMap.put(3, "Three");
		sortedMap.put(1, "One");
		sortedMap.put(2, "Two");
		sortedMap.put(5, "Five");
		sortedMap.put(4, "Four");

		System.out.println("TreeMap: " + sortedMap);

		// Getting a subset of the map with keys less than 4
		SortedMap<Integer, String> subMap = sortedMap.headMap(4);
		System.out.println("SubMap (keys less than 4): " + subMap);
	}

	public static void main4(String[] args) {
		// ****
		// * NAVIGABLESET AND NAVIGABLEMAP INTERFACE
		// ****

		// Using TreeSet (implements NavigableSet)
		NavigableSet<Integer> navigableSet = new TreeSet<>();
		navigableSet.add(10);
		navigableSet.add(20);
		navigableSet.add(30);
		navigableSet.add(40);
		navigableSet.add(50);

		System.out.println("TreeSet: " + navigableSet);

		// Advanced navigation methods
		System.out.println("Lower than 30: " + navigableSet.lower(30));
		System.out.println("Floor of 30: " + navigableSet.floor(30));
		System.out.println("Higher than 30: " + navigableSet.higher(30));
		System.out.println("Ceiling of 30: " + navigableSet.ceiling(30));

		// Using TreeMap (implements NavigableMap)
		NavigableMap<Integer, String> navigableMap = new TreeMap<>();
		navigableMap.put(1, "One");
		navigableMap.put(2, "Two");
		navigableMap.put(3, "Three");
		navigableMap.put(4, "Four");
		navigableMap.put(5, "Five");

		System.out.println("TreeMap: " + navigableMap);

		// Advanced navigation methods in NavigableMap
		System.out.println("Lower key than 3: " + navigableMap.lowerKey(3));
		System.out.println("Floor key of 3: " + navigableMap.floorKey(3));
		System.out.println("Higher key than 3: " + navigableMap.higherKey(3));
		System.out.println("Ceiling key of 3: " + navigableMap.ceilingKey(3));
	}

}
