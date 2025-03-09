package basic._ex04_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyExcersise 4. Find numbers that are NOT followed by the word "apple"
 */
public class Ex13 {

	public static void main(String[] args) {
		String[] myString = { "100 apple 200 banana 300 apple" };

		String regex = "\\b\\d+\\b(?!\\sapple)";

		Pattern pattern = Pattern.compile(regex);

		for (String string : myString) {
			Matcher matcher = pattern.matcher(string);

			System.out.println("Numbers NOT followed by the word 'apple':");
			while (matcher.find()) {
				System.out.println(matcher.group());
			}
		}
	}

}
