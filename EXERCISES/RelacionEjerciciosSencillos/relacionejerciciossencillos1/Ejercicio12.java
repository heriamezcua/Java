/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;
import java.util.Scanner;
/**
 *
 * @author amezc
 */
public class Ejercicio12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String number = "" + getNumber();
        boolean capicua = false;

        Scanner input = new Scanner(number);
        input.useDelimiter("\\.");

        int intPart = Integer.parseInt(input.next());
        int decPart = Integer.parseInt(input.next());

        String noDotNum = "" + intPart + decPart;
        String numReverse = getReverse(noDotNum);

        if (noDotNum.equals(numReverse)) {
            capicua = true;
        }

        System.out.println(number+" "+printCapicua(capicua));
    }

    public static double getNumber() {
        double number = funciones.LeerDatosTeclado.enterDouble("Introduce un numero (0 - 9.999)");

        if (number < 0 || number > 9.999) {
            throw new AssertionError("rango incorrecto");
        }

        return number;
    }

    public static String getReverse(String noDotNum) {
        String reverseNum = "";

        for (int i = 1; i <= noDotNum.length(); i++) {
            reverseNum += noDotNum.charAt(noDotNum.length() - i);
        }

        return reverseNum;

    }

    public static String printCapicua(boolean capicua) {

        String finalMessage = "";

        if (capicua) {
            finalMessage = "es capicua";
        } else {
            finalMessage = "no es capicua";
        }

        return finalMessage;
    }
}
