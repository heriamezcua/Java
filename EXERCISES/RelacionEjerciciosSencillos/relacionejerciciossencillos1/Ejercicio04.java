/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int number = funciones.LeerDatosTeclado.enterInt("Introduce numero entero:");

        int numbersSumation = 0;
        for (int initialNumber = 1; initialNumber <= number; initialNumber++) {
            numbersSumation += initialNumber;
        }

        System.out.println("La sumatoria de numeros desde 1 hasta " + number + " es: " + numbersSumation);
    }

}
