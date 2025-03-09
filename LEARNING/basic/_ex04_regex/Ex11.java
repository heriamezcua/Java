package basic._ex04_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyExercise 2. We want to find words that do not have a dollar sign
 * immediately before them.
 */
public class Ex11 {

	public static void main(String[] args) {
		String[] myString = { "$100 apple $200 banana house" };

		String regex = "(?<!\\$)\\b\\w+\\b";

		Pattern pattern = Pattern.compile(regex);

		for (String string : myString) {
			Matcher matcher = pattern.matcher(string);

			System.out.println("In the string: " + string);
	        System.out.println("Words not preceded by '$':");
	        while (matcher.find()) {
	            System.out.println(matcher.group());
	        }
		}
	}

}
