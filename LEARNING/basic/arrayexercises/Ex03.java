package basic.arrayexercises;

import basic.utilis.MyArray;

/*
 * Shows your array in reverse
 */
public class Ex03 {

	public static void main(String[] args) {
		System.out.println("** Please, fill this array of 10 elements **");
		int[] myArray = MyArray.fill(10);
		System.out.print("Your array: ");
		MyArray.display(myArray);
		System.out.print("In reverse: ");
		MyArray.displayReverse(myArray);
	}

}
