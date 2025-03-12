package _01_basic._ex04_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * MyExercise. We want to find all the words that follow "Java" in a sentence.
 */
public class Ex10 {

	public static void main(String[] args) {
		String[] myString = { "Java fun. Java used. Java is liked" };

		String regex = "(?<!\\bJava\\b\\s)\\b\\w+\\b";

		Pattern pattern = Pattern.compile(regex);

		for (String string : myString) {
			Matcher matcher = pattern.matcher(string);

			while (matcher.find()) {
				System.out.println("Word after the word Java: " + matcher.group().trim());
			}
		}
	}
}
