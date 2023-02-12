/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegotresenraya;

import java.util.Scanner;

/**
 *
 * @author amezc
 */
public class LeerDatosTeclado {

    /**
     * Method that ask the user to enter a string and validate if the string is
     * correct
     *
     * @param message a message to show to the user
     * @return a validated string
     */
    public static String enterString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNext()) {
            do {
                System.out.println("ERROR. Introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNext());
        }

        return input.next();
    }

    /**
     * Method that ask the user to enter an int and validate if the int is
     * correct
     *
     * @param message
     * @return a validated int
     */
    public static int enterInt(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNextInt()) {
            do {
                System.out.println("ERROR. Introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }
}
