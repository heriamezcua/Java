package basic.arrayexercises;

import basic.utilis.MyArray;

/*
 * Program where you enter the number of elements that a new array will have.
 * Then creates two arrays one with the even and other with odds numbers
 */
public class Ex09 {

	public static void main(String[] args) {
		int[] array = MyArray.fill(8);
		int[] EvenArr = MyArray.fillEven(array);
		int[] OddArr = MyArray.fillOdd(array);

		MyArray.display(EvenArr);
		MyArray.display(OddArr);
	}
}
