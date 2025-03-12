package _01_basic._ex01_fundamentals1;

import java.util.Scanner;

import _01_basic.hah.ReadKBData;

/*
 * Program that counts the integer and decimal digits of a number
 */
public class Ex10 {

	public static void main(String[] args) {

		String num = "" + ReadKBData.enterDouble("Enter a double number: ");
		Scanner input = new Scanner(num);
		input.useDelimiter("\\.");
		int digits = 0;

		int intPart = Integer.parseInt(input.next());
		int decPart = Integer.parseInt(input.next());

		while (intPart != 0) {
			intPart /= 10;
			digits++;
		}

		while (decPart != 0) {
			decPart /= 10;
			digits++;
		}

		input.close();

		System.out.println(num + " has " + digits + " digits");
	}

}
