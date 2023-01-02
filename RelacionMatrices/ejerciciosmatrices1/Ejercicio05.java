/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices1;

/**
 *
 * @author amezc
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] matriz = funciones.FuncionesMatrices.crearMatrizAleatoria(6, 10, 0, 70);
        funciones.FuncionesMatrices.mostrarMatrizPantalla(matriz);
        System.out.println(returnMaxPosition(matriz));

    }

    public static String returnMaxPosition(int[][] tuMatriz) {
        int[][] matriz = tuMatriz;
        int max = matriz[0][0];
        String maxIndex = "Fila: 0, Columna: 0";

        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] > max) {
                    max = matriz[fila][columna];
                    maxIndex = matriz[fila][columna] + "| Fila: " + fila + ", Columna: " + columna;
                }
            }
        }

        return maxIndex;
    }
}
