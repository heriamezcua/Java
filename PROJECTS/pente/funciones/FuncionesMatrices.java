/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pente.funciones;

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

    public static int[] extraerFila(int[][] tuMatriz, int tuIndiceFila) {
        int[][] matriz = tuMatriz;
        int indiceFila = tuIndiceFila;
        int[] filaArray = new int[matriz[indiceFila].length];

        for (int elemento = 0; elemento < matriz[0].length; elemento++) {
            filaArray[elemento] = matriz[indiceFila][elemento];
        }

        return filaArray;
    }

    public static int[] extraerColumna(int[][] tuMatriz, int tuIndiceColumna) {
        int[][] matriz = tuMatriz;
        int indiceColumna = tuIndiceColumna;
        int[] columnaArray = new int[matriz[indiceColumna].length];

        for (int elemento = 0; elemento < matriz.length; elemento++) {
            columnaArray[elemento] = matriz[elemento][indiceColumna];
        }

        return columnaArray;
    }
    

}
