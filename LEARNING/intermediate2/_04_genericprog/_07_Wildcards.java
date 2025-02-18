package intermediate2._04_genericprog;

import java.util.ArrayList;
import java.util.List;

public class _07_Wildcards {

	public static void main(String[] args) {

		// Wildcards in Java use ---> ?

		// Wildcard types:

		// ** Unbounded Wildcard ?

		List<?> lista = new ArrayList<String>();

		// Example:

//		public void imprimirLista(List<?> lista) {
//		    for (Object obj : lista) {
//		        System.out.println(obj);
//		    }
//		}

		// ** Upper Bounded Wildcard ? extends Type

		List<? extends Number> numeros = new ArrayList<Integer>();

//		public double sumarLista(List<? extends Number> numeros) {
//		    double suma = 0.0;
//		    for (Number num : numeros) {
//		        suma += num.doubleValue();
//		    }
//		    return suma;
//		}

		// ** Lower Bounded Wildcard ? super Type

		List<? super Integer> lista2 = new ArrayList<Number>();

//		public void agregarEntero(List<? super Integer> lista) {
//		    lista.add(42); // Allowed because we know that Integer or its subtypes are valid.
//		}
		
		// *******************
		// Wildcard capture
		
		// You cannot assign wildcard values to an explicit variable.

		? t = p.getFirst(); // ERROR: you cannot use `?` as a type.

		// You cannot modify the wildcard in a generic way.

		p.setFirst(p.getSecond()); // ERROR: type safety cannot be guaranteed.
		
		
		// Solution: Generic helper method (swapHelper)
//		public static <T> void swapHelper(Pair<T> p) {
//		    T t = p.getFirst();        // Capture the first element of type T.
//		    p.setFirst(p.getSecond()); // Swap the elements.
//		    p.setSecond(t);            // Assign the original element.
//		}

		
		// Example of use:
		
//		public static void swap(Pair<?> p) {
//		    swapHelper(p); // Capture the wildcard using the generic type T.
//		}
	}
}