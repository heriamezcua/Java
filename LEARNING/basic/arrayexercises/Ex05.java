package basic.arrayexercises;

import basic.utilis.MyArray;

/*
 * Program where you enter 5 integer numbers and return the highest 
 * and the lowest element
 */
public class Ex05 {

	public static void main(String[] args) {

		System.out.println("** Fill the following array **");
		int[] array = MyArray.fill(5);
		System.out.println("Highest: " + MyArray.returnMax(array));
		System.out.println("Lowest: " + MyArray.returnMin(array));
	}

}
