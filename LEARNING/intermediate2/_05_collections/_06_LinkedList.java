package intermediate2._05_collections;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class _06_LinkedList {
	public static void main(String[] args) {
		// ****
		// * LINKEDLIST
		// ****

		// Creating a LinkedList
		LinkedList<String> list = new LinkedList<>();
		list.add("Amy");
		list.add("Bob");
		list.add("Carl");

		System.out.println("Initial LinkedList: " + list);

		// Using an iterator to traverse and remove an element
		Iterator<String> iter = list.iterator();
		iter.next(); // Move to "Amy"
		iter.next(); // Move to "Bob"
		iter.remove(); // Remove "Bob"

		System.out.println("After removing second element: " + list);

		// Using ListIterator to modify elements
		ListIterator<String> listIter = list.listIterator();
		while (listIter.hasNext()) {
			String element = listIter.next();
			if (element.equals("Amy")) {
				listIter.set("Alice"); // Replace "Amy" with "Alice"
			}
		}

		System.out.println("After modification: " + list);

		// add() at different positions
		listIter = list.listIterator();
		listIter.add("Zara"); // Add at the beginning
		while (listIter.hasNext())
			listIter.next();
		listIter.add("David"); // Add at the end

		System.out.println("After adding elements: " + list);

		// .contains() method
		System.out.println("List contains 'Carl': " + list.contains("Carl"));

		// Demonstrating inefficient random access
		System.out.println("Element at index 2: " + list.get(2));

		// ConcurrentModificationException
		try {
			ListIterator<String> iter1 = list.listIterator();
			ListIterator<String> iter2 = list.listIterator();
			iter1.next(); // Move iter1
			iter1.remove(); // Modify list
			iter2.next(); // Causes ConcurrentModificationException
		} catch (ConcurrentModificationException e) {
			System.out.println("ConcurrentModificationException detected!");
		}

		// Merging two lists
		LinkedList<String> a = new LinkedList<>(List.of("A", "C", "E"));
		LinkedList<String> b = new LinkedList<>(List.of("B", "D", "F"));

		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();

		while (bIter.hasNext()) {
			if (aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}

		System.out.println("Merged list: " + a);

		// Removing all elements of b from a
		a.removeAll(b);
		System.out.println("List after removing elements of b: " + a);
	}
}
