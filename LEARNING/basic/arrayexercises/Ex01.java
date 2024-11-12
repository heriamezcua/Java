package basic.arrayexercises;

import basic.utilis.MyArray;
import basic.utilis.ReadKBData;

/*
 * Program where you enter the number of elements that a new array will have.
 * Then ask you to fill it in the position you want.
 */
public class Ex01 {

	public static void main(String[] args) {
		int length = ReadKBData.enterInt("Enter the length of the new array: ");
		int [] newArray = MyArray.fillPosition(length);
		
		System.out.println("\nYour array:");
		MyArray.display(newArray);
	}

}
