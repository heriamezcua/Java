package basic._ex05_arrayexercises;

import basic.utilis.ReadKBData;

/*
 * Program that ask you the temperature of every month of a year and
 * represent it in the console
 */
public class Ex08 {

	public static void main(String[] args) {
		int[] array = fillMonthTemp(12);
		System.out.println(printTable(array));
	}

	public static int[] fillMonthTemp(int elements) {
		int tempArray[] = new int[elements];
		int month = 0;
		int temp = 0;

		for (int i = 0; i < tempArray.length; i++) {
			month++;

			do {
				temp = ReadKBData.enterInt("Enter temperature month " + month + ": ");

				if (temp < -20 || temp > 40) {
					System.out.println("ERROR. Incorrect range of temperature");
				}
			} while (temp < -20 || temp > 40);

			tempArray[i] = temp;
		}

		return tempArray;
	}

	public static String printTable(int[] x) {
		String[] months = { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER",
				"OCTOBER", "NOVEMBER", "DECEMBER" };

		StringBuilder finalMessage = new StringBuilder("\nAVERAGE TEMPERATURE TABLE FOR THE MONTHS OF THE YEAR");

		for (int i = 0; i < x.length && i < months.length; i++) {
			// Formatting for alignment
			finalMessage.append("\n").append(String.format("%-15s", months[i])).append(": ");

			// Add asterisks based on the value
			finalMessage.append("*".repeat(Math.max(0, x[i] + 1)));
		}

		return finalMessage.toString();
	}

}
