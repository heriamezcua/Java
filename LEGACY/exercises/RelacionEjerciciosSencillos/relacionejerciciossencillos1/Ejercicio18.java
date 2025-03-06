/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

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

        int km = getKm();
        int coste = getCoste(km);
        
        System.out.println("Km realizados: "+km+"\nCoste: "+coste+"€");

    }

    public static int getKm() {
        int km = funciones.LeerDatosTeclado.enterInt("Introduce la cantidad de Km realizados: ");

        if (km <= 0) {
            throw new AssertionError("km no puede ser negativo");
        }

        return km;
    }

    public static int getCoste(int km) {

        int coste = 0;

        if (km <= 300) {
            coste += 500;
        } else if (km > 300 && km <= 1000) {
            coste += 500;
            coste += (km - 300) * 2;
        } else {
            coste += 500;
            coste += 700*2;
            coste += km-1000;
        }
        
        return coste;
    }
}
