/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos2;

/**
 *
 * @author amezc
 */
public class Ejercicio05 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double h= funciones.LeerDatosTeclado.enterDouble("Introduce tu hipoteca:");
        int n= funciones.LeerDatosTeclado.enterInt("Introduce anios a pagar:");
        double i= funciones.LeerDatosTeclado.enterDouble("Introduce interes anual:")/100;
        double r= i/(100*12);
        double cuotaMensual= (h*r)/(1-Math.pow((1+r), -12*n));
        System.out.print("Su cuota mensual será: ");
        System.out.printf("%1.2f", cuotaMensual);
        System.out.println(" €");
        System.out.print("Le habras pagado al banco totalmente "+(h+h*i)+" €");
    }
    
}
