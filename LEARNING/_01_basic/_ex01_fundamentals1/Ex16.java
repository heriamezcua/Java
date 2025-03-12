package _01_basic._ex01_fundamentals1;

import _01_basic.hah.ReadKBData;

/*
 * Program that calcs the cost of call 
 */
public class Ex16 {

	public static void main(String[] args) {
		double callTime = ReadKBData.enterDouble("Enter the call time (in minutes):");
		do {
			if (callTime <= 0) {
				System.err.println("Call time cannot be negative!");
				callTime = ReadKBData.enterDouble("Enter the call time (in minutes):");
			}
		} while (callTime <= 0);

		int amount = getAmount(callTime);

		System.out.println("Cost of call: " + amount + " cents (eur)");
	}

	public static int getAmount(double x) {
		double callTime = Math.ceil(x);
		int amount = 0;

		if (callTime <= 1) {
			amount += 15;
		} else if (callTime <= 2) {
			amount += 30;
		} else if (callTime <= 3) {
			amount += 45;
		} else {
			amount += 45;
			amount += ((callTime - 3) * 7);
		}

		return amount;
	}

}
