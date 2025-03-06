/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;
import java.math.BigInteger;
/**
 *
 * @author amezc
 */
public class Ejercicio15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("En el rango -50 - +50 ocurre:");
        System.out.println("Suma multiplos 5: "+getSumaMult5());
        System.out.println("Cantidad de numeros pares: "+getPares());
        System.out.println("Producto de numeros negativos: "+getProdNegNum());

    }

    public static int getSumaMult5() {
        int sumaMult5 = 0;

        for (int i = -50; i <= 50; i++) {
            if (i % 5 == 0) {
                sumaMult5 += i;
            }
        }

        return sumaMult5;
    }

    public static int getPares() {
        int pares = 0;

        for (int i = -50; i <= 50; i++) {
            if (i % 2 == 0 && i != 0) {
                pares += 1;
            }
        }

        return pares;
    }

    public static BigInteger getProdNegNum() {

        BigInteger prodNeg = BigInteger.ONE;

        for (int i = -50; i <= 50; i++) {
            if (i < 0) {
                prodNeg = prodNeg.multiply(BigInteger.valueOf(2));
            }
        }

        return prodNeg;

    }

}

