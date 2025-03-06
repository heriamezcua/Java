/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methods;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/**
 * Class that gives us different methods to work with arrays.
 *
 * @author Hoxuro
 * @version 1.0
 * @since JDK 19
 */
public class ArrayMethods {

    /**
     * Prints in screen your array of integer numbers.
     *
     * @param array the array you want to print on screen.
     */
    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    /**
     * Prints in screen in your array of integer numbers upside down.
     *
     * @param array the array you want to print upside down on screen
     */
    public static void displayReverseArray(int[] array) {
        for (int element = array.length - 1; element >= 0; element--) {
            System.out.print(array[element] + " ");
        }
        System.out.println("");
    }

    /**
     * Ask the user to fill the array introducing by keyboard the int array
     * elements.
     *
     * @param elements the length of the array.
     * @return an array whose elements have been entered by the user.
     */
    public static int[] fill(int elements) {
        int array[] = new int[elements];

        for (int element = 0; element < array.length; element++) {
            array[element] = ReadKBData.enterInt("Enter an integer number: ");
        }

        return array;
    }

    /**
     * Ask the user to fill the array introducing by keyboard the position you
     * want to fill, the int value and if you want to continue.
     *
     * @param elements the length of the array
     * @return an array whose elements and positions have been entered by the
     * user.
     */
    public static int[] fillPosition(int elements) {
        int[] array = new int[elements];
        //the position you want to fill / if you want to stop
        int position = 0, stop;

        do {
            do {
                position = ReadKBData.enterInt("Array with " + array.length + " positions\nEnter the position you want to fill :") - 1;
                if (position < 0 || position >= array.length) {
                    System.out.println("ERROR, position our of range!");
                }
            } while (position < 0 || position >= array.length);

            array[position] = ReadKBData.enterInt("Enter the value for the position " + (position + 1) + ":");
            stop = ReadKBData.enterInt("You want to continue? (1 = yes, 0 = no)");
        } while (stop == 1);

        return array;
    }

    /**
     * Creates a random array whose elements range from 0 to 9.
     *
     * @param elements the length of the array.
     * @return an array whose elements have been generated randomly.
     */
    public static int[] fillRandom(int elements) {
        int array[] = new int[elements];

        for (int element = 0; element < array.length; element++) {
            array[element] = (int) (Math.random() * 10);
        }
        return array;
    }

    /**
     * Creates a random array whose elements range from min to max both entered
     * by the user.
     *
     * @param elements the array length.
     * @param min the integer from which the random can start to be generated.
     * @param max the integer from which the random stops being generated.
     * @return an array whose elements have been generated randomly from a range
     * entered by the user.
     */
    public static int[] fillRandom(int elements, int min, int max) {
        int array[] = new int[elements];

        for (int element = 0; element < array.length; element++) {
            array[element] = (int) (Math.random() * ((max + 1) - min) + min);
        }
        return array;
    }

    /**
     * Creates an array whose elements are squares from others of the array.
     *
     * @param array the array you want to extract other with only squares of
     * other elements.
     * @return an array whose elements are squares from others of the introduced
     * array.
     */
    public static int[] fillSquare(int[] array) {
        int numCuadrados = 0;

        //primero calculo la longitud del array de cuadrados
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] == Math.pow(array[j], 2)) {
                        numCuadrados++;
                    }

                }
            }
        }

        int[] arrayCuadrados = new int[numCuadrados];
        int contador = 0;
        for (int i = 0; i < array.length && contador != numCuadrados; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] == Math.pow(array[j], 2)) {
                        arrayCuadrados[contador] = array[i];
                        contador++;
                    }

                }
            }
        }

        return arrayCuadrados;

    }

    /**
     * Creates an array whose elements are cubes from others of the array.
     *
     * @param array the array you want to extract other with only cubes of other
     * elements.
     * @return an array whose elements are cubes from others of the introduced
     * array.
     */
    public static int[] fillCubos(int[] array) {
        int numCubos = 0;

        //primero calculo la longitud del array de cubos
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] == Math.pow(array[j], 3)) {
                        numCubos++;
                    }

                }
            }
        }

        int[] arrayCubos = new int[numCubos];
        int contador = 0;
        for (int i = 0; i < array.length && contador != numCubos; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    if (array[i] == Math.pow(array[j], 3)) {
                        arrayCubos[contador] = array[i];
                        contador++;
                    }

                }
            }
        }

        return arrayCubos;

    }

    /**
     * returns the largest number in the array.
     *
     * @param array the array you want to extract the largest number.
     * @return the largest number of the array.
     */
    public static int returnMax(int[] array) {

        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }

        return max;
    }

    /**
     * returns the smallest number in the array.
     *
     * @param array the array you want to extract the largest number.
     * @return the largest number of the array.
     */
    public static int returnMin(int[] array) {

        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }

        return min;
    }

    /**
     * Calculates the average of the sum of the elements of the array
     *
     * @param array the array we want to calculate the average.
     * @return a double value that represents the average of the elements sum of
     * the array with two decimals.
     */
    public static double calAverage(double[] array) {
        double media = 0;

        for (double elemento : array) {
            media += elemento;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        df.setRoundingMode(RoundingMode.FLOOR);

        return Double.parseDouble(df.format(media / array.length));
    }

    /**
     * Check element of the array that repeats itself more often.
     *
     * @param array the array we are going to search the element.
     * @return the element that repeats itself more often.
     */
    public static double calcTrend(double[] array) {
        double trend = array[0];
        int repeatElem = 0, repeatTrend = 0;

        for (double elemento : array) {
            for (double elemento2 : array) {
                if (elemento == elemento2) {
                    repeatElem++;
                }
            }

            if (repeatElem > repeatTrend) {
                trend = elemento;
                repeatTrend = repeatElem;
            }

            repeatElem = 0;
        }

        return trend;
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

    /**
     * Compacts an array. Eliminates the element whose index we introduce by
     * parameter, compacts the array and returns it.
     *
     * @param array the array we want to compact
     * @param index the index of the element we are going to eliminate
     * @return the compacted array
     */
    public static int[] compact(int[] array, int index) {
        //copy all the elements from index+1 to the end of the array into another array
        int[] copy = new int[array.length - (index + 1)];
        System.arraycopy(array, index + 1, copy, 0, array.length - (index + 1));

        //move them one position to the left
        System.arraycopy(copy, 0, array, index, copy.length);

        //the last element need to be empty because it has been compacted and should be 0
        array[array.length - 1] = 0;

        //creo el array compactado
        int[] compactado = new int[array.length - 1];
        System.arraycopy(array, 0, compactado, 0, compactado.length);

        return compactado;
    }

}
