package _01_basic._ex05_array;

import _01_basic.hah.MyArray;
import _01_basic.hah.ReadKBData;

/*
 * Program that swaps the value of all elements with the first entered value for a second
 * value.
 */
public class Ex07 {

	public static void main(String[] args) {
		System.out.println("** SHOWING A RANDOM ARRAY OF 100 ELEMENTS **");
		int[] array = MyArray.fillRandom(100, 0, 20);
		MyArray.display(array);
		int value1 = ReadKBData.enterInt("Enter the value 1 found in the array:");
		int value2 = ReadKBData.enterInt("Enter value 2 to change value 1 to:");
		MyArray.display(MyArray.swapValue(array, value1, value2));
	}

}
