package basic.simpleexercises;

import basic.utilis.ReadKBData;


/*
 * Program that prints the sum of numbers from 1 to X
 */
public class Ex04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputNum = ReadKBData.enterInt("Enter an integer: ");

		int numSum = 0;
		for (int initNum = 0; initNum <= inputNum; initNum++) {
			numSum += initNum;
		}

		System.out.printf("The sum of numbers from 1 to %d is: %d", inputNum, numSum);
	}

}
