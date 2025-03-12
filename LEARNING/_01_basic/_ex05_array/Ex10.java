package _01_basic._ex05_array;

import _01_basic.hah.MyArray;

/*
 * Program where you enter the number of elements that a new array will have.
 * Then ask you to fill it in the position you want.
 */
public class Ex10 {

	public static void main(String[] args) {
		int[] array = MyArray.fillRandom(20, 0, 100);
		int[] evenArr = MyArray.fillEven(array);
		int[] oddArr = MyArray.fillOdd(array);
		int[] sumArr = MyArray.concatenate(evenArr, oddArr);
		MyArray.display(sumArr);
	}
}
