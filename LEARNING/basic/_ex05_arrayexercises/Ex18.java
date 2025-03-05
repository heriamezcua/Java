package basic._ex05_arrayexercises;

import basic.utilis.MyArray;

/*
 * Program that generates a random array with three figures number.
 * Then prints the index and the value, then sorts it and then prints it again 
 */
public class Ex18 {

	public static void main(String[] args) {
		int[] arrayRandom = MyArray.fillRandom(10, 0, 200);
		System.out.println("Original array");
		MyArray.printIndexValue(arrayRandom);
		// print the same but in asc order
		System.out.println("\nIn ascending order");
		MyArray.sortAsc(arrayRandom);
		MyArray.printIndexValue(arrayRandom);
	}

}
