package _01_basic._02_stringandregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_Regex {
	public static void main(String[] args) {

		// Regex (regular expression) allows us to check if a string of characters
		// matches an established pattern

		// HOW TO BUILD a regular expression

		// – Fixed symbol set: "abc"

		// – Optionality of symbols: [] example: "ab[cde]fgh" abfgh must be in but cde
		// are optionals

		// - hypen character - : any character between the initial and final Example:
		// “[a-z]”, “[A-Z]”, “[a-zA-Z]”, “[0-9]”

		// pattern repeats :
		//
		// ? -> 1 or none | e.x: "a?" <- char a appears one or less times
		//
		// * -> 0 or more | e.x: "a*" <- char a appears 0 or more times
		//
		// + -> at least 1 | e.x: "a?" <- char a appears one or less times
		//
		// {min, max} -> minimal and max times a character can appear | e.x: "a{1,4}" <-
		// char a appears at least 1 time or a maximum of 4 times
		//
		// | -> One of several options | e.x: "north|west|south|east" <- you need to
		// choose one
		//
		// ( ) -> parenteshis to group expressions | e.x "(#[01]){2,3}" <- this mean
		// that # must stay, then you need to choose between 0 or 1, and then you need
		// to repeat this at least two times or a maximum of 3. Result: #0#0#1 or #1#0
		// or #0#0, etc

		// HOW IT WORKS in java

		// We need to use Pattern and Matcher

		// Pattern: Check that the pattern is well constructed.

		Pattern binaryPattern = Pattern.compile("[01]+");

		// Matcher: Checks if a string follows a defined pattern.
		Matcher matcher = binaryPattern.matcher("0111001011");

		// .matches() check if matches of a matcher is true
		if (matcher.matches()) {
			System.out.println("Yes, it's a binary number");
		} else {
			System.out.println("No, it's NOT a binary number");
		}

		// SYMBOLS TO BUILD MORE COMPLEX REGEX
		//
		// SEARCH IN YOUR DOCS!!
		//
		// ^
		//
		// .
		//
		// \\d
		//
		// \\D
		//
		// \\s
		//
		// \\S
		//
		// \\w

		// ESCAPE SQUENCES
		// If it is necessary to use a meaningful character (bracket, bracket,
		// parenthesis, ...) in the pattern it must be escaped.

	}
}
