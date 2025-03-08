/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaserializacion;

import java.io.Serializable;

/**
 * Class that allow us to create a tic-tac-toe like program and play it.
 *
 * @author Hoxuro
 * @version 1.0
 */
public class TresEnRaya implements Serializable {

    private int[][] tablero;
    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_EQUIS = 1;
    public static final int FICHA_CIRCULO = 2;

    /**
     * Default constructor that create a tic-tac-toe board with size 3x3 board
     * squares.
     */
    public TresEnRaya() {
        this.tablero = fill(3, 3, CASILLA_VACIA);
    }

    /**
     * Method that set a token in the position the user wants.
     *
     * @param ficha the token of the user, X or O.
     * @param x The x axis position.
     * @param y The Y axis position.
     * @return true if the token is correctly settled.
     */
    public boolean colocarFicha(int ficha, int x, int y) {
        boolean isColocada = false;

        if (ficha != CASILLA_VACIA && ficha != FICHA_EQUIS && ficha != FICHA_CIRCULO) {
            throw new IllegalArgumentException("La ficha introducida no es valida");
        }

        if ((x >= 0 && x <= 2) && (y >= 0 && y <= 2)) {
            this.tablero[x][y] = ficha;
            isColocada = true;
        }

        return isColocada;
    }

    /**
     * Method that checks if there are tic-tac-toe.
     *
     * @return true if the current user has tic-tac-toe.
     */
    public boolean hayGanador() {
        boolean hayTresEnRaya = false;
        int[] arrayLinea = new int[3];

        /**
         * Loop that checks all rows in search of three tokens aligned
         */
        for (int fila = 0; fila < this.tablero.length; fila++) {
            arrayLinea = extractRow(this.tablero, fila);
            if (comprobarFila(arrayLinea)) {
                hayTresEnRaya = true;
            }
        }

        /**
         * Loop that checks all columns in search of three tokens aligned
         */
        for (int fila = 0; fila < this.tablero.length; fila++) {
            for (int columna = 0; columna < this.tablero[fila].length; columna++) {
                arrayLinea = extractColumn(this.tablero, columna);
                if (comprobarFila(arrayLinea)) {
                    hayTresEnRaya = true;
                }
            }
        }

        /**
         * Loop that checks the main diagonal in search of three tokens aligned
         */
        if (comprobarFila(extraerDiagonalPrin(this.tablero))) {
            hayTresEnRaya = true;
        }

        /**
         * Loop that checks the secondary diagonal in search of three tokens
         * aligned
         */
        if (comprobarFila(extraerDiagonalSec(this.tablero))) {
            hayTresEnRaya = true;
        }

        return hayTresEnRaya;
    }

    public boolean juegoTerminado() {
        boolean terminado = false;
        int contadorCeros = 0;

        for (int[] fila : this.tablero) {
            for (int elemento : fila) {
                if (elemento == 0) {
                    contadorCeros++;
                }

            }
        }

        terminado = (contadorCeros == 0);

        return terminado;
    }

    /**
     * Getter method that return us the current tic-tac-board.
     *
     * @return the current tic-tac-board.
     */
    public int[][] getTablero() {
        return this.tablero;
    }

    private static boolean comprobarFila(int[] fila) {
        int contIguales = 1;
        boolean tresEnLinea = false;

        for (int elemento = 0; elemento < fila.length; elemento++) {
            if (elemento + 1 != fila.length) {
                if (fila[elemento] == fila[elemento + 1] && fila[elemento] != 0) {
                    contIguales++;
                    if (contIguales == 3) {
                        tresEnLinea = true;
                    }
                }
            }
        }

        return tresEnLinea;
    }

    /**
     * Fills a matrix with the number entered by the user.
     *
     * @param rows the rows of the matrix
     * @param columns the columns of the matrix
     * @param number the number to fill the matrix with
     * @return the matrix filled in with the number we wanted
     */
    private static int[][] fill(int rows, int columns, int number) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = number;
            }
        }

        return matrix;
    }

    /**
     * Extract the wanted row from the matrix by giving the index of it.
     *
     * @param matrix the matrix we want to extract a row
     * @param rowIndex the index of the row we want to extract starts in 0
     * @return an array which is the wanted row
     */
    private static int[] extractRow(int[][] matrix, int rowIndex) {

        int[] extractedRow = new int[matrix[rowIndex].length];

        for (int element = 0; element < matrix[rowIndex].length; element++) {
            extractedRow[element] = matrix[rowIndex][element];
        }

        return extractedRow;
    }

    /**
     * Extract the wanted column from the matrix by giving the index of it.
     *
     * @param matrix the matrix we want to extract a row
     * @param columnIndex the index of the column we want to extract starts in 0
     * @return an array which is the wanted column
     */
    private static int[] extractColumn(int[][] matrix, int columnIndex) {
        //only works for square matrices
        int[] extractedColumn = new int[matrix[columnIndex].length];

        for (int element = 0; element < matrix.length; element++) {
            extractedColumn[element] = matrix[element][columnIndex];
        }

        return extractedColumn;
    }

    /**
     * Method which extracts the main diagonal from a matrix.
     *
     * @param matriz
     * @return the main diagnoal from the matrix inserted
     */
    private static int[] extraerDiagonalPrin(int[][] matriz) {
        int[] diagonalArray = new int[matriz.length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                diagonalArray[fila] = matriz[fila][fila];
            }
        }

        return diagonalArray;
    }

    /**
     * Method which extracts the secondary diagonal from a matrix.
     *
     * @param matriz
     * @return the secondary diagonal from the matrix inserted
     */
    private static int[] extraerDiagonalSec(int[][] matriz) {
        int[] diagonalArray = new int[matriz.length];
        int elemento = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (fila + columna == matriz[fila].length - 1) {
                    diagonalArray[fila] = matriz[fila][columna];
                }
            }
        }

        return diagonalArray;
    }
}
