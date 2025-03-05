package basic._ex04_regexexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 3. Write a Java program to find sequences of lowercase letters joined by an
 * underscore.
 */
public class Ex03 {

	public static void main(String[] args) {
		String[] myString = { "good_regex", "baD_regex", "123abc_def456", "PASD_PPP", "adsadas" };

//		String regex = "[a-z]+_[a-z]+";
		String regex = "^[a-z]+_[a-z]+$";
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
