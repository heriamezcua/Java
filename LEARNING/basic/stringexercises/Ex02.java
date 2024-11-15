package basic.stringexercises;

import basic.utilis.ReadKBData;

/**
 * W3C ex 111. Write a Java program that removes a specified word from given
 * text. Return the updated string..
 */
public class Ex02 {
	public static void main(String[] args) {
		String firstStr = ReadKBData.enterStringNextLine("Input a string");
		String secondStr = ReadKBData.enterStringNextLine("Input a word to remove");

		System.out.println("String after word deletion");
		System.out.println(removeWord(firstStr, secondStr));

	}

	public static String removeWord(String str, String word) {
		return str.replaceAll("\\b" + word + "\\b\\s*", "").trim();
	}
}
