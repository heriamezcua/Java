package basic.matrixexercises;

import basic.utilis.MyArray;
import basic.utilis.MyMatrix;

public class Ex02 {

	public static void main(String[] args) {
		System.out.println("** Fill the following 2x2 matrix **");
		int[][] matrix = MyMatrix.fill(2, 2);
		System.out.println("Rows sum: red, Cols sum: orange, Total sum: pink");
		printTable(matrix);
	}

	public static void printTable(int[][] matrix) {
		StringBuilder outputMessage = new StringBuilder("");

		for (int row = 0; row <= matrix.length; row++) {
			outputMessage.append("\n");
			if (row == matrix.length) {
				for (int col = 0; col <= matrix[0].length; col++) {
					if (row == matrix.length && col == matrix[0].length) {
						outputMessage.append("\033[35m").append(MyMatrix.sumTotal(matrix)).append("\033[0m");
					} else {
						outputMessage.append("\033[33m")
								.append(MyArray.sumAll(MyMatrix.extractColumn(matrix, col)) + " ").append("\033[0m");
					}
				}
			} else {
				for (int col = 0; col <= matrix[row].length; col++) {
					if (col == matrix[row].length) {
						outputMessage.append("\u001B[31m").append(MyArray.sumAll(MyMatrix.extractRow(matrix, row)))
								.append("\033[0m");
					} else {
						outputMessage.append(matrix[row][col] + " ");
					}
				}
			}
		}

		System.out.println(outputMessage);
	}

}
