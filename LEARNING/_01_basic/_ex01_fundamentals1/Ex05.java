package _01_basic._ex01_fundamentals1;

import _01_basic.hah.ReadKBData;

/*
 * Program that prints the first x multiples of 3 via console
 */
public class Ex05 {

	public static void main(String[] args) {

		int number = ReadKBData.enterInt("Enter an integer:");
		
		System.out.printf("First %d multiples of 3\n", number);
		
		int counter = 0;
		int initNum = 1;
		
		while (counter!= number) {		
			initNum++;
			
			if(initNum % 3 == 0) {
				System.out.println(initNum);
				counter++;
			}
		}
	}

}
