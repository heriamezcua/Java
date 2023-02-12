/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = funciones.FuncionesArray.crearArrayRandom(100, 0, 500);
        funciones.FuncionesArray.mostrarArrayPantalla(array);
        System.out.println(destacar(array));
    }

    public static String destacar(int[] x) {
        int[] array = x;
        int valor = 0;
        int minimo = array[0];
        int maximo = array[0];
        String outputMessage = "";

        do {
            valor = funciones.LeerDatosTeclado.enterInt("Que quiere destacar? (1-maximo / 2-minimo)");
            if (valor != 1 && valor != 2) {
                System.out.println("Error, introduzca correctamente");
            }
        } while (valor != 1 && valor != 2);

        for (int i : array) {
            if (i < minimo) {
                minimo = i;
            } else if (i > maximo) {
                maximo = i;
            }
        }

        if (valor == 1) {
            for (int i : array) {
                if (i == maximo) {
                    outputMessage += " ***" + i + "*** ";
                } else {
                    outputMessage += i + " ";
                }
            }
        } else {
            for (int i : array) {
                if (i == minimo) {
                    outputMessage += "***" + i + "***";
                } else {
                    outputMessage += i + " ";
                }
            }
        }

        return outputMessage;

    }
}
