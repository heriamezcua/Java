/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package submatriz;

import java.util.Scanner;

/**
 *
 * @author Hoxuro
 *
 */
public class Submatriz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int dimension = 0, filaInicial = 0, colInicial = 0, filaFinal = 0, colFinal = 0;

        dimension = enterInt("Introduce la dimension de la matriz: ");
        do {
            if (dimension <= 1) {
                dimension = enterInt("Introduce la dimension de la matriz: ");
            }
        } while (dimension <= 1);
        int[][] matriz = fillRandom(dimension, dimension);

        filaInicial = enterInt("Introduce el indice de la fila inicial");
        filaFinal = enterInt("Introduce el indice de la fila final");
        colInicial = enterInt("Introduce el indice de la columna inicial");
        colFinal = enterInt("Introduce el indice de la columna final");

        display(matriz);
        display(submatriz(matriz, filaInicial, colInicial, filaFinal, colFinal));

    }

    /**
     * Nos permite extraer una submatriz de una matriz.
     *
     * @param matriz la matriz de la que queremos extraer una submatriz
     * @param filaInicial la fila donde se empezara a copiar la submatriz
     * @param colInicial la columna donde se empezara a copiar la submatriz
     * @param filaFinal la fila donde se terminara de copiar la submatriz
     * @param colFinal la columna donde se terminara de copiar la submatriz
     * @return la submatriz deseada
     */
    public static int[][] submatriz(int[][] matriz, int filaInicial, int colInicial, int filaFinal, int colFinal) {
        if (filaFinal - filaInicial + 1 < 1 || colFinal - colInicial + 1 < 1) {
            throw new IllegalArgumentException("rango submatriz Incorrecta");
        }

        int numCols = colFinal - colInicial + 1;
        int numFilas = filaFinal - filaInicial + 1;
        int[][] submatriz = new int[numFilas][numCols];

        for (int fila = 0; fila < submatriz.length; fila++) {
            int[] filaExtraida = extractRow(matriz, filaInicial + fila);

            for (int elem = 0; elem < submatriz[fila].length; elem++) {
                submatriz[fila][elem] = filaExtraida[elem];
            }
        }

        return submatriz;
    }

    /**
     * Extract the wanted row from the matrix by giving the index of it.
     *
     * @param matrix the matrix we want to extract a row
     * @param rowIndex the index of the row we want to extract starts in 0
     * @return an array which is the wanted row
     */
    public static int[] extractRow(int[][] matrix, int rowIndex) {

        int[] extractedRow = new int[matrix[rowIndex].length];

        for (int element = 0; element < matrix[rowIndex].length; element++) {
            extractedRow[element] = matrix[rowIndex][element];
        }

        return extractedRow;
    }

    /**
     * Display the entered matrix.
     *
     * @param tuMatriz
     */
    public static void display(int[][] tuMatriz) {
        int[][] matriz = tuMatriz;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (columna + 1 == matriz[fila].length) {
                    System.out.print(matriz[fila][columna] + "\n");
                } else {
                    System.out.print(matriz[fila][columna] + " ");
                }
            }
        }

    }

    /**
     * Fills a matrix with a random int number from 0 to 9.
     *
     * @param rows the rows of the matrix
     * @param columns the columns of the matrix
     * @return a matrix whose elements have been generated randomly.
     */
    public static int[][] fillRandom(int rows, int columns) {
        int[][] matrix = new int[rows][columns];

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = (int) (Math.random() * (9 + 1));
            }
        }

        return matrix;
    }

    /**
     * Method that asks the user to enter an integer type number and also
     * validates it.
     *
     * @param message the message that we want to display on the screen before
     * requesting the number.
     * @return a valid integer.
     */
    public static int enterInt(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNextInt()) {
            do {
                System.out.println("Please enter the data correctly!");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }

}
