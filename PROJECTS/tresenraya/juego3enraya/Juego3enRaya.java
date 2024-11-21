
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tresenraya.juego3enraya;

/**
 *
 * @author amezc
 */
public class Juego3enRaya {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] tablero = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int ficha = 2;
        int x = 0;
        int y = 0;
        boolean isColocada = false;
        String player1 = funciones.LeerDatosTeclado.enterString("Jugador 1. Introduce tu nombre: ");
        String player2 = funciones.LeerDatosTeclado.enterString("Jugador 2. Introduce tu nombre");
        String estaJugando = "";

        mostrarTablero(tablero);
        do {

            ficha = (ficha == 1) ? 2 : 1;
            estaJugando = (ficha == 1) ? player1 : player2;
            System.out.println("------------------------------");
            System.out.println(estaJugando + " te toca");

            do {
                x = funciones.LeerDatosTeclado.enterInt("Introduce fila (1 al 3):") - 1;
                y = funciones.LeerDatosTeclado.enterInt("Introduce columna (1 al 3):") - 1;
                isColocada = colocarFicha(tablero, ficha, x, y);

            } while (!isColocada);

            tablero[x][y] = ficha;
            mostrarTablero(tablero, x, y);

        } while (!juegoTerminado(tablero) && !hayGanador(tablero));

        if (hayGanador(tablero)) {
            System.out.println("Enhorabuena " + estaJugando + " has ganado!!");
        }

        if (juegoTerminado(tablero)) {
            System.out.println("Tablas. Todas las casillas estan llenas");
        }

    }

    public static final String RESALTAR_ROJO = "\u001B[31m";
    public static final String RESETEAR_COLOR = "\u001B[0m";

    public static void mostrarTablero(int[][] tuTablero) {
        int[][] tablero = tuTablero;

        for (int fila = 0; fila < tablero.length; fila++) {
            System.out.print("-------------\n");
            for (int columna = 0; columna < tablero[fila].length; columna++) {

                if (columna + 1 == tablero[fila].length) {
                    switch (tablero[fila][columna]) {
                        case 1:
                            System.out.print(" X |\n");
                            break;
                        case 2:
                            System.out.print(" 0 |\n");
                            break;
                        default:
                            System.out.print("   |\n");
                            break;
                    }
                } else if (columna == 0) {
                    switch (tablero[fila][columna]) {
                        case 1:
                            System.out.print("| " + "X" + " |");
                            break;
                        case 2:
                            System.out.print("| " + "0" + " |");
                            break;
                        default:
                            System.out.print("| " + " " + " |");
                            break;
                    }
                } else {
                    switch (tablero[fila][columna]) {
                        case 1:
                            System.out.print(" " + "X |");
                            break;
                        case 2:
                            System.out.print(" " + "0 |");
                            break;
                        default:
                            System.out.print(" " + "  |");
                            break;
                    }
                }
            }
        }
        System.out.print("-------------\n");

    }

    public static void mostrarTablero(int[][] tablero, int fila, int columna) {

        for (int filaTablero = 0; filaTablero < tablero.length; filaTablero++) {
            System.out.print((" ---").repeat(tablero.length) + "\n");
            for (int columnaTablero = 0; columnaTablero < tablero[filaTablero].length; columnaTablero++) {

                if (columnaTablero + 1 == tablero[filaTablero].length) {
                    if (filaTablero == fila && columnaTablero == columna) {
                        switch (tablero[filaTablero][columnaTablero]) {
                            case 1:
                                System.out.print(" ");
                                System.out.print(RESALTAR_ROJO + "X" + RESETEAR_COLOR);
                                System.out.print(" |\n");
                                break;
                            case 2:
                                System.out.print(" ");
                                System.out.print(RESALTAR_ROJO + "0" + RESETEAR_COLOR);
                                System.out.print(" |\n");
                                break;
                            default:
                                System.out.print("   |\n");
                                break;
                        }
                    } else {
                        switch (tablero[filaTablero][columnaTablero]) {
                            case 1:
                                System.out.print(" X |\n");
                                break;
                            case 2:
                                System.out.print(" 0 |\n");
                                break;
                            default:
                                System.out.print("   |\n");
                                break;
                        }
                    }
                } else if (columnaTablero == 0) {

                    if (filaTablero == fila && columnaTablero == columna) {
                        switch (tablero[filaTablero][columnaTablero]) {
                            case 1:
                                System.out.print("| ");
                                System.out.print(RESALTAR_ROJO + "X" + RESETEAR_COLOR);
                                System.out.print(" |");
                                break;
                            case 2:
                                System.out.print("| ");
                                System.out.print(RESALTAR_ROJO + "0" + RESETEAR_COLOR);
                                System.out.print(" |");
                                break;
                            default:
                                System.out.print("| " + " " + " |");
                                break;
                        }
                    } else {
                        switch (tablero[filaTablero][columnaTablero]) {
                            case 1:
                                System.out.print("| " + "X" + " |");
                                break;
                            case 2:
                                System.out.print("| " + "0" + " |");
                                break;
                            default:
                                System.out.print("| " + " " + " |");
                                break;
                        }
                    }

                } else {
                    if (filaTablero == fila && columnaTablero == columna) {
                        switch (tablero[filaTablero][columnaTablero]) {
                            case 1:
                                System.out.print(" ");
                                System.out.print(RESALTAR_ROJO + "X" + RESETEAR_COLOR);
                                System.out.print(" |");
                                break;
                            case 2:
                                System.out.print(" " + RESALTAR_ROJO + "0" + RESETEAR_COLOR + " |");
                                break;
                            default:
                                System.out.print(" " + "  |");
                                break;
                        }
                    } else {
                        switch (tablero[filaTablero][columnaTablero]) {
                            case 1:
                                System.out.print(" " + "X |");
                                break;
                            case 2:
                                System.out.print(" " + "0 |");
                                break;
                            default:
                                System.out.print(" " + "  |");
                                break;
                        }
                    }
                }
            }
        }
        System.out.print((" ---").repeat(tablero.length) + "\n");

    }

    public static boolean colocarFicha(int[][] tablero, int ficha, int x, int y) {
        boolean colocada = false;
        boolean isEnRango = false;

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (fila == x && columna == y) {
                    isEnRango = true;
                    if (tablero[fila][columna] == 0) {
                        tablero[fila][columna] = ficha;
                        colocada = true;
                    } else {
                        System.out.println("ERROR. Ya hay una ficha en esa posicion...");
                    }
                }
            }
        }

        if (!isEnRango) {
            System.out.println("ERROR. Introduce posicion del 1 al 3...");
        }

        return colocada;
    }

    public static boolean hayGanador(int[][] tablero) {
        boolean tresEnLinea = false;
        int[] arrayLinea = new int[3];

        for (int fila = 0; fila < tablero.length; fila++) {
            arrayLinea = extraerFila(tablero, fila);
            if (comprobarFila(arrayLinea)) {
                tresEnLinea = true;
            }
        }

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                arrayLinea = extraerColumna(tablero, columna);
                if (comprobarFila(arrayLinea)) {
                    tresEnLinea = true;
                }
            }
        }

        if (comprobarFila(extraerDiagonalPrin(tablero))) {
            tresEnLinea = true;
        }

        if (comprobarFila(extraerDiagonalSec(tablero))) {
            tresEnLinea = true;
        }

        return tresEnLinea;
    }

    public static boolean comprobarFila(int[] fila) {
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

    public static int[] extraerFila(int[][] matriz, int indiceFila) {
        int[] filaArray = new int[matriz[indiceFila].length];

        for (int elemento = 0; elemento < matriz[0].length; elemento++) {
            filaArray[elemento] = matriz[indiceFila][elemento];
        }

        return filaArray;
    }

    public static int[] extraerColumna(int[][] matriz, int indiceColumna) {
        int[] columnaArray = new int[matriz.length];

        for (int elemento = 0; elemento < matriz.length; elemento++) {
            columnaArray[elemento] = matriz[elemento][indiceColumna];
        }

        return columnaArray;
    }

    public static int[] extraerDiagonalPrin(int[][] matriz) {
        int[] diagonalArray = new int[matriz.length];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz.length; columna++) {
                diagonalArray[fila] = matriz[fila][fila];
            }
        }

        return diagonalArray;
    }

    public static int[] extraerDiagonalSec(int[][] matriz) {
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

    public static boolean juegoTerminado(int[][] tablero) {
        boolean terminado = false;
        int contadorCeros = 0;

        for (int[] fila : tablero) {
            for (int elemento : fila) {
                if (elemento == 0) {
                    contadorCeros++;
                }

            }
        }

        terminado = (contadorCeros == 0) ? true : false;

        return terminado;
    }

}
