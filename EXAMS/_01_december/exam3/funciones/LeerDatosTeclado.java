/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _01_december.exam3.funciones;
import java.util.Scanner;

/**
 *
 * @author amezc
 */
public class LeerDatosTeclado {

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

    public static double enterDouble(String x) {
        Scanner input = new Scanner(System.in);
        String message = x;
        System.out.println(message);

        if (!input.hasNextDouble()) {
            do {
                System.out.println("Error, vuelve a introducir");
                input.nextLine();
            } while (!input.hasNextDouble());
        }

        return input.nextDouble();
    }

    public static String substringDefinido() {
        String tuString = "hoalaaaaa";
        String substring = tuString.substring(Math.max(tuString.length() - 2, 0));
        return substring;
    }
}

