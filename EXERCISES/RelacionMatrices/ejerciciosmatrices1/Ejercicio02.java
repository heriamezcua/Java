/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices1;

/**
 *
 * @author amezc
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = funciones.FuncionesMatrices.cargarMatrizTeclado(2, 2);

        System.out.println(printTabla(matriz));
    }

    public static String printTabla(int[][] tuMatriz) {
        String outputMessage = "";
        int[][] matriz = tuMatriz;

        for (int fila = 0; fila <= matriz.length; fila++) {
            outputMessage+="\n";
            if (fila == matriz.length) {
                for (int columna = 0; columna <= matriz[0].length; columna++) {
                    if (fila == matriz.length && columna == matriz[0].length) {
                        outputMessage+= sumaTotal(matriz);
                    }else{
                        outputMessage += sumarColumna(extraerColumna(matriz, columna))+" ";
                        
                    }
                }
            } else {
                for (int columna = 0; columna <= matriz[fila].length; columna++) {
                    if(columna== matriz[fila].length){
                        outputMessage += sumarFila(extraerFila(matriz, fila));
                    }else{
                        outputMessage += matriz[fila][columna] + " ";
                    }
                }
            }
        }

        return outputMessage;
    }

    public static int sumaTotal(int[][] tuMatriz) {
        int[][] matriz = tuMatriz;
        int sumatoriaFilas = 0;
        int sumatoriaColumnas = 0;
        int sumaTotal = 0;

        for (int[] fila : matriz) {
            sumatoriaFilas += sumarFila(fila);
        }

        for (int columna = 0; columna < matriz.length; columna++) {
            sumatoriaColumnas += sumarColumna(extraerColumna(matriz, columna));
        }

        sumaTotal = sumatoriaFilas + sumatoriaColumnas;

        return sumaTotal;

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

    public static int[][] calcMatrizTraspuesta(int[][] tuMatriz) {
        int[][] matriz = tuMatriz;
        int[][] matrizTraspuesta = new int[matriz[0].length][matriz.length];

        for (int fila = 0; fila < matrizTraspuesta[0].length; fila++) {
            for (int columna = 0; columna < matrizTraspuesta.length; columna++) {
                matrizTraspuesta[columna][fila] = matriz[fila][columna];
            }
        }

        return matrizTraspuesta;
    }

    public static int sumarFila(int[] tuFila) {
        int[] fila = tuFila;
        int sumatoria = 0;

        for (int elemento : fila) {
            sumatoria += elemento;
        }

        return sumatoria;
    }

    public static int sumarColumna(int[] tuColumna) {
        int[] columna = tuColumna;
        int sumatoria = 0;

        for (int elemento : columna) {
            sumatoria += elemento;
        }

        return sumatoria;
    }

}
