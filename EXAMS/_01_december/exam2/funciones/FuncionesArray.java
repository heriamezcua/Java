/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _01_december.exam2.funciones;

import java.util.Scanner;

/**
 *
 * @author amezc
 */
public class FuncionesArray {

    //INT
    public static void mostrarArrayPantalla(int[] array) {
        for (int elemento = 0; elemento < array.length; elemento++) {
            if (elemento + 1 == array.length) {
                System.out.print(array[elemento] + "\n");
            } else {
                System.out.print(array[elemento] + " ");
            }
        }
    }

    public static void mostrarArrayRevesPantalla(int[] x) {
        for (int i = x.length - 1; i >= 0; i--) {
            System.out.print(x[i] + " ");
        }
    }

    public static int[] cargarArrayTeclado(int elementos) {
        Scanner input = new Scanner(System.in);
        int myArray[] = new int[elementos];

        for (int elemento = 0; elemento < myArray.length; elemento++) {
            myArray[elemento] = funciones.LeerDatosTeclado.enterInt("Introduce elemento " + elemento + ":");
        }

        return myArray;
    }

    public static int[] cambiarElementoArray(int x) {
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

    public static int[] crearArrayRandom(int elementos) {
        int myArray[] = new int[elementos];

        for (int elemento = 0; elemento < myArray.length; elemento++) {
            double random = Math.random() * 10;
            myArray[elemento] = (int) Math.round(random);
        }
        return myArray;
    }

    public static int[] crearArrayRandom(int elementos, int minimo, int maximo) {
        int myArray[] = new int[elementos];

        for (int elemento = 0; elemento < myArray.length; elemento++) {
            int iniNum = minimo;
            int finNum = maximo;
            double random = Math.random() * (finNum - iniNum) + iniNum;
            myArray[elemento] = (int) Math.round(random);
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
            arrayString += n + " ";
        }
        return arrayString;
    }

    public static double[] crearArrayRandomDouble(int elementos) {
        double myArray[] = new double[elementos];

        for (int elemento = 0; elemento < myArray.length; elemento++) {
            double random = Math.random() * 10;
            myArray[elemento] = Math.round(random);
        }
        return myArray;
    }

    public static double returnMax(double[] tuArray) {
        double[] array = tuArray;
        double max = array[0];

        for (double elemento : array) {
            if (elemento > max) {
                max = elemento;
            }
        }

        return max;
    }

    public static double returnMin(double[] tuArray) {
        double[] array = tuArray;
        double min = array[0];

        for (double elemento : array) {
            if (elemento < min) {
                min = elemento;
            }
        }

        return min;
    }

    public static double calcMedia(double[] tuArray) {
        double[] array = tuArray;
        double media = 0;

        for (double elemento : array) {
            media += elemento;
        }

        return media;
    }

    public static double calcModa(double[] tuArray) {
        double[] array = tuArray;
        double moda = array[0];
        int repeticionesParc = 0;
        int repeticionesModa = 0;

        for (double elemento : array) {
            for (double elementoComp : array) {
                if (elemento == elementoComp) {
                    repeticionesParc++;
                }
            }

            if (repeticionesParc > repeticionesModa) {
                moda = elemento;
                repeticionesModa = repeticionesParc;
            }

            repeticionesParc = 0;
        }

        return moda;
    }


}
