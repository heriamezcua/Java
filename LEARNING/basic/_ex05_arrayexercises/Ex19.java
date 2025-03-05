package basic._ex05_arrayexercises;

import basic.utilis.MyArray;
import basic.utilis.ReadKBData;

/*
 * The program generates an array of 12 random numbers between 0 and 200 and displays 
 * the contents along with their indices. It then asks the user for a number and a 
 * position to insert it. To make room, it shifts the elements to the right and
 * discards the last number in the array.
 */
public class Ex19 {

	public static void main(String[] args) {
		int[] randomArr = MyArray.fillRandom(12, 0, 200);
		MyArray.printIndexValue(randomArr);

		// ask the index of the number to replace
		int changeIndex = ReadKBData.enterInt(
				"Array with " + randomArr.length + " positions\nEnter the index of the number you want to replace:");
		do {
			if (changeIndex < 0 || changeIndex >= randomArr.length) {
				System.err.println("ERROR, INDEX OUT OF RANGE");
				changeIndex = ReadKBData.enterInt("Array with " + randomArr.length
						+ " positions\nEnter the index of the number you want to replace:");
			}
		} while (changeIndex < 0 || changeIndex >= randomArr.length);

		// asking the new int value
		int newNum = ReadKBData.enterInt("Enter new number:");

		MyArray.swapAndShift(randomArr, changeIndex, newNum);
		MyArray.printIndexValue(randomArr);
	}

}
