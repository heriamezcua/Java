package intermediate2._05_collections;

public class _03_UsefulMethods {

	public static void main(String[] args) {
		// Basic operations
		size();
		isEmpty();
		contains(Object obj);
		clear(Object obj);
		
		// Element manipulation
		add(E element);
		addAll(Collection<? extends E> other);
		remove(Object obj);
		removeAll(Collection<?> other);
		retainAll(Collection<?> other);
		removeIf(Predicate<? super E> filter);
		
		// Conversion
		toArray()
	}
}
