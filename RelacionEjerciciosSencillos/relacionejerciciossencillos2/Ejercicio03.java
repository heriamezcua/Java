/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos2;

/**
 *
 * @author amezc
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Numeros perfectos 1 al 100:");
        int divisores = 0;

        for (int i = 1; i < 100; i++) {
            divisores = 0;
            for (int j = 1; j < i; j++) {

                if (i % j == 0) {
                    divisores += j;

                }

                if (divisores == i && j == (i - 1)) {
                    System.out.println(i + " ");
                }
            }
        }

    }

}
