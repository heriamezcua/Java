/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;
import java.util.Scanner;
/**
 *
 * @author amezc
 */
public class Ejercicio19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arrayRandom = funciones.FuncionesArray.crearArrayRandom(12, 0, 200);
        System.out.println(funciones.FuncionesArray.printIndexArray(arrayRandom));
        arrayRandom = fillArrayPositionInt(arrayRandom);
        System.out.println(funciones.FuncionesArray.printIndexArray(arrayRandom));

    }

    public static int[] fillArrayPositionInt(int[] x) {
        Scanner input = new Scanner(System.in);
        int[] myArray = x;
        int changeElem = 0;

        do {
            changeElem = funciones.LeerDatosTeclado.enterInt("Array 1D, con " + myArray.length + " posiciones\nIntroduce posicion a insertar:");
            if (changeElem < 0 || changeElem >= myArray.length) {
                System.out.println("ERROR POSICION FUERA DE RANGO");
            }
        } while (changeElem < 0 || changeElem >= myArray.length);
        
        int valor= funciones.LeerDatosTeclado.enterInt("Introduce valor:");

        int keep1 = 0;
        if (changeElem + 1 < myArray.length) {
            keep1 = myArray[changeElem];
        }
        int keep2 = 0;
        myArray[changeElem] = valor;
        myArray[changeElem+ 1] = keep1;

        for (int i = changeElem; i < myArray.length; i++) {
            if (changeElem+ i + 1 < myArray.length) {
                keep2 = myArray[i + 1];
                myArray[changeElem + i+1] = keep1;
                keep1 = keep2;
            }
        }

        return myArray;
    }

}

