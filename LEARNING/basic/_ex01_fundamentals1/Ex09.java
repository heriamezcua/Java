package basic._ex01_fundamentals1;

import basic.hah.ReadKBData;

/*
 * Program that calculates a number elevated to another
 */
public class Ex09 {

	public static void main(String[] args) {
		
		// input of a positive base
		double base = ReadKBData.enterDouble("Enter the base: ");
		do {
			if(base<=0) {
				System.err.println("The base must be positive!");
				base = ReadKBData.enterDouble("Enter the base: ");
			}
		} while (base<=0);
		

		int exponent= ReadKBData.enterInt("Enter the exponent: ");
		
		// Multiply X times as exponent entered
		double result = 1;
		for (int i = 0; i < exponent; i++) {
			result*=base;
		}
		
		result = Math.ceil(result);
		
		System.out.printf("%.2f elevated to %d exponent is equal to: %.2f", base, exponent, result);
	}

}
