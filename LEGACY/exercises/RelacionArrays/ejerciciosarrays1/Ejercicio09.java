/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = funciones.FuncionesArray.cargarArrayTeclado(8);
        int[] arrayPares = fillPar(array);
        int[] arrayImp = fillImpar(array);

        funciones.FuncionesArray.mostrarArrayPantalla(arrayPares);
        funciones.FuncionesArray.mostrarArrayPantalla(arrayImp);
    }

    public static int[] fillPar(int[] x) {
        int[] array = x;
        int pares = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] != 0) {
                pares++;
            }
        }

        int[] arrayPar = new int[pares];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0 && array[i] != 0) {
                arrayPar[j] = array[i];
                j++;
            }
        }

        return arrayPar;
    }

    public static int[] fillImpar(int[] x) {
        int[] array = x;
        int impares = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] != 0) {
                impares++;
            }
        }

        int[] arrayImp = new int[impares];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0 && array[i] != 0) {
                arrayImp[j] = array[i];
                j++;
            }
        }

        return arrayImp;
    }
}
