package basic._ex04_regexexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 8. Write a Java program to match a string containing only upper and lowercase
 * letters, numbers, and underscores.
 */
public class Ex08 {

	public static void main(String[] args) {
		String[] myString = { "das312_", "123_dasda", "??¿ads_123!!", "ads_123!!", "312312312", "_pepperCase34" };

		String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z0-9_]+$";

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
