package _01_basic._05_matrix;

public class _01_Matrix {

	public static void main(String[] args) {

		// A matrix is a bidimensional array
		// The most used are 2 and 3 dimensions

		// INSTANTIATION
		int[][] myMatrix = new int[2][7];

		// ACCESS AND MODIFICATION
		myMatrix[0][1] = 2;
		myMatrix[2][3] = 3;
		myMatrix[myMatrix.length - 1][1] = 33;

		// JAGGED MATRIX
		int[][] jaggedMatrix = new int[3][];

		jaggedMatrix[0] = new int[4];
		jaggedMatrix[1] = new int[2];
		jaggedMatrix[2] = new int[5];
	}

}
