package basic._ex02_simpleexercises2;

import basic.utilis.ReadKBData;

/*
 * Program that calculates the mortage
 */
public class Ex05 {

	public static void main(String[] args) {
		double mortgage = ReadKBData.enterDouble("Enter your mortgage amount:");
		int years = ReadKBData.enterInt("Enter the number of years to pay:");
		double annualInterestRate = ReadKBData.enterDouble("Enter annual interest rate:") / 100;
		double monthlyRate = annualInterestRate / (100 * 12);
		double monthlyPayment = (mortgage * monthlyRate) / (1 - Math.pow((1 + monthlyRate), -12 * years));
		System.out.print("Your monthly payment will be: ");
		System.out.printf("%1.2f", monthlyPayment);
		System.out.println(" €");
		System.out.print("You will have paid the bank in " + years + " years a total of "
				+ (mortgage + mortgage * annualInterestRate) + " €");

	}

}
