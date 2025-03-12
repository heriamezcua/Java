package _01_basic._ex01_fundamentals1;

import java.math.BigInteger;

import _01_basic.hah.ReadKBData;

/*
 * Program that calcs the sums of the multiples of 5 in the
 * range -50 - +50 and the number of odds and even 
 */
public class Ex19 {

	public static void main(String[] args) {

		int number = ReadKBData.enterInt("Enter an integer:");
		boolean isPrime = isPrimeNumber(number);

		if (isPrime) {
			System.out.println(number + " is a prime number");
		} else {
			System.out.println(number + " is NOT a prime number");
		}
	}

	public static boolean isPrimeNumber(int number) {
		boolean isPrime = false;
		int divisibles = 0;
		for (int i = 1; i <= number; i++) {
			if (number % i == 0) {
				divisibles++;
			}
		}

		if (divisibles == 2) {
			isPrime = true;
		}

		return isPrime;
	}

}
