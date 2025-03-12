package _01_basic._ex05_array;

import _01_basic.hah.MyArray;
import _01_basic.hah.ReadKBData;

/*
 * Program that generates a random array, sort the array in ascending order,
 * then ask you to select an index of the array to rotate it to that index
 */
public class Ex17 {

	public static void main(String[] args) {
		int[] randomArr = MyArray.fillRandom(10, 0, 100);
		MyArray.sortAsc(randomArr);
		System.out.println("The current array:");
		MyArray.display(randomArr);
		int numberToRotate = askNum(randomArr);
		System.out.println("ROTATING array to number " + numberToRotate);
		int[] rotatedArr = MyArray.rotate(randomArr, numberToRotate);
		MyArray.display(rotatedArr);
	}

	public static int askNum(int[] array) {
		int num = 0;
		boolean isInside = false;

		// ask for an element inside of the array
		do {
			num = ReadKBData.enterInt("Enter a number that is in the array");
			for (int i : array) {
				if (num == i) {
					isInside = true;
				}
			}

			if (!isInside) {
				System.out.println("ERROR. The number must be in the array");
			}
		} while (!isInside);

		return num;
	}
}
