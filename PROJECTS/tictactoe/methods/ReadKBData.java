package methods;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadKBData {

    /**
     * Method that asks the user to enter a String data type and also validates
     * it.
     *
     * @param message the message that we want to display on the screen before
     *                requesting the String.
     * @return a valid String.
     */
    public static String enterString(String message) {
        Scanner input = new Scanner(System.in);

        //remember that you can change the delimiter
        if (!Pattern.matches("^\\s*$", message)) {
            System.out.println(message);
        }

        if (!input.hasNext()) {
            do {
                System.err.println("Please, enter the data correctly");
                input.nextLine();

            } while (!input.hasNext());
        }

        return input.next();
    }

    /**
     * Method that asks the user to enter an integer data type and also
     * validates it.
     *
     * @param message the message that we want to display on the screen before
     *                requesting the number.
     * @return a valid integer.
     */
    public static int enterInt(String message) {
        Scanner input = new Scanner(System.in);

        if (!Pattern.matches("^\\s*$", message)) {
            System.out.println(message);
        }

        if (!input.hasNextInt()) {
            do {
                System.err.println("Please, enter the data correctly");
                input.nextLine();

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }
}