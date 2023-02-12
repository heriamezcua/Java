/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegotresenraya;

/**
 *
 * @author amezc
 */
public class FuncionesMatrices {

    /**
     * Method which create a matrix with a number of rows and columns introduced
     * by the user and all its elements have the same introduced value.
     *
     * @param filas the number of rows that the matrix are going to have.
     * @param columnas the number of columns that the matrix are going to have.
     * @param numero the value of all its elements.
     * @return the desired matrix with a number of rows and columns inserted by
     * the user and all its elements has the same data.
     */
    protected static int[][] crearMatriz(int filas, int columnas, int numero) {
        int[][] matriz = new int[filas][columnas];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = numero;
            }
        }

        return matriz;
    }

    /**
     * Method which extracts the wanted row from a matrix.
     *
     * @param matriz the matrix you want to extract a row.
     * @param indiceFila the row you want to extract.
     * @return the row you wanted.
     */
    protected static int[] extraerFila(int[][] matriz, int indiceFila) {
        int[] filaArray = new int[matriz[indiceFila].length];

        for (int elemento = 0; elemento < matriz[0].length; elemento++) {
            filaArray[elemento] = matriz[indiceFila][elemento];
        }

        return filaArray;
    }

    /**
     * Method which extracts the wanted column from a matrix.
     *
     * @param matriz the matrix you want to extract a row.
     * @param indiceColumna the row you want to extract.
     * @return the row you wanted.
     */
    protected static int[] extraerColumna(int[][] matriz, int indiceColumna) {
        int[] columnaArray = new int[matriz.length];

        for (int elemento = 0; elemento < matriz.length; elemento++) {
            columnaArray[elemento] = matriz[elemento][indiceColumna];
        }

        return columnaArray;
    }

    /**
     * Method which extracts the main diagonal from a matrix.
     *
     * @param matriz
     * @return the main diagnoal from the matrix inserted
     */
    protected static int[] extraerDiagonalPrin(int[][] matriz) {
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
     * @return the secondary diagnoal from the matrix inserted
     */
    protected static int[] extraerDiagonalSec(int[][] matriz) {
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

    protected static boolean comprobarFila(int[] fila) {
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
}
