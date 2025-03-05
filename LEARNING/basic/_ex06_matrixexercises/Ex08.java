package basic._ex06_matrixexercises;

import basic.utilis.Calculate;

/**
 * Program that simulates the possible movements of a Bishop in a chess game.
 */
public class Ex08 {

	public static void main(String[] args) {
		String[][] board = fillBoard(9, 9);
		printBoard(board);
	}

	public static String[][] fillBoard(int rows, int cols) {
		String[][] board = new String[rows][cols];
		int colPos = Calculate.calcRandomInt(1, 8);
		int rowPos = Calculate.calcRandomInt(1, 8);

		setSquare(board);
		setNums(board);
		targetPosition(board, rowPos, colPos);
		setBishop(board, rowPos, colPos);

		return board;
	}

	public static String[][] targetPosition(String[][] board, int rowPos, int colPos) {
		for (int row = 1; row < board.length; row++) {
			for (int col = 1; col < board.length; col++) {
				if ((row + col) == (rowPos + colPos)) {
					board[row][col] = " ";
				} else if (col - row == colPos - rowPos) {
					board[row][col] = " ";
				}
			}
		}
		return board;
	}

	public static String[][] setSquare(String[][] board) {
		for (int row = 1; row < board.length; row++) {
			for (int col = 1; col < board.length; col++) {
				board[row][col] = "+";
			}
		}
		return board;
	}

	public static String[][] setNums(String[][] board) {
		String[] columnHeaders = { " ", "a", "b", "c", "d", "e", "f", "g", "h" };
		String[] rowHeaders = { " ", "8", "7", "6", "5", "4", "3", "2", "1" };

		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				if (row == 0) {
					board[row][col] = columnHeaders[col];
				} else if (col == 0) {
					board[row][col] = rowHeaders[row];
				}
			}
		}

		return board;
	}

	public static String[][] setBishop(String[][] board, int rowPos, int colPos) {
		for (int row = 1; row < board.length; row++) {
			for (int col = 1; col < board.length; col++) {
				if (row == rowPos && col == colPos) {
					board[row][col] = "\u001B[31m\u265D\u001B[0m";
				}
			}
		}
		return board;
	}

	public static void printBoard(String[][] board) {
		StringBuilder boardStr = new StringBuilder();

		for (int row = 0; row < board.length; row++) {
			for (int columna = 0; columna < board[row].length; columna++) {
				if (columna + 1 == board[row].length) {
					boardStr.append(board[row][columna] + " " + "\n");
				} else {
					boardStr.append(board[row][columna] + " ");
				}
			}
		}
		System.out.println(boardStr);
	}

}
