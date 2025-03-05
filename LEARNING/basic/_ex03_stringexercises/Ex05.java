package basic._ex03_stringexercises;

/**
 * 108. Write a Java program to check whether there are two consecutive
 * (following each other continuously), identical letters in a given string.
 */
public class Ex05 {
	public static void main(String[] args) {
		String str = "Follow";
		System.out.printf("Original word: %s\n", str);

	
		System.out.printf("There are two consecutive identical letters? %s", calcTwoConsecutive(str));
	}

	public static Boolean calcTwoConsecutive(String str) {
		boolean hasTwoConsec = false;

		for (int i = 0; i < str.length() - 1 && !hasTwoConsec; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				hasTwoConsec = true;
			}
		}

		return hasTwoConsec;
	}
}
