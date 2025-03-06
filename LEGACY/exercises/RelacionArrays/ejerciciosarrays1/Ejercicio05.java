/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

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
        int[] myArray = funciones.FuncionesArray.cargarArrayTeclado(10);
        System.out.println("Maximo: " + funciones.FuncionesArray.returnMax(myArray));
        System.out.println("Minimo: " + funciones.FuncionesArray.returnMin(myArray));

    }

}
