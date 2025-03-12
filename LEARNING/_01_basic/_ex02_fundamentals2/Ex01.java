package _01_basic._ex02_fundamentals2;

import _01_basic.hah.ReadKBData;

/*
 * Program that calculates real equations
 */
public class Ex01 {

	public static void main(String[] args) {
		System.out.println("SOLVE REAL EQUATIONS");
		double a = ReadKBData.enterDouble("Enter coefficient a:");
		do {
			if (a == 0) {
				System.err.println("a cannot be zero");
				a = ReadKBData.enterDouble("Enter coefficient a:");
			}
		} while (a==0);
		
		double b = ReadKBData.enterDouble("Enter coefficient b:");
		double c = ReadKBData.enterDouble("Enter coefficient c:");

		System.out.println(resolverEcuacion(a, b, c));
	}

	public static String resolverEcuacion(double a, double b, double c) {
		double discriminant = Math.pow(b, 2) - 4 * a * c;
		String finalMessage = "";

		if (discriminant < 0) {
			finalMessage += "Does not have real solution";
		} else if (discriminant == 0) {
			finalMessage += "x1= " + (-b / (2 * a)) + "\nx2= " + (-b / (2 * a));
		} else {
			finalMessage += "x1: " + ((-b + Math.sqrt(discriminant)) / (2 * a)) + "\nx2: "
					+ ((-b - Math.sqrt(discriminant)) / (2 * a));
		}

		return finalMessage;
	}

}
