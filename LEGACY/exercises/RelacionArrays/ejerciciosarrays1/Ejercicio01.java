/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elem= funciones.LeerDatosTeclado.enterInt("Introduce la cantidad de elementos del array: ");
        int [] myArray= funciones.FuncionesArray.cambiarElementoArray(elem);
        funciones.FuncionesArray.mostrarArrayPantalla(myArray);
    }
}
