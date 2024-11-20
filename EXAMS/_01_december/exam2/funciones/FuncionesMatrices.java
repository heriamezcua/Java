/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _01_december.exam2.funciones;

/**
 *
 * @author amezc
 */
public class FuncionesMatrices {

    public static int[][] crearMatriz(int filas, int columnas, int numero) {
        int[][] matriz = new int[filas][columnas];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = numero;
            }
        }

        return matriz;
    }

    public static int[][] crearMatrizAleatoria(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = funciones.Calcular.calcRandomInt(0, 9);
            }
        }

        return matriz;
    }

    public static int[][] crearMatrizAleatoria(int filas, int columnas, int minimo, int maximo) {
        int[][] matriz = new int[filas][columnas];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = funciones.Calcular.calcRandomInt(minimo, maximo);
            }
        }

        return matriz;
    }

    public static int[][] cargarMatrizTeclado(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                matriz[fila][columna] = funciones.LeerDatosTeclado.enterInt("Introduce elemento " + fila + columna + ":");
            }
        }

        return matriz;
    }

    public static int[][] cargarMatrizTeclado(int filas, int columnas, int minimo, int maximo) {
        int[][] matriz = new int[filas][columnas];
        int elemento = 0;

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                do {
                    elemento = funciones.LeerDatosTeclado.enterInt("Introduce elemento " + fila + columna + " (entre " + minimo + " y " + maximo + "):");
                    matriz[fila][columna] = elemento;
                    if (elemento < minimo || elemento > maximo) {
                        System.out.println("Error, elemento fuera de rango");
                    }
                } while (elemento < minimo || elemento > maximo);
            }
        }

        return matriz;
    }

    public static void mostrarMatrizPantalla(int[][] tuMatriz) {
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

    //funciones para generar un tablero
    public static void mostrarTablero(int[][] tablero) {
        String fichaAPintar = "";

        for (int filaTablero = 0; filaTablero < tablero.length; filaTablero++) {
            System.out.print((" ---").repeat(tablero.length) + "\n");
            for (int columnaTablero = 0; columnaTablero < tablero[filaTablero].length; columnaTablero++) {
                fichaAPintar = sacarFicha(tablero, filaTablero, columnaTablero);
                construirCasilla(tablero, filaTablero, columnaTablero, fichaAPintar);
            }
        }
        System.out.print((" ---").repeat(tablero.length) + "\n");

    }

    public static final String RESALTAR_ROJO = "\u001B[31m";
    public static final String RESETEAR_COLOR = "\u001B[0m";
    public static final int CASILLA_VACIA = 0;
    public static final int FICHA_CIRCULO = 1;
    public static final int FICHA_EQUIS = 2;

    public static void mostrarTablero(int[][] tablero, int fila, int columna) {
        String fichaAPintar = "";

        for (int filaTablero = 0; filaTablero < tablero.length; filaTablero++) {
            System.out.print((" ---").repeat(tablero.length) + "\n");
            for (int columnaTablero = 0; columnaTablero < tablero[filaTablero].length; columnaTablero++) {
                fichaAPintar = sacarFicha(tablero, filaTablero, columnaTablero);

                //lo unico que diferencia a las dos funciones mostrarTablero es esta linea de codigo que "resalta" la ficha de color rojo
                fichaAPintar = (fila == filaTablero && columna == columnaTablero) ? RESALTAR_ROJO + fichaAPintar + RESETEAR_COLOR : fichaAPintar;
                construirCasilla(tablero, filaTablero, columnaTablero, fichaAPintar);
            }
        }
        System.out.print((" ---").repeat(tablero.length) + "\n");
    }

    //con esta funcion evitamos duplicar codigo en ambas funciones mostrarTablero
    public static String sacarFicha(int[][] tablero, int filaTablero, int columnaTablero) {
        String fichaAPintar = "";

        switch (tablero[filaTablero][columnaTablero]) {
            case FICHA_CIRCULO:
                fichaAPintar = "O";
                break;
            case FICHA_EQUIS:
                fichaAPintar = "X";
                break;
            default:
                fichaAPintar = " ";
                break;
        }

        return fichaAPintar;
    }

    //con esta funcion tambien evitamos duplicar codigo en ambas funciones mostrarTablero
    public static void construirCasilla(int[][] tablero, int filaTablero, int columnaTablero, String fichaAPintar) {

        if (columnaTablero + 1 == tablero[filaTablero].length) {
            System.out.print(" " + fichaAPintar + " |\n");

        } else if (columnaTablero == 0) {
            System.out.print("| " + fichaAPintar + " |");

        } else {
            System.out.print(" " + fichaAPintar + " |");

        }

    }

}
