package _01_basic._ex03_string;

/**
 * 109. Write a Java program that reverses all odd-length words in a string.
 */
public class Ex04 {
	public static void main(String[] args) {
		String str = "Check two consecutive identical letters in a given string";

		System.out.printf("Original text: %s\n", str);
		System.out.print("Reversed: ");
		System.out.println(reverseOdds(str));
	}

	public static String reverseOdds(String str) {
		StringBuilder strRevOdds = new StringBuilder();

		// I extract every word
		String[] words = str.split(" ");

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() % 3 == 0) {
				StringBuilder revWord = new StringBuilder();

				// I use this because .reverse() is too easy
				for (int j = words[i].length() - 1; j >= 0; j--) {
					revWord.append("\u001B[31m").append(words[i].charAt(j)).append("\u001B[0m");
				}

				// change the normal for the reverse
				words[i] = revWord.toString();
			}
		}

		// Then I need to join all words
		for (int i = 0; i < words.length; i++) {
			strRevOdds.append(words[i]);
			if (i < words.length - 1) {
				strRevOdds.append(" "); // blank space except the last
			}
		}

		return strRevOdds.toString();
	}
}
