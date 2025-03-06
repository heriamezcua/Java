/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int number = funciones.LeerDatosTeclado.enterInt("Introduce numero entero:");

        int even = 0, odd = 0;
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                even += i;
            } else {
                odd += i;
            }
        }

        System.out.println("++Sumatoria++\nNumeros pares: " + even + "\nNumeros impares: " + odd);
    }

}

