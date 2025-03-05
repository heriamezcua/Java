package basic._ex01_simpleexercises1;

import basic.utilis.ReadKBData;

/*
 * Program that prints the sum of the odds and even numbers
 */
public class Ex06 {

	public static void main(String[] args) {
		
		int inputNum = ReadKBData.enterInt("Enter an integer: ");
		
		int evenCount = 0;
		int oddCount = 0;
		
		for(int numStart = 1; numStart<=inputNum; numStart++) {
			if (numStart % 2== 0) {
				evenCount += numStart;
			} else {
				oddCount += numStart;
			}
		}
		
		System.out.printf("\n++Summation++\nEven numbers: %d\nOdd numbers: %d", evenCount, oddCount);
	}

}
