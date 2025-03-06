/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = funciones.FuncionesArray.cargarArrayTeclado(10);
        System.out.println(printSolution(array));
    }

    public static String printSolution(int[] x) {
        int[] array = x;
        String finalMessage = "INDICE ";
        for (int i = 0; i < 10; i++) {
            finalMessage += i + " ";
        }
        finalMessage+="\nVALOR  ";
        for (int j = 0; j < array.length; j++) {
            finalMessage += array[j] + " ";
        }
        
        return finalMessage;
    }
}
