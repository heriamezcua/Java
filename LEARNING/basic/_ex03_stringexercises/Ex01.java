package basic._ex03_stringexercises;

import basic.utilis.ReadKBData;

/**
 * W3C ex 112. A string is created by using another string's letters. Letters
 * are case sensitive. Write a Java program that checks the letters of the
 * second string are present in the first string. Return true otherwise false.
 */
public class Ex01 {
	public static void main(String[] args) {
		String firstStr = ReadKBData.enterString("Input a string");

		String secondStr = ReadKBData.enterString("Input a second string");

		System.out.println("Checking if the second string contains words of the first...");

		System.out.println("The second string is " + ((containsWords(firstStr, secondStr)) ? "" : "NOT")
				+ "made up of only characters from the first");

	}

	public static boolean containsWords(String str1, String str2) {
		
		
		boolean contains = true;

		// for each character of str2
		for (int i = 0; i < str2.length() && contains; i++) {
			// Check if the current character in str2 is in str1
			if (str1.indexOf(str2.charAt(i)) == -1) {
				contains = false;
			}
		}

		return contains;
	}
}
