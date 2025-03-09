package basic._ex05_array;

import basic.hah.MyArray;

/*
 * Program that ask you to fill an array of 6 elements
 * then prints the value associated to the index
 */
public class Ex11 {

	public static void main(String[] args) {
		System.out.println("** Fill the following array of integers **");
		int[] array = MyArray.fill(6);
		printIndexValue(array);
	}

	public static void printIndexValue(int[] array) {
		StringBuilder finalMessage = new StringBuilder("INDICE ");
		for (int index = 0; index < 10; index++) {
			finalMessage.append(index + " ");
		}
		finalMessage.append("\nVALOR  ");
		for (int index = 0; index < array.length; index++) {
			finalMessage.append(array[index] + " ");
		}
		System.out.println(finalMessage);
	}
}
