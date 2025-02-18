package intermediate2._04_genericprog;

import java.io.Serializable;

public class _06_GenericProg2 {

	// It is not necessary for the class to be generic to have generic methods.
	public static <T> T getMiddle(T... a) {
		return a[a.length / 2];
	}

	// Calling to generic methods
	public static void main(String[] args) {
		String middle = _06_GenericProg2.<String>getMiddle("John", "Q.", "Public");
		
		// Restictions and limitations
		
		// ** Primitive types are not allowed
		//_02_BasicGenericClass<double> pair; // ERROR

		_02_BasicGenericClass<Double> pair; // Correct
		
		// **Runtime type inspection only works with raw types
		//if (a instanceof Pair<String>) // ERROR

		//if (a instanceof Pair) // Correct
		
		
		// ** Cannot create arrays of generic types

		// var table = new _02_BasicGenericClass<String>[10]; // ERROR

		
		// ** In inheritance although Employee is a subclass of manager
		// Pair<Employee> is not a subclass of Pair<Manager>
		
		
		
	}

	// Type limits to avoid problems
	public static <T extends Comparable> T min(T[] a) {
		if (a == null || a.length == 0)
			return null;
		T smallest = a[0];
		for (int i = 1; i < a.length; i++)
			if (smallest.compareTo(a[i]) > 0)
				smallest = a[i];
		return smallest;
	}

	// Multiples types limits
	public static <T extends Comparable<T> & Serializable> T min2(T[] a) {
		if (a == null || a.length == 0)
			return null;
		T smallest = a[0];
		for (int i = 1; i < a.length; i++)
			if (smallest.compareTo(a[i]) > 0)
				smallest = a[i];
		return smallest;
	}

}
