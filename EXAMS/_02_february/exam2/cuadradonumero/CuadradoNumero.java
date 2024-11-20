/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _02_february.exam2.cuadradonumero;

import java.util.Scanner;

/**
 *
 * @author amezc
 */
public class CuadradoNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int num = enterInt("Introduce un numero (0 para terminar): ");
        do {
            if (num != 0) {
                System.out.println(cuadradoSumando(num));
                num = enterInt("Introduce un numero (0 para terminar): ");
            }
        } while (num != 0);
    }

    /**
     * Calcula el cuadrado de un numero siguiendo un algoritmo que dice que si
     * sumamos los numeros impares por orden desde el 1 hasta el valor absoluto
     * del numero el cual queremos calcular su cuadrado obtendremos su cuadrado.
     *
     * @param n el numero cuyo cuadrado queremos obtener
     * @return el cuadrado de n
     */
    public static int cuadradoSumando(int n) {
        int abs = Math.abs(n), cuadrado = 0;

        int num = 1;
        while (abs != 0) {
            if (num % 2 != 0) {
                cuadrado += num;
                abs--;
            }
            num++;
        }

        return cuadrado;
    }

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

}
