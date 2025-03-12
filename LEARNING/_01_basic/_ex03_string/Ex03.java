package _01_basic._ex03_string;

/**
 * 110. Write a Java program to count the number of characters (alphanumeric
 * only) that occur more than twice in a given string.
 */
public class Ex03 {
	public static void main(String[] args) {

		String firstStr = "Create a Date Calendar";
		System.out.println("Original string: " + firstStr);
		int repeatedChars = calcRepeatedChars(firstStr);
		System.out.printf("Number of duplicate characters: %d", repeatedChars);
	}

	public static int calcRepeatedChars(String str) {
		int count = 0;

		// until str length becomes 0
		while (str.length() > 0) {
			// Check if the char count is more than 2
			if (str.length() - str.replaceAll(str.charAt(0) + "", "").length() > 2) {
				count++;
			}

			str = str.replaceAll(str.charAt(0) + "", "");
		}
		return count;
	}
}
