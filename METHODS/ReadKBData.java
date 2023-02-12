/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methods;

import java.util.Scanner;

/**
 * Class with different methods to facilitate data keyboard entry.
 *
 * @author Hoxuro
 * @version 1.0
 * @since JDK 19
 */
public class ReadKBData {

    /**
     * Method that asks the user to enter an integer type number and also
     * validates it.
     *
     * @param message the message that we want to display on the screen before
     * requesting the number.
     * @return a valid integer.
     */
    public static int enterInt(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNextInt()) {
            do {
                System.out.println("Please enter the data correctly!");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }

    /**
     * Method that asks the user to enter an String type data and also validates
     * it.
     *
     * @param message the message that we want to display on the screen before
     * requesting the String.
     * @return a valid String.
     */
    public static String enterString(String message) {
        Scanner input = new Scanner(System.in);

        //remember that you can change the delimiter
        System.out.println(message);

        if (!input.hasNext()) {
            do {
                System.out.println("Please enter the data correctly!");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNext());
        }

        return input.next();
    }

    /**
     * Method that asks the user to enter a double type number and also
     * validates it.
     *
     * @param message the message that we want to display on the screen before
     * requesting the String.
     * @return a valid double.
     */
    public static double enterDouble(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNextDouble()) {
            do {
                System.out.println("Please enter the data correctly!");
                input.nextLine();
            } while (!input.hasNextDouble());
        }

        return input.nextDouble();
    }

}
