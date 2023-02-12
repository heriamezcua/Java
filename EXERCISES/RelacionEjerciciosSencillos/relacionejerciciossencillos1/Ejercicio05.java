/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int number = funciones.LeerDatosTeclado.enterInt("Introduce numero entero:");

        System.out.println("Primeros " + number + " multiplos de 3");

        int counter = 0, initialNumber = 1;
        while (counter != number) {
            initialNumber++;
            if (initialNumber % 3 == 0) {
                System.out.println(initialNumber);
                counter++;
            }
        }
    }

}
