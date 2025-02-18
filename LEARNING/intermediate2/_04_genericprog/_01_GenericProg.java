package intermediate2._04_genericprog;

import java.util.ArrayList;

public class _01_GenericProg {

	public static void main(String[] args) {
		//
		// Object storing WITHOUT generics
        ArrayList list = new ArrayList(); // No generics
        list.add("Hello");
        list.add(123); // Any type can be added

        // Explicit conversion when retrieving elements
        String str = (String) list.get(0); // Works
        String error = (String) list.get(1); // Runtime error
        
		//
		// Object storing WITH generics
        ArrayList<String> list2 = new ArrayList<>(); // Generics
        list2.add("Hello");
        // list.add(123); // Compilation error, not allowed

        String str2 = list2.get(0); // No explicit conversion required
        System.out.println(str2); // Print "Hello"
	}
}
