package basic._ex02_fundamentals2;

import basic.hah.ReadKBData;

/*
 * Program to guess the random number from 1 to 10
 */
public class Ex04 {

	public static void main(String[] args) {
		int answer = 0;
		int randomNum = (int) (Math.random() * 10) + 1;

		System.out.println("Guess the number between 0-10:");
		do {
			answer = ReadKBData.enterInt("Enter a number:");
			if (answer != randomNum) {
				if (answer < randomNum) {
					System.out.println("The number is greater than " + answer);
				} else {
					System.out.println("The number is less than " + answer);
				}
			}
		} while (answer != randomNum);

		System.out.println("Correct! The number was " + randomNum);
	}

}
