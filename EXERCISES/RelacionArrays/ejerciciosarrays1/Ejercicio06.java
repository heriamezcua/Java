/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array1 = funciones.FuncionesArray.cargarArrayTeclado(15);
        int[] arrayRotado = rotarArray(array1);
        System.out.println("Tu array rotado 1 posicion:");
        funciones.FuncionesArray.mostrarArrayPantalla(arrayRotado);
    }

    public static int[] rotarArray(int[] x) {
        int[] array = x;
        int actNum = 0;
        int preNum = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                actNum = array[i];
                preNum = array[array.length - 1];
                array[i] = preNum;
                preNum = actNum;
            } else if (i == array.length - 1) {
                array[i] = preNum;
            } else {
                actNum = array[i];
                array[i] = preNum;
                preNum = actNum;
            }
        }

        return array;
    }
}

