package basic._ex04_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 9. Write a Java program where a string starts with a specific number.
 */
public class Ex09 {

	public static void main(String[] args) {
		String[] myString = { "5-2345861", "6dsadas", "5dddasq", "7''das", "8----", "dasda--5" };

		String regex = "^5.*$";

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
