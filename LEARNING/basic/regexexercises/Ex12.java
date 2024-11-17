package basic.regexexercises;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyExcersise 3. Find numbers that are followed by the word "apple"
 */
public class Ex12 {

	public static void main(String[] args) {
		String[] myString = { "100 apple 200 banana 300 apple" };

		String regex = "\\d+(?=\\sapple)";

		Pattern pattern = Pattern.compile(regex);

		for (String string : myString) {
			Matcher matcher = pattern.matcher(string);

			System.out.println("Numbers followed by the word 'apple':");
			while (matcher.find()) {
				System.out.println(matcher.group());
			}
		}
	}

}
