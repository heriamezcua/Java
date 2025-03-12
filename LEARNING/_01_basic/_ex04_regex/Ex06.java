package _01_basic._ex04_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 6. Write a Java program to check if a word contains the character 'g' in a
 * given string.
 */
public class Ex06 {

	public static void main(String[] args) {
		String[] myString = { "pgoodregexq", "PgoodregexQ", "pgoodregexQ", "Pgoodregexq", "uppErCasE", "pepperCase" };

//		String regex = "^p.*q$";
//		String regex = "^.+g.+$";
		String regex = "^.*g.*$";

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
