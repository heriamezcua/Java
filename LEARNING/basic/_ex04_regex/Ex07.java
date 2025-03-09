package basic._ex04_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 7. Write a Java program that matches a word containing 'g', not at the start
 * or end of the word.
 */
public class Ex07 {

	public static void main(String[] args) {
		String[] myString = { "pgoodregexq", "gbadregexQ", "pgoodregexQ", "gggbadregexQ", "uppErCasE", "pepperCase" };

		String regex = "^[^g].*[^g]$";

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
