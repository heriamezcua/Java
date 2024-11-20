/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _01_december.exam2.desplazar;

/**
 *
 * @author DAW-B
 */
public class Desplazar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] elementos = {2, 4, 8, 16, 32};
        int rotarPosiciones = 3;
        rotarIzquierda(elementos, rotarPosiciones);
        funciones.FuncionesArray.mostrarArrayPantalla(elementos);
        
        int[][] matriz= {{2, 4, 8, 16, 32},{2, 4, 8, 16, 32},{2, 4, 8, 16, 32}};
        desplazarFilas(matriz);
        funciones.FuncionesMatrices.mostrarMatrizPantalla(matriz);
    }

    public static void rotarIzquierda(int[] elementos, int n) {

        for (int rotaciones = 0; rotaciones < n; rotaciones++) {
            for (int elemento = 0; elemento < elementos.length - 1; elemento++) {
                rotarArray(elementos);
            }
        }
    }

    public static void desplazarFilas(int[][] matriz) {
        
        int contador=0;
        for (int[] fila : matriz) {
            rotarIzquierda(fila, contador);
            contador++;
        }
    }

    //esta funcion la cree en el ejercicio 6 de la relacion
    //no rota a la izquierda sino derecha pero para ganar tiempo 
    //se que rotar a la izquierda es lo mismo que rotar a la derecha array.length-1 veces
    public static void rotarArray(int[] elementos) {
        int actNum = 0;
        int preNum = 0;

        for (int i = 0; i < elementos.length; i++) {
            if (i == 0) {
                actNum = elementos[i];
                preNum = elementos[elementos.length - 1];
                elementos[i] = preNum;
                preNum = actNum;
            } else if (i == elementos.length - 1) {
                elementos[i] = preNum;
            } else {
                actNum = elementos[i];
                elementos[i] = preNum;
                preNum = actNum;
            }
        }
    }
}
