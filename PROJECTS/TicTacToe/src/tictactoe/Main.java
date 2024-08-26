package tictactoe;

import methods.ReadKBData;

public class Main {

    public static void main(String[] args) {

        int contPlaying = 1;
        do {
            // Variable declaration default values
            String player1;
            String player2;

            final int TOKEN_0 = 1;
            final int TOKEN_X = 2;

            boolean isPlaying1 = true;
            int currentToken = TOKEN_0;

            int[][] board = new int[3][3];  // a new empty board

            boolean hasTicTacToe;  // the game ends when tic-tac-toe
            boolean isBoardFull; // the game ends when is full

            // Implementing the game logic
            // asking for the user's name
            player1 = ReadKBData.enterString("Player 1 name: ");
            player2 = ReadKBData.enterString("Player 2 name: ");
            int row;
            int col;

            System.out.print("\n");
            do {
                if (isPlaying1) {
                    System.out.println("\u001B[33m" + player1 + "\u001B[0m is your turn");
                } else {
                    System.out.println("\u001B[32m" + player2 + "\u001B[0m is your turn");
                }

                boolean setted = false;
                do {
                    // ask for the row to set the token in the board
                    row = askRowOrColumn(1) - 1;

                    // ask for the column to set the token in the board
                    col = askRowOrColumn(2) - 1;

                    // setting the token in the entered position
                    setted = setToken(row, col, currentToken, board);
                    if (!setted) {
                        System.err.println("The position must be empty! Try again.");
                    }
                } while (!setted);

                // print the current board state
                printBoard(board, row, col);
                // check if tic-tac-toe or full board
                hasTicTacToe = ticTacToe(board);
                isBoardFull = isBoardFull(board);

                if (!hasTicTacToe) {
                    // Finally change the turn
                    isPlaying1 = !isPlaying1;
                    currentToken = (currentToken == TOKEN_0) ? TOKEN_X : TOKEN_0;
                }
            } while (!hasTicTacToe && !isBoardFull);

            // Print final result message
            if (hasTicTacToe) {
                String winner = (isPlaying1 ? "\u001B[33m" + player1 + "\u001B[0m" : "\u001B[32m" + player2 + "\u001B[0m");
                System.out.println("\u001B[33m" + winner + " has made tic-tac-toe! " + winner + " has won!\u001B[0m");
            } else {
                System.out.println("\u001B[34mIt's a draw! The board is full...\u001B[0m");
            }

            // ask the user if he wants to play again
            do {
                contPlaying = ReadKBData.enterInt("Do you want to play again? (1. yes | 0. no)");

                if (contPlaying != 1 && contPlaying != 0) {
                    System.err.print("Please, enter a number between 1 and 0...");
                }
            } while (contPlaying != 1 && contPlaying != 0);

        } while (contPlaying == 1);
    }

    /**
     * Ask the user to enter a number that is the row or column position in the board.
     *
     * @param value 1 if we want the row position other if we want the column
     * @return the user entered number
     */
    public static int askRowOrColumn(int value) {
        String name = (value == 1) ? "row" : "column";
        int number;

        // ask for the row or column to set the token in the board
        do {
            number = ReadKBData.enterInt("Enter the " + name + " to set the next token: ");

            if (number < 1 || number > 3) {
                System.err.println("Invalid " + name + ". Please enter a number between 1 and 3");
            }
        } while (number < 1 || number > 3);

        return number;
    }

    /**
     * Set the token in the board.
     *
     * @param row   the row of the board
     * @param col   the column of the board
     * @param token the current player token
     * @param board the current game board where we want to set the token
     * @return true if the token is setted correctly or false if not
     */
    public static boolean setToken(int row, int col, int token, int[][] board) {
        boolean isSetted = false;

        if (board[row][col] == 0) {
            board[row][col] = token;
            isSetted = true;
        }

        return isSetted;
    }

    /**
     * Checks if the given array of 3 elements has tic-tac-toe.
     *
     * @param line an array of three elements that can be row, column or diagonal
     * @return true if the given array has three same values
     */
    public static boolean checkLine(int[] line) {
        boolean hasTicTacToe = true;

        int previous = line[0];
        for (int index = 1; index < 3 && hasTicTacToe; index++) {
            // There is no tictactoe if some square is empty or different in a line
            if (previous != line[index] || previous == 0 || line[index] == 0) {
                hasTicTacToe = false;
            }
            previous = line[index];
        }

        return hasTicTacToe;
    }


    /**
     * Check if one user has three tokens in a row.
     *
     * @param board the current board game
     * @return true if exists tic-tact-toe
     */
    public static boolean ticTacToe(int[][] board) {
        boolean hasTicTacToe = false;

        // First we want to check the rows
        for (int row = 0; row < 3 && !hasTicTacToe; row++) {
            hasTicTacToe = checkLine(board[row]);
        }

        if (!hasTicTacToe) {
            // Now we want to check the columns
            int[] column = new int[board.length];
            for (int col = 0; col < 3 && !hasTicTacToe; col++) {
                for (int row = 0; row < 3; row++) {
                    column[row] = board[row][col];
                }
                hasTicTacToe = checkLine(column);
            }
        }

        if (!hasTicTacToe) {
            // Finally we want to check the diagonals
            int[] mainDiag = new int[board.length];
            int[] secDiag = new int[board.length];

            // "extracting" both diagonals
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (row == col) {
                        mainDiag[row] = board[row][col];
                    }
                    // sec diagonal formula row + col = num of cols - 1
                    if (row + col == board.length - 1) {
                        secDiag[row] = board[row][col];
                    }
                }
            }
            hasTicTacToe = checkLine(mainDiag);

            if (!hasTicTacToe) {
                hasTicTacToe = checkLine(secDiag);
            }
        }

        return hasTicTacToe;
    }

    /**
     * Check if the board is full of tokens.
     *
     * @param board the current board state
     * @return true if the board is full
     */
    public static boolean isBoardFull(int[][] board) {
        boolean isFull = true;

        for (int[] row : board) {
            for (int elem : row) {
                if (elem == 0) {
                    isFull = false;
                }
            }
        }

        return isFull;
    }

    /**
     * Prints the specific square value. Prints red if is the last entered position.
     *
     * @param token      the token value of the square
     * @param lastSetted true if is the last setted token
     */
    public static void printSquare(int token, boolean lastSetted) {
        String tokenToPrint = " ";
        if (token == 1) {
            tokenToPrint = (lastSetted) ? "\u001B[31mX\u001B[0m" : "X";
        } else if (token == 2) {
            tokenToPrint = (lastSetted) ? "\u001B[31m0\u001B[0m" : "0";
        }
        System.out.print(" " + tokenToPrint + " ");
    }

    /**
     * Prints the current board state in the console.
     *
     * @param board the current board game.
     */
    public static void printBoard(int[][] board, int lastRow, int lastCol) {
        System.out.println("\n|---|---|---|");
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print("|");
                if (row == lastRow && col == lastCol) {
                    printSquare(board[row][col], true);
                } else {
                    printSquare(board[row][col], false);
                }
            }
            System.out.println("|");
            // row separator
            if (row < 2) {
                System.out.println("|---|---|---|");
            }
        }
        System.out.println("|---|---|---|\n");
    }

}