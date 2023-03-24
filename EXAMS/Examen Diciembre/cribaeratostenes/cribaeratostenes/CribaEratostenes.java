/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cribaeratostenes;

import java.util.Scanner;

/**
 *
 * @author DAW-B
 */
public class CribaEratostenes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int numero = 50;
        boolean[] criba = cribaEratostenes(numero);
        mostrarArrayPantalla(criba);
        mostrarArrayPantalla(nPrimosEratostenes(criba));

    }

    public static boolean[] cribaEratostenes(int n) {
        boolean[] arrayBooleanos = crearArrayInicial(n);
        int contador = 0;

        for (int elemento = 2; elemento < arrayBooleanos.length; elemento++) {
            if (arrayBooleanos[elemento] == true) {
                for (int multiplo = elemento + 1; multiplo < arrayBooleanos.length; multiplo++) {
                    if (multiplo % elemento == 0) {
                        arrayBooleanos[multiplo] = false;
                    }
                }
            }
        }

        return arrayBooleanos;
    }

    public static int[] nPrimosEratostenes(boolean[] criba) {
        int nPrimos = 0;

        for (boolean elemento : criba) {
            if (elemento) {
                nPrimos++;
            }
        }

        int[] arrayEnteros = new int[nPrimos];

        for (int elementoCriba = 0; elementoCriba < criba.length; elementoCriba++) {
            for (int elemento = 0; elemento < arrayEnteros.length; elemento++) {
                if (criba[elementoCriba]) {
                    arrayEnteros[elemento] = elementoCriba;
                }
            }
        }

        int contador = 0;
        do {
            for (int elementoCriba = 0; elementoCriba < criba.length; elementoCriba++) {
                if (criba[elementoCriba]) {
                    arrayEnteros[contador] = elementoCriba;
                    contador++;
                }
            }
        } while (contador < nPrimos);

        return arrayEnteros;
    }

    public static boolean[] crearArrayInicial(int elementos) {
        boolean[] array = new boolean[elementos];

        for (int elemento = 0; elemento < array.length; elemento++) {
            switch (elemento) {
                case 0:
                    array[elemento] = false;
                    break;
                case 1:
                    array[elemento] = false;
                    break;
                default:
                    array[elemento] = true;
                    break;
            }
        }

        return array;
    }

    public static void mostrarArrayPantalla(int[] array) {
        for (int elemento = 0; elemento < array.length; elemento++) {
            if (elemento + 1 == array.length) {
                System.out.print(array[elemento] + "\n");
            } else {
                System.out.print(array[elemento] + " ");
            }
        }
    }

    public static void mostrarArrayPantalla(boolean[] array) {
        for (int elemento = 0; elemento < array.length; elemento++) {
            if (elemento + 1 == array.length) {
                System.out.print(array[elemento] + "\n");
            } else {
                System.out.print(array[elemento] + " ");
            }
        }
    }

}
