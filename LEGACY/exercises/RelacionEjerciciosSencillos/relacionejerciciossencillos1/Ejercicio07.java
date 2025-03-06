/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio07 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int mayor = 0, menor = 0, container = 0;

        for (int i = 0; i < 5; i++) {
            container = funciones.LeerDatosTeclado.enterInt("Introduce numero entero:");
            if (i == 0) {
                mayor = container;
                menor = container;

            } else if (container > mayor) {
                mayor = container;

            } else if (container < menor) {
                menor = container;
            }
        }

        System.out.println("El mayor numero itroducido es: " + mayor + "\nEl menor numero introducido es: " + menor);

    }

}
