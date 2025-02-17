package intermediate2._04_genericprog;

import java.lang.reflect.Array;

public class _06_GenericProg2 {

	// It is not necessary for the class to be generic to have generic methods.
	public static <T> T getMiddle(T... a) {
		return a[a.length / 2];
	}

	// Calling to generic methods
	public static void main(String[] args) {
		String middle = _06_GenericProg2.<String>getMiddle("John", "Q.", "Public");
	}

}
