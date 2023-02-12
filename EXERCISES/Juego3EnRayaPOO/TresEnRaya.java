/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegotresenraya;

/**
 * Class that allow us to create a tic-tac-toe like program and play it.
 *
 * @author Hoxuro
 * @version 1.0
 */
public class TresEnRaya {

    private int[][] tablero;
    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_EQUIS = 1;
    public static final int FICHA_CIRCULO = 2;

    /**
     * Default constructor that create a tic-tac-toe board with size 3x3 board
     * squares.
     */
    public TresEnRaya() {
        this.tablero = FuncionesMatrices.crearMatriz(3, 3, CASILLA_VACIA);
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
            arrayLinea = FuncionesMatrices.extraerFila(this.tablero, fila);
            if (FuncionesMatrices.comprobarFila(arrayLinea)) {
                hayTresEnRaya = true;
            }
        }

        /**
         * Loop that checks all columns in search of three tokens aligned
         */
        for (int fila = 0; fila < this.tablero.length; fila++) {
            for (int columna = 0; columna < this.tablero[fila].length; columna++) {
                arrayLinea = FuncionesMatrices.extraerColumna(this.tablero, columna);
                if (FuncionesMatrices.comprobarFila(arrayLinea)) {
                    hayTresEnRaya = true;
                }
            }
        }

        /**
         * Loop that checks the main diagonal in search of three tokens aligned
         */
        if (FuncionesMatrices.comprobarFila(FuncionesMatrices.extraerDiagonalPrin(this.tablero))) {
            hayTresEnRaya = true;
        }

        /**
         * Loop that checks the secondary diagonal in search of three tokens
         * aligned
         */
        if (FuncionesMatrices.comprobarFila(FuncionesMatrices.extraerDiagonalSec(this.tablero))) {
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
}
