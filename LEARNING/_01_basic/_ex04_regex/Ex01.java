package _01_basic._ex04_regex;

import java.util.regex.Pattern;

/**
 * Exercises from w3resource. 1. Write a Java program to check whether a string
 * contains only a certain set of characters (in this case a-z, A-Z and 0-9).
 * 
 * https://www.w3resource.com/java-exercises/re/index.php
 */
public class Ex01 {

	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("^[\\w]+$");

		System.out.println(pattern.matcher("ABCDEFabcdef123450").matches());
		System.out.println(pattern.matcher("SQL").matches());
		System.out.println(pattern.matcher("Java").matches());
		System.out.println(pattern.matcher("*&%@#!}{").matches());
	}

}
