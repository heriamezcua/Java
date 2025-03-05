package basic._ex04_regexexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 5. Write a Java program that matches a string with a 'p' followed by anything
 * ending in 'q'.
 */
public class Ex05 {

	public static void main(String[] args) {
		String[] myString = { "pgoodregexq", "PgoodregexQ", "pgoodregexQ", "Pgoodregexq", "uppErCasE" };

//		String regex = "^p.*q$";
		String regex = "^[Pp].*[Qq]$";

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
