package _01_basic._ex01_fundamentals1;

import java.util.Scanner;

import _01_basic.hah.ReadKBData;

/*
 * Program that calulates if a number is a palindrome
 */
public class Ex12 {

	public static void main(String[] args) {
		String number = "" + getNumber();
		boolean isPalindrome = false;

		Scanner input = new Scanner(number);
		input.useDelimiter("\\.");

		int intPart = Integer.parseInt(input.next());
		int decPart = Integer.parseInt(input.next());
		
		input.close();

		String noDotNum = "" + intPart + decPart;
		String numReverse = getReverse(noDotNum);

		if (noDotNum.equals(numReverse)) {
			isPalindrome = true;
		}
		
		String strResult= (isPalindrome) ? "is a palindrome" : "is NOT a palindrome";

		System.out.println(number + " " + strResult);
	}

	public static double getNumber() {
		double number = ReadKBData.enterDouble("Enter a number (0 - 9,999)");

		if (number < 0 || number > 9.999) {
			throw new AssertionError("incorrect number range");
		}

		return number;
	}

	public static String getReverse(String noDotNum) {
		String reverseNum = "";

		for (int i = 1; i <= noDotNum.length(); i++) {
			reverseNum += noDotNum.charAt(noDotNum.length() - i);
		}

		return reverseNum;
	}
}
