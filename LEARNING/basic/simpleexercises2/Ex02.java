package basic.simpleexercises2;

import basic.utilis.ReadKBData;

/*
 * Program that calculates a progression by entering the total
 * iterations and the progression factor
 */
public class Ex02 {

	public static void main(String[] args) {
		int elements = ReadKBData.enterInt("Enter the number of elements in the progression:");
		int initialTerm = ReadKBData.enterInt("Enter the initial term: ");
		int factor = ReadKBData.enterInt("Enter the progression factor:");

		String finalMessage = "The progression is:";
		int[] progressionArray = progression(elements, initialTerm, factor);
		for (int i = 0; i < progressionArray.length; i++) {
			finalMessage += " " + progressionArray[i];
		}

		System.out.println(finalMessage);
	}

	public static int[] progression(int x, int y, int z) {
		int[] progressionArray = new int[x];
		int initialTerm = y;
		int factor = z;
		int currentTerm = initialTerm;

		int index = 0;
		while (index != progressionArray.length) {
			progressionArray[index] = currentTerm;
			currentTerm *= factor;
			index++;
		}

		return progressionArray;
	}

}
