/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos2;

/**
 *
 * @author amezc
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int respuesta = 0;
        int aleatorio = (int) aleatorio(0, 10);

        System.out.println("Adivina numero intervalo 0-10:");
        do {
            respuesta = funciones.LeerDatosTeclado.enterInt("Introduce numero:");
            if (respuesta != aleatorio) {
                if (respuesta < aleatorio) {
                    System.out.println("El numero es mayor que " + respuesta);
                } else {
                    System.out.println("El numero es menor que " + respuesta);
                }
            }
        } while (respuesta != aleatorio);

        System.out.println("Correcto! El numero era " + aleatorio);
    }

    public static double aleatorio(int x, int y) {
        int iniNum = x;
        int finNum = y;
        double random = Math.random() * (finNum - iniNum) + iniNum;

        return random;
    }
}
