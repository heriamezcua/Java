package _03_intermediate_II._08_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class _01_Algorithms {

	// #
	// # Introduction
	// #
	/**
	 * Generic method to find the maximum element in a collection. This works with
	 * any Collection<T> where T implements Comparable<T>.
	 *
	 * @param <T>        Type parameter extending Comparable
	 * @param collection The collection to search for the maximum element
	 * @return The maximum element found in the collection
	 * @throws NoSuchElementException If the collection is empty
	 */
	public static <T extends Comparable<T>> T max(Collection<T> collection) {
		if (collection.isEmpty())
			throw new NoSuchElementException("Collection is empty");

		Iterator<T> iterator = collection.iterator();
		T largest = iterator.next(); // Initialize with the first element

		while (iterator.hasNext()) {
			T next = iterator.next();
			if (largest.compareTo(next) < 0) {
				largest = next; // Update largest if a greater element is found
			}
		}

		return largest; // Return the maximum element found
	}

	public static void main(String[] args) {
		// Example with ArrayList
		List<Integer> numbers = Arrays.asList(10, 20, 5, 30, 25);
		System.out.println("Max in numbers: " + max(numbers)); // Output: 30

		// Example with LinkedList
		LinkedList<String> words = new LinkedList<>(Arrays.asList("apple", "orange", "banana", "peach"));
		System.out.println("Max in words: " + max(words)); // Output: peach (lexicographically largest)
	}

	// #
	// # Sorting and Shuffling
	// #
	/**
	 * Sorts a list using Collections.sort. Elements must implement Comparable.
	 *
	 * @param list The list to be sorted
	 */
	public static <T extends Comparable<T>> void sortList(List<T> list) {
		Collections.sort(list);
	}

	/**
	 * Sorts a list using a custom comparator.
	 *
	 * @param list       The list to be sorted
	 * @param comparator The comparator defining the sorting order
	 */
	public static <T> void sortListWithComparator(List<T> list, Comparator<T> comparator) {
		list.sort(comparator);
	}

	/**
	 * Shuffles a list randomly.
	 *
	 * @param list The list to be shuffled
	 */
	public static void shuffleList(List<?> list) {
		Collections.shuffle(list);
	}

	public static void main2(String[] args) {
		// Example: Sorting strings
		List<String> staff = new LinkedList<>(Arrays.asList("Alice", "Charlie", "Bob"));
		sortList(staff);
		System.out.println("Sorted staff: " + staff);

		// Example: Sorting with a custom comparator (Descending order)
		sortListWithComparator(staff, Comparator.reverseOrder());
		System.out.println("Sorted staff (descending): " + staff);

		// Example: Shuffling elements
		shuffleList(staff);
		System.out.println("Shuffled staff: " + staff);
	}

	// #
	// # Binary Search
	// #
	/**
	 * Performs a binary search on a sorted list using the natural ordering.
	 *
	 * @param list The sorted list to search in
	 * @param key  The element to search for
	 * @return The index of the element if found, otherwise -1
	 */
	public static <T extends Comparable<T>> int binarySearch(List<T> list, T key) {
		int index = Collections.binarySearch(list, key);
		return index >= 0 ? index : -1;
	}

	/**
	 * Performs a binary search on a sorted list using a custom comparator.
	 *
	 * @param list       The sorted list to search in
	 * @param key        The element to search for
	 * @param comparator The comparator defining the sorting order
	 * @return The index of the element if found, otherwise -1
	 */
	public static <T> int binarySearchWithComparator(List<T> list, T key, Comparator<T> comparator) {
		int index = Collections.binarySearch(list, key, comparator);
		return index >= 0 ? index : -1;
	}

	public static void main3(String[] args) {
		// Example: Binary search in a sorted list
		List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9, 11);
		System.out.println("Index of 5: " + binarySearch(numbers, 5)); // Output: Index of 5: 2
		System.out.println("Index of 6: " + binarySearch(numbers, 6)); // Output: Index of 6: -1

		// Example: Binary search with a custom comparator (reverse order)
		List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
		Comparator<String> reverseOrder = Comparator.reverseOrder();
		words.sort(reverseOrder);
		System.out.println(
				"Index of 'banana' (reverse order): " + binarySearchWithComparator(words, "banana", reverseOrder));
	}

	// #
	// # Simple Algorithms
	// #
	/**
	 * Finds the minimum element in a collection.
	 */
	public static <T extends Comparable<T>> T min(Collection<T> elements) {
		return Collections.min(elements);
	}

	/**
	 * Finds the maximum element in a collection.
	 */
	public static <T extends Comparable<T>> T max(Collection<T> elements) {
		return Collections.max(elements);
	}

	/**
	 * Finds the minimum element using a custom comparator.
	 */
	public static <T> T min(Collection<T> elements, Comparator<? super T> c) {
		return Collections.min(elements, c);
	}

	/**
	 * Finds the maximum element using a custom comparator.
	 */
	public static <T> T max(Collection<T> elements, Comparator<? super T> c) {
		return Collections.max(elements, c);
	}

	/**
	 * Copies elements from one list to another.
	 */
	public static <T> void copy(List<? super T> to, List<T> from) {
		Collections.copy(to, from);
	}

	/**
	 * Fills a list with a constant value.
	 */
	public static <T> void fill(List<? super T> l, T value) {
		Collections.fill(l, value);
	}

	/**
	 * Replaces all occurrences of a value in a list.
	 */
	public static <T> boolean replaceAll(List<T> l, T oldValue, T newValue) {
		return Collections.replaceAll(l, oldValue, newValue);
	}

	/**
	 * Reverses the order of a list.
	 */
	public static void reverse(List<?> l) {
		Collections.reverse(l);
	}

	/**
	 * Rotates a list by a given distance.
	 */
	public static void rotate(List<?> l, int distance) {
		Collections.rotate(l, distance);
	}

	/**
	 * Counts the frequency of an element in a collection.
	 */
	public static int frequency(Collection<?> c, Object o) {
		return Collections.frequency(c, o);
	}

	/**
	 * Checks if two collections have no elements in common.
	 */
	public static boolean disjoint(Collection<?> c1, Collection<?> c2) {
		return Collections.disjoint(c1, c2);
	}

	public static void main4(String[] args) {
		List<String> list = new ArrayList<>(List.of("Java", "C++", "C++"));
		replaceAll(list, "C++", "Python");
		System.out.println("Replaced list: " + list);

		List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
		rotate(numbers, 1);
		System.out.println("Rotated list: " + numbers);

		List<Integer> list1 = List.of(1, 2, 3);
		List<Integer> list2 = List.of(4, 5, 6);
		System.out.println("Disjoint: " + disjoint(list1, list2));
	}

	// #
	// # Bulk Operations
	// #
	/**
	 * Removes all elements in the collection that are also present in another
	 * collection.
	 */
	public static <T> void removeAll(Collection<T> collection, Collection<?> elementsToRemove) {
		collection.removeAll(elementsToRemove);
	}

	/**
	 * Retains only the elements in the collection that are also present in another
	 * collection.
	 */
	public static <T> void retainAll(Collection<T> collection, Collection<?> elementsToRetain) {
		collection.retainAll(elementsToRetain);
	}

	/**
	 * Adds all elements from one collection to another.
	 */
	public static <T> void addAll(Collection<T> collection, Collection<? extends T> elementsToAdd) {
		collection.addAll(elementsToAdd);
	}

	/**
	 * Creates a sublist view from a given list.
	 */
	public static <T> List<T> subList(List<T> list, int fromIndex, int toIndex) {
		return list.subList(fromIndex, toIndex);
	}

	/**
	 * Removes all keys in the map that are also present in the given collection.
	 */
	public static <K, V> void removeKeys(Map<K, V> map, Collection<?> keysToRemove) {
		map.keySet().removeAll(keysToRemove);
	}

	public static void main5(String[] args) {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		removeAll(numbers, Arrays.asList(2, 4));
		System.out.println("After removeAll: " + numbers);

		List<String> words = new ArrayList<>(Arrays.asList("apple", "banana", "cherry"));
		retainAll(words, Arrays.asList("banana", "cherry"));
		System.out.println("After retainAll: " + words);

		List<String> moreWords = new ArrayList<>(Arrays.asList("date", "elderberry"));
		addAll(words, moreWords);
		System.out.println("After addAll: " + words);

		List<String> subList = subList(words, 1, 3);
		System.out.println("Sublist: " + subList);

		Map<String, Integer> map = new HashMap<>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 3);
		removeKeys(map, Arrays.asList("A", "C"));
		System.out.println("After removeKeys: " + map);
	}

	// #
	// # Collection-Array Conversion
	// #
	/**
	 * Converts an array to an immutable List.
	 */
	public static <T> List<T> arrayToCollection(T[] array) {
		return List.of(array);
	}

	/**
	 * Converts a collection to an Object array.
	 */
	public static Object[] collectionToObjectArray(Collection<?> collection) {
		return collection.toArray();
	}

	/**
	 * Converts a collection to a typed array.
	 */
	public static <T> T[] collectionToTypedArray(Collection<T> collection, T[] array) {
		return collection.toArray(array);
	}

	public static void main6(String[] args) {
		// Example: Array to Collection
		String[] namesArray = { "Alice", "Bob", "Charlie" };
		List<String> staffList = arrayToCollection(namesArray);
		System.out.println("Array to Collection: " + staffList);

		// Example: Collection to Object array
		List<String> staff = List.of("Alice", "Bob", "Charlie");
		Object[] objectArray = collectionToObjectArray(staff);
		System.out.println("Collection to Object array: " + Arrays.toString(objectArray));

		// Example: Collection to Typed array
		String[] typedArray = collectionToTypedArray(staff, new String[0]);
		System.out.println("Collection to Typed array: " + Arrays.toString(typedArray));
	}

}
