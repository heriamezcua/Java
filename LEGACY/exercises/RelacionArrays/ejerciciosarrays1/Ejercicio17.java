/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

import java.util.Arrays;

/**
 *
 * @author amezc
 */
public class Ejercicio17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arrayRandom = funciones.FuncionesArray.crearArrayRandom(10, 0, 100);
        Arrays.sort(arrayRandom);
        funciones.FuncionesArray.mostrarArrayPantalla(arrayRandom);
        int numero = getNumeroDentro(arrayRandom);
        System.out.println("ROTANDO ARRAY AL NUMERO " + numero);
        System.out.println(rotarArray(arrayRandom, numero));

    }

    public static int getNumeroDentro(int[] x) {
        int[] array = x;
        int clave = 0;
        boolean isDentro = false;
        do {
            clave = funciones.LeerDatosTeclado.enterInt("Introduce un clave que se encuentre en el array");
            for (int i : array) {
                if (clave == i) {
                    isDentro = true;
                }
            }
            if (!isDentro) {
                System.out.println("ERROR. El clave debe estar dentro del array");
            }

        } while (!isDentro);

        return clave;
    }

    public static String rotarArray(int[] x, int y) {
        int arrayEntr[] = x;
        int indexRotar = Arrays.binarySearch(arrayEntr, y);
        String finalMessage = "";

        int[] array1 = Arrays.copyOfRange(arrayEntr, indexRotar, (arrayEntr.length - 1));
        for (int i : array1) {
            finalMessage += i + " ";
        }

        finalMessage += arrayEntr[(arrayEntr.length - 1)] + " ";

        int[] array2 = Arrays.copyOfRange(arrayEntr, 0, indexRotar);
        for (int i : array2) {
            finalMessage += i + " ";
        }

        return finalMessage;
    }
}
