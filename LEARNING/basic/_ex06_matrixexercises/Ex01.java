package basic._ex06_matrixexercises;

import basic.utilis.MyMatrix;

/**
 * The user fill a matrix then it is shown in the console
 */
public class Ex01 {

	public static void main(String[] args) {
		System.out.println("** Fill the following 3x2 matrix **");
		int[][] num = MyMatrix.fill(3, 2);
		System.out.println("\nYour matrix:");
		MyMatrix.display(num);
	}

}
