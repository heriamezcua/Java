package basic._ex06_matrixexercises;

import basic.utilis.MyMatrix;

public class Ex05 {

	public static void main(String[] args) {
		System.out.println("Generating a random matrix...\n");
		int[][] matrix = MyMatrix.fillRandom(6, 10, 0, 99);
		int[] maxLocation = locateMax(matrix);
		MyMatrix.highlightMax(matrix, maxLocation[0]);
		System.out.printf("Max num: %d | row: %d, col: %d", maxLocation[0], maxLocation[1], maxLocation[2]);
	}

	public static int[] locateMax(int[][] matrix) {
		int[] maxLocation = { matrix[0][0], 0, 0 };

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				if (matrix[row][col] > maxLocation[0]) {
					maxLocation[0] = matrix[row][col];
					maxLocation[1] = row;
					maxLocation[2] = col;
				}
			}
		}

		return maxLocation;
	}

}
