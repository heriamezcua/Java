/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos2;

/**
 *
 * @author amezc
 */
public class Ejercicio06 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int l1= funciones.LeerDatosTeclado.enterInt("Introduce lado 1:");
        int l2= funciones.LeerDatosTeclado.enterInt("Introduce lado 2:");
        int l3= funciones.LeerDatosTeclado.enterInt("Introduce lado 3:");
        double sp= (l1+l2+l3)/2;
        double area= Math.sqrt(sp*(sp-l1)*(sp-l2)*(sp-l3));
        System.out.println("El area es: ");
        System.out.printf("%1.2f", area);
        System.out.println(" u2");
    }
    
}
