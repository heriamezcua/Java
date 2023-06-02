/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package methods;

import java.util.Arrays;

/**
 *
 * @author amezc
 */
public class MAIN {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {3, 1, 2, 0};
        System.out.println(array.length);
        for (int elemento : array) {
            System.out.print(elemento
                    + " ");
        }
        System.out.println("");
        compactar(array);
        for (int elemento : array) {
            System.out.print(elemento
                    + " ");
        }

        System.out.println(array.length);
        System.out.println(compactar(array));

    }

    public static int[] compactar(int[] array) {

        order(array);

        do {
            int indice = Arrays.binarySearch(array, 1);
            int[] mitad1 = new int[indice + 1];
            int[] mitad2 = new int[array.length - indice];
            System.arraycopy(array, 0, mitad1, 0, indice);
            System.arraycopy(array, indice + 1, mitad2, 0, array.length-2);

            int[] arrayCompactado = new int[mitad1.length + mitad2.length];
            System.arraycopy(mitad1, 0, arrayCompactado, 0, mitad1.length);
            System.arraycopy(mitad2, mitad1.length+1, arrayCompactado, mitad1.length+1, mitad2.length-1);
            array = arrayCompactado;

        } while (Arrays.binarySearch(array, 1) >= 0);

        return array;

    }

    /**
     * Sorts the entered array in ascending order.
     *
     * @param array the array that we want to sort
     */
    public static void order(int[] array) {

        //for each element of the array
        for (int elem = 0; elem < array.length; elem++) {
            //I get the value of the following element
            int nextElem = elem + 1;

            //as long as the next element is less than the length of the array
            while (nextElem < array.length) {
                //if the next element is less than the current element
                if (array[nextElem] < array[elem]) {
                    //exchange positions
                    int container = array[elem];
                    array[elem] = array[nextElem];
                    array[nextElem] = container;
                }

                nextElem++;
            }
        }

    }

}
