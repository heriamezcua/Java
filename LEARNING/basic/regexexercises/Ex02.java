package basic.regexexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 2. Write a Java program that matches a string that has a p followed by zero
 * or more q's.
 */
public class Ex02 {

	public static void main(String[] args) {

		String[] myString = { "pqqq", "pqq", "q", "p", "pq" };

		Pattern pattern = Pattern.compile("pq*");

		for (String string : myString) {
			Matcher matcher = pattern.matcher(string);

			if (matcher.matches()) {
				System.out.println(string + " \u001B[32mmatch\u001B[0m the regex " + "pq*");
			} else {
				System.out.println(string + " \u001B[31mDOES NOT match\u001B[0m the regex " + "pq*");
			}
		}
	}

}
