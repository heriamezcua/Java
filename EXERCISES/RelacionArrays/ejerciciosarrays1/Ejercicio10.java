/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = funciones.FuncionesArray.crearArrayRandom(20, 0, 100);
        int[] arrayPares = fillPar(array);
        int[] arrayImpares = fillImpar(array);
        int[] arraySuma = sumaArray(arrayPares, arrayImpares);
        funciones.FuncionesArray.mostrarArrayPantalla(arraySuma);

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

    public static int[] sumaArray(int[] x, int[] y) {
        int[] array1 = x;
        int[] array2 = y;
        int elemArr3 = 0;

        for (int i = 0; i < array1.length; i++) {
            elemArr3++;
        }

        for (int i = 0; i < array2.length; i++) {
            elemArr3++;
        }

        int[] array3 = new int[elemArr3];
        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            array3[array1.length + i] = array2[i];
        }

        return array3;
    }
}
