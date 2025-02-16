package intermediate2._04_genericprog;

public class MultipleTypesGenericClass<T, U> {

	private T first;
	private U second;

	public MultipleTypesGenericClass(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}
	
	public static void main(String[] args) {
		// We have a class with multiple Generic Types
		MultipleTypesGenericClass<String, Integer> pair = new MultipleTypesGenericClass<>("Age", 30);
		System.out.println(pair.getFirst()); // Output: Age
		System.out.println(pair.getSecond()); // Output: 30
	}

}
