package intermediate2._05_collections;

import java.util.function.Consumer;

public class _02_Iterators {
	// Collection Interface
	public interface Collection<E> {

		boolean add(E element);

		Iterator<E> iterator();

	}

	// Iterator interface
	public interface Iterator<E> {
		E next();

		boolean hasNext();

		void remove();

		default void forEachRemaining(Consumer<? super E> action);
	}

	public static void main(String[] args) {
		
		// Iterators basic use
		Collection<String> c = ...;
		Iterator<String> iter = c.iterator();

		for (String element : c) {
		    // Do something with element
		}
		
		
		// *** Loop order
		
		// The order in which elements are visited depends on the type of collection
		
		
		// ** Next and Remove order
		
		Iterator<String> it = c.iterator();
		it.next(); // Move to the first element
		it.remove(); // Remove it
		
		
		// ** .forEachRemaining()
		
		// This method solves having to iterate elements manually
		
		// This problem
		it.next(); // Go to next
		it.next(); // Go to next
		it.next(); // Go to next
		
	}
}
