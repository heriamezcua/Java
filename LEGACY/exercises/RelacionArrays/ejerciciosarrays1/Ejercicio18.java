/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;
import java.util.Arrays;
/**
 *
 * @author amezc
 */
public class Ejercicio18 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] arrayRandom = funciones.FuncionesArray.crearArrayRandom(10, 0, 200);
        System.out.println("ARRAY ORIGINAL");
        System.out.println(printIndexArray(arrayRandom));
        System.out.println("ARRAY ARRAY ORDENADO");
        Arrays.sort(arrayRandom);
        System.out.println(printOrden(arrayRandom));

    }

    public static String printIndexArray(int[] x) {
        int[] array = x;
        int cifras = 0;
        String finalMessage = "Indice:";

        for (int i = 0; i < array.length; i++) {
            int numb = array[i];
            cifras = 0;
            do {
                cifras += 1;
                numb /= 10;
            } while (numb != 0);

            switch (cifras) {
                case 1:
                    finalMessage += " " + i;
                    break;
                case 2:
                    finalMessage += "  " + i;
                    break;
                case 3:
                    finalMessage += "   " + i;
                    break;
                default:
                    throw new AssertionError("ERROR");
            }
        }

        finalMessage += "\nValor: ";

        for (int i = 0; i < array.length; i++) {
            int numb = array[i];
            cifras = 0;
            do {
                cifras += 1;
                numb /= 10;
            } while (numb != 0);

            switch (cifras) {
                case 1:
                    finalMessage += " " + array[i];
                    break;
                case 2:
                    finalMessage += " " + array[i];
                    break;
                case 3:
                    finalMessage += " " + array[i];
                    break;
                default:
                    throw new AssertionError("ERROR");
            }
        }

        return finalMessage;
    }

    public static String printOrden(int[] x) {
        int[] array = x;
        int cifras = 0;
        String finalMessage = "Indice:";
        int turno = 1;

        for (int i = 0; i < array.length; i++) {
            if (i < 100 && turno % 2 != 0) {
                int numb = array[i];
                cifras = 0;
                do {
                    cifras += 1;
                    numb /= 10;
                } while (numb != 0);

                switch (cifras) {
                    case 1:
                        finalMessage += " " + i;
                        break;
                    case 2:
                        finalMessage += "  " + i;
                        break;
                    case 3:
                        finalMessage += "   " + i;
                        break;
                    default:
                        throw new AssertionError("ERROR");
                }
                turno++;
            } else {
                int numb = array[i];
                cifras = 0;
                do {
                    cifras += 1;
                    numb /= 10;
                } while (numb != 0);

                switch (cifras) {
                    case 1:
                        finalMessage += " " + i;
                        break;
                    case 2:
                        finalMessage += "  " + i;
                        break;
                    case 3:
                        finalMessage += "   " + i;
                        break;
                    default:
                        throw new AssertionError("ERROR");
                }
                turno++;
            }
        }

        finalMessage += "\nValor: ";

        for (int i = 0; i < array.length; i++) {
            if (i < 100 && turno % 2 != 0) {
                int numb = array[i];
                cifras = 0;
                do {
                    cifras += 1;
                    numb /= 10;
                } while (numb != 0);

                switch (cifras) {
                    case 1:
                        finalMessage += " " + array[i];
                        break;
                    case 2:
                        finalMessage += "  " + array[i];
                        break;
                    case 3:
                        finalMessage += "   " + array[i];
                        break;
                    default:
                        throw new AssertionError("ERROR");
                }
                turno++;
            } else {
                int numb = array[i];
                cifras = 0;
                do {
                    cifras += 1;
                    numb /= 10;
                } while (numb != 0);

                switch (cifras) {
                    case 1:
                        finalMessage += " " + array[i];
                        break;
                    case 2:
                        finalMessage += "  " + array[i];
                        break;
                    case 3:
                        finalMessage += "   " + array[i];
                        break;
                    default:
                        throw new AssertionError("ERROR");
                }
                turno++;
            }
        }

        return finalMessage;

    }

}
