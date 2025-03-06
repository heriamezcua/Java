/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package methods;

/**
 * Class with different methods to perform mathematical calculations.
 *
 * @author Hoxuro
 * @version 1.0
 * @since JDK 19
 */
public class Calculate {

    /**
     * Method that calculates a random number within a range determined by the
     * user.
     *
     * @param numIni the number where the random number starts to be generated.
     * @param numFin the last number where the random number is generated.
     * @return a random number within a user given range.
     */
    public static int calcRandomInt(int numIni, int numFin) {
        return (int) (Math.random() * ((numFin + 1) - numIni) + numIni);
    }

}
