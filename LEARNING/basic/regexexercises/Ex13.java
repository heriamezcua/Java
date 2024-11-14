package basic.regexexercises;

import java.util.regex.Pattern;

/**
 * Write a Java program to check whether a string contains only a certain set of
 * characters (in this case a-z, A-Z and 0-9).
 */
public class Ex13 {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[\\w]+$");
		
		System.out.println(pattern.matcher("ABCDEFabcdef123450").matches());
		System.out.println(pattern.matcher("SQL").matches());
		System.out.println(pattern.matcher("Java").matches());
		System.out.println(pattern.matcher("*&%@#!}{").matches());
	}

}
