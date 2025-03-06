/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;
import java.util.Scanner;

/**
 *
 * @author amezc
 */
public class FuncionesArray {

    //INT
    public static String printArrayInt(int[] x) {
        String arrayString = "";
        for (int n : x) {
            arrayString += n + " ";
        }
        return arrayString;
    }

    public static String printReverseArrayInt(int[] x) {
        String arrayString = "";
        for (int i = x.length - 1; i >= 0; i--) {
            arrayString += x[i] + " ";
        }
        return arrayString;
    }

    public static int[] fillArrayInt(int x) {
        Scanner input = new Scanner(System.in);
        int elementos = x;
        int myArray[] = new int[elementos];

        int container = 0;
        System.out.println("Array de " + myArray.length + " elementos");
        do {
            myArray[container] = funciones.LeerDatosTeclado.enterInt("Introduce elemento " + (container + 1));
            container++;
        } while (container < myArray.length);

        return myArray;
    }

    public static int[] fillArrayPositionInt(int x) {
        Scanner input = new Scanner(System.in);
        int elementos = x;
        int[] myArray = new int[elementos];
        int changeElem = 0;
        int continuar = 0;

        do {
            do {
                changeElem = LeerDatosTeclado.enterInt("Array 1D, con " + myArray.length + " posiciones\nIntroduce posicion a rellenar:") - 1;
                if (changeElem < 0 || changeElem >= myArray.length) {
                    System.out.println("ERROR POSICION FUERA DE RANGO");
                }
            } while (changeElem < 0 || changeElem >= myArray.length);

            myArray[changeElem] = LeerDatosTeclado.enterInt("Introduce el valor:");
            continuar = LeerDatosTeclado.enterInt("Desea continuar? (1 = si, 0 = no)");
        } while (continuar == 1);

        return myArray;
    }

    public static int[] fillArrayRandom(int x, int y, int z) {
        int elementos = x;
        int myArray[] = new int[elementos];

        for (int i = 0; i < myArray.length; i++) {
            int iniNum = y;
            int finNum = z;
            double random = Math.random() * (finNum - iniNum) + iniNum;
            myArray[i] = (int) Math.round(random);
        }
        return myArray;
    }

    public static int[] fillCuadrados(int[] x) {
        int cuadrados = 0;
        int[] introArray = x;

        for (int i : introArray) {
            for (int j : introArray) {
                if (Math.pow(i, 2) == j) {
                    cuadrados++;
                }
            }
        }

        int[] exitArray = new int[cuadrados];
        int matIndex = 0;

        for (int i : introArray) {
            for (int j : introArray) {
                if (Math.pow(i, 2) == j) {
                    exitArray[matIndex] = j;
                    matIndex++;
                }
            }
        }

        return exitArray;

    }

    public static int[] fillCubos(int[] x) {
        int cubos = 0;
        int[] introArray = x;

        for (int i : introArray) {
            for (int j : introArray) {
                if (Math.pow(i, 3) == j) {
                    cubos++;
                }
            }
        }

        int[] exitArray = new int[cubos];
        int matIndex = 0;

        for (int i : introArray) {
            for (int j : introArray) {
                if (Math.pow(i, 3) == j) {
                    exitArray[matIndex] = j;
                    matIndex++;
                }
            }
        }

        return exitArray;

    }

    public static int returnMax(int[] x) {
        int[] introArray = x;
        int max = introArray[0];

        for (int i : introArray) {
            if (i > max) {
                max = i;
            }
        }

        return max;
    }

    public static int returnMin(int[] x) {
        int[] introArray = x;
        int min = introArray[0];

        for (int i : introArray) {
            if (i < min) {
                min = i;
            }
        }

        return min;
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

    //STRING
    public static String printArrayString(String[] x) {
        String arrayString = "";
        for (int i = 0; i < x.length; i++) {
            arrayString += x[i] + " ";
        }
        return arrayString;
    }

    public static String[] fillArrayString(int x) {
        Scanner input = new Scanner(System.in);
        int elementos = x;
        String myArray[] = new String[elementos];

        for (int i = 0; i < myArray.length; i++) {
            System.out.println("Introduce numero entero: ");
            myArray[i] = input.next();
        }

        return myArray;
    }

    public static String[] fillArrayPositionString(int x) {
        Scanner input = new Scanner(System.in);
        int elementos = x;
        String[] myArray = new String[elementos];
        int changeElem = 0;
        int continuar = 0;

        do {
            do {
                changeElem = LeerDatosTeclado.enterInt("Array 1D, con " + myArray.length + " posiciones\nIntroduce posicion a rellenar:") - 1;
                if (changeElem < 0 || changeElem >= myArray.length) {
                    System.out.println("ERROR POSICION FUERA DE RANGO");
                }
            } while (changeElem < 0 || changeElem >= myArray.length);

            myArray[changeElem] = LeerDatosTeclado.enterString("Introduce el valor:");
            continuar = LeerDatosTeclado.enterInt("Desea continuar? (1 = si, 0 = no)");
        } while (continuar == 1);

        return myArray;
    }

    //DOUBLE
    public static String printArrayDouble(double[] x) {
        String arrayString = "";

        for (double n : x) {
            arrayString += n;
        }
        return arrayString;
    }

}
