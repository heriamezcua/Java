package basic.simpleexercises;

import basic.utilis.ReadKBData;

/*
 * Program that prints the lowest and highest entered integer
 */
public class Ex07 {

	public static void main(String[] args) {
		
		int highest = 0;
		int lowest = 0;
		int inputNum = 0;
		
		for (int startNum = 0; startNum < 5; startNum++) {
			inputNum = ReadKBData.enterInt("Enter an integer:");
			
			if (startNum == 0) {
				highest = inputNum;
				lowest = inputNum;
			
			}else if (inputNum>highest) {
				highest = inputNum;
			
			}else if (inputNum<lowest) {
				lowest = inputNum;
			}
		}
		
		System.out.printf("The lowest entered integer is: %d\nThe highest entered integer is: %d", lowest, highest);
	}

}
