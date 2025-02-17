package intermediate2._04_genericprog;

import java.util.ArrayList;

public class _01_GenericProg {

	public static void main(String[] args) {
		//
		// Object storing WITHOUT generics
        ArrayList list = new ArrayList(); // Sin genéricos
        list.add("Hello");
        list.add(123); // Se puede agregar cualquier tipo

        // Conversión explícita al recuperar los elementos
        String str = (String) list.get(0); // Funciona
        String error = (String) list.get(1); // Error en tiempo de ejecución
        
		//
		// Object storing WITH generics
        ArrayList<String> list2 = new ArrayList<>(); // Genéricos
        list2.add("Hello");
        // list.add(123); // Error en compilación, no se permite

        String str2 = list2.get(0); // No requiere conversión explícita
        System.out.println(str2); // Imprime "Hello"
	}
}
