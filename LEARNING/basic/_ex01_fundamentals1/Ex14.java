package basic._ex01_fundamentals1;

import basic.hah.ReadKBData;

/*
 * Program that tell us if an entered date is valid
 */
public class Ex14 {

	public static void main(String[] args) {

		// enter a day and check if it is in range
		int day = ReadKBData.enterInt("Enter a day:");
		do {
			if(day <= 0 || day > 31) {
				System.err.println("Incorrect day range!");
				day = ReadKBData.enterInt("Enter a day:");
			}
		} while (day <= 0 || day > 31);
		
		// enter a moth and check if it is in range
		int month = ReadKBData.enterInt("Enter a month:");
		do {
			if(month <= 0 || month > 12) {
				System.err.println("Incorrect month range!");
				month = ReadKBData.enterInt("Enter a month:");
			}
		} while (month <= 0 || month > 12);
		
		// enter a moth and check if it is in range
		int year = ReadKBData.enterInt("Enter a year:");
		do {
			if(year <= 0 || year > 4000) {
				System.err.println("Incorrect year range!");
				year = ReadKBData.enterInt("Enter a year:");
			}
		} while (year <= 0 || year > 4000);
		
		System.out.println(printDate(day, month, year));
	}

	public static String printDate(int day, int month, int year) {

		String finalMessage = "";

		switch (month) {
		case 4:
		case 6:
		case 9:
		case 11:
			if (day > 30) {
				finalMessage = "Incorrect Date: " + day + "/" + month + "/" + year;
			} else {
				finalMessage = "Correct Date: " + day + "/" + month + "/" + year;
			}
			break;
		case 2:
			if (day > 28) {
				finalMessage = "Incorrect Date: " + day + "/" + month + "/" + year;
			} else {
				finalMessage = "Correct Date: " + day + "/" + month + "/" + year;
			}
			break;
		default:
			finalMessage = "Correct Date: " + day + "/" + month + "/" + year;
		}

		return finalMessage;
	}
}
