package basic._ex04_regexexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 4. Write a Java program to find the sequence of one upper case letter
 * followed by at least 2 lower case letters.
 */
public class Ex04 {

	public static void main(String[] args) {
		String[] myString = { "Uppercase", "Firstupper12", "Firstupper", "UppErcaSe", "uppErCasE" };

		String regex = "^[A-Z][a-z]{2,}$";
		Pattern pattern = Pattern.compile(regex);

		for (String string : myString) {
			Matcher matcher = pattern.matcher(string);

			if (matcher.matches()) {
				System.out.println(string + " \u001B[32mmatch\u001B[0m the regex " + regex);
			} else {
				System.out.println(string + " \u001B[31mDOES NOT match\u001B[0m the regex " + regex);
			}
		}
	}

}
