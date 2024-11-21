/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.funciones;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Clase con diferentes metodos que facilitan la entrada de datos validados por
 * teclado.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class LeerDatosTeclado {

    /**
     * Método que le pide al usuario que ingrese un número de tipo entero y
     * también lo valida.
     *
     * @param message el mensaje que queremos mostrar en la pantalla solicitando
     * el número.
     * @return un entero válido.
     */
    public static int enterInt(String message) {
        Scanner input = new Scanner(System.in);

        if (!Pattern.matches("^\\s*$", message)) {
            System.out.println(message);
        }

        if (!input.hasNextInt()) {
            do {
                System.err.println("Por favor, introduzca los datos correctamente");
                input.nextLine();

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }

    /**
     * Método que le pide al usuario que introduzca un dato tipo String y
     * también lo valida.
     *
     * @param message el mensaje que queremos mostrar en la pantalla solicitando
     * el String.
     * @return una string válido.
     */
    public static String enterString(String message) {
        Scanner input = new Scanner(System.in);

        //remember that you can change the delimiter
        if (!Pattern.matches("^\\s*$", message)) {
            System.out.println(message);
        }

        if (!input.hasNext()) {
            do {
                System.err.println("Por favor, introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNext());
        }

        return input.next();
    }

    /**
     * Método que le pide al usuario que introduzca un dato tipo String y
     * también lo valida.
     *
     * @param message el mensaje que queremos mostrar en la pantalla solicitando
     * el String.
     * @return una string válido.
     */
    public static String enterStringNextLine(String message) {
        Scanner input = new Scanner(System.in);

        //remember that you can change the delimiter
        if (!Pattern.matches("^\\s*$", message)) {
            System.out.println(message);
        }
        if (!input.hasNextLine()) {
            do {
                System.err.println("Por favor, introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextLine());
        }

        return input.nextLine();
    }

    /**
     * Método que le pide al usuario que introduzca un dato tipo booleano y
     * también lo valida.
     *
     * @param message el mensaje que queremos mostrar en la pantalla solicitando
     * el booleano.
     * @return un booleano válido.
     */
    public static boolean enterBoolean(String message) {
        Scanner input = new Scanner(System.in);

        //remember that you can change the delimiter
        System.out.println(message);

        if (!input.hasNextBoolean()) {
            do {
                System.err.println("Por favor, introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextBoolean());
        }

        return input.nextBoolean();
    }

}
