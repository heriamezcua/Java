package basic._ex05_arrayexercises;

import basic.utilis.MyArray;
import basic.utilis.ReadKBData;

/*
 * Program that generates a random array, then ask you to highlight the max or min value
 */
public class Ex13 {

	public static void main(String[] args) {
		int[] array = MyArray.fillRandom(50, 0, 500);
		System.out.println("The current random array:");
		MyArray.display(array);

		// ask to highlight max or min
		int highlight = ReadKBData.enterInt("\nWhat do you want to highlight? (1-maximum / 2-minimum)");
		do {
			if (highlight != 1 && highlight != 2) {
				System.out.println("Error, please enter correctly");
				highlight = ReadKBData.enterInt("What do you want to highlight? (1-maximum / 2-minimum)");
			}
		} while (highlight != 1 && highlight != 2);

		// choose between selected
		if (highlight == 1) {
			highlightMax(array);
		} else {
			highlightMin(array);
		}
	}

	public static void highlightMax(int[] array) {
		StringBuilder outputStr = new StringBuilder();
		int max = array[0];

		// find the max value
		for (int elem : array) {
			if (elem > max) {
				max = elem;
			}
		}

		// highlight the max value
		for (int elem : array) {
			if (elem == max) {
				outputStr.append("\033[31m" + elem + "\033[0m ");
			} else {
				outputStr.append(elem + " ");
			}

		}

		System.out.println(outputStr);
	}

	public static void highlightMin(int[] array) {
		StringBuilder outputStr = new StringBuilder();
		int min = array[0];

		// find the max value
		for (int elem : array) {
			if (elem < min) {
				min = elem;
			}
		}

		// highlight the max value
		for (int elem : array) {
			if (elem == min) {
				outputStr.append("\033[31m" + elem + "\033[0m ");
			} else {
				outputStr.append(elem + " ");
			}

		}

		System.out.println(outputStr);
	}

}
