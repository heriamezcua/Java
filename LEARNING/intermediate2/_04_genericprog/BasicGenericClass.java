package intermediate2._04_genericprog;

// We need to specify <T> to use type variables
public class BasicGenericClass<T> {

	// Type variables T
	private T first;
	private T second;

	public BasicGenericClass() {
		first = null;
		second = null;
	}

	public BasicGenericClass(T first, T second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public T getSecond() {
		return second;
	}

	public void setFirst(T newValue) {
		first = newValue;
	}

	public void setSecond(T newValue) {
		second = newValue;
	}

	// Main method for class testing
	public static void main(String[] args) {
		// El código puede manejar cualquier tipo de dato

		// String
		BasicGenericClass<String> pair = new BasicGenericClass<>("Hello", "World");
		System.out.println(pair.getFirst()); // Output: Hello
		System.out.println(pair.getSecond()); // Output: World

		// Integer
		BasicGenericClass<Integer> pairInteger = new BasicGenericClass<>(33, 256);
		System.out.println(pairInteger.getFirst()); // Output: 33
		System.out.println(pairInteger.getSecond()); // Output: 256
	}
}
