/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

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

        int[] array1 = funciones.FuncionesArray.crearArrayRandom(100, 0, 20);
        funciones.FuncionesArray.mostrarArrayPantalla(array1);
        int valor1 = funciones.LeerDatosTeclado.enterInt("Introduce valor 1 que se encuentren en el array:");
        int valor2 = funciones.LeerDatosTeclado.enterInt("Introduce valor 2 por el cual cambiar el valor 1:");
        funciones.FuncionesArray.mostrarArrayPantalla(changeValue(array1, valor1, valor2));

    }

    public static int[] changeValue(int[] x, int y, int z) {
        int[] array1 = x;
        int valor1 = y;
        int valor2 = z;

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == valor1) {
                array1[i] = valor2;
            }
        }

        return array1;
    }

}
