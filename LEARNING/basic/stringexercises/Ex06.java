package basic.stringexercises;

import basic.utilis.ReadKBData;

/**
 * 105. Write a Java program to count the occurrences of a given string in
 * another given string.
 */
public class Ex06 {
	public static void main(String[] args) {
		String firstStr = ReadKBData.enterStringNextLine("Input a string");
		String secondStr = ReadKBData.enterString("Input another string that ocurrs in the first:");

		int numOcu = countOcurrences(firstStr, secondStr);
		System.out.printf("%s ocurrs %d times in the string: %s", secondStr, numOcu, firstStr);
	}

	public static int countOcurrences(String str1, String str2) {
		int counter = 0;
		int index = 0;

		while ((index = str1.indexOf(str2, index)) != -1) {
			counter++;
			index++;
		}

		return counter;
	}
}
