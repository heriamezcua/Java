package basic.simpleexercises1;


import basic.utilis.ReadKBData;

/*
 * Program that calculates if a year is leap
 */
public class Ex08 {

	public static void main(String[] args) {

		// enter num and validates if higher than 0
		int year = ReadKBData.enterInt("Enter a year:");
		do {

			if (year < 0) {
				System.err.println("Please, enter a valid year!");
				year = ReadKBData.enterInt("");
			}

		} while (year <= 0);

		boolean isLeapYear = false;

		if (year % 4 == 0) {
			isLeapYear = true;

			if (year % 100 == 0) {
				isLeapYear = false;

				if (year % 400 == 0) {
					isLeapYear = true;

				}
			}

		} else if (year % 100 == 0) {

			if (year % 400 == 0) {
				isLeapYear = true;
			}
		}

		String result = isLeapYear ? "is" : "is not";
		System.out.printf("The year %d %s a leap year", year, result);
	}

}
