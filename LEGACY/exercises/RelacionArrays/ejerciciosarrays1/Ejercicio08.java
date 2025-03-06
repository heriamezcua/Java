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
public class Ejercicio08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array1 = fillArray(12);
        System.out.println(printTable(array1));
    }

    public static int[] fillArray(int x) {
        Scanner input = new Scanner(System.in);
        int elementos = x;
        int myArray[] = new int[elementos];
        int mes = 0;
        int temperatura = 0;

        for (int i = 0; i < myArray.length; i++) {
            mes++;

            do {
                temperatura = funciones.LeerDatosTeclado.enterInt("Introduce temperatura mes " + mes + ": ");

                if (temperatura < -20 || temperatura > 40) {
                    System.out.println("ERROR. Rango de temperatura incorrecto");
                }
            } while (temperatura < -20 || temperatura > 40);

            myArray[i] = temperatura;
        }

        return myArray;
    }

    public static String printTable(int[] x) {
        int[] arrayTemp = x;
        String finalMessage = "TABLA TEMPERATURA MEDIA DE LOS MESES DEL ANIO";

        for (int i = 0; i < arrayTemp.length; i++) {
            switch (i) {
                case 0:
                    finalMessage += "\nENERO:         ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 1:
                    finalMessage += "\nFEBRERO:       ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 2:
                    finalMessage += "\nMARZO:         ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 3:
                    finalMessage += "\nABRIL:         ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 4:
                    finalMessage += "\nMAYO:          ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 5:
                    finalMessage += "\nJUNIO:         ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 6:
                    finalMessage += "\nJULIO:         ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 7:
                    finalMessage += "\nAGOSTO:        ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 8:
                    finalMessage += "\nSEPTIEMBRE:    ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 9:
                    finalMessage += "\nOCTUBRE:       ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 10:
                    finalMessage += "\nNOVIEMBRE:     ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
                    break;
                case 11:
                    finalMessage += "\nDICIEMBRE:     ";
                    for (int j = 0; j <= arrayTemp[i]; j++) {
                        finalMessage += "*";
                    }
            }
        }

        return finalMessage;
    }
}
