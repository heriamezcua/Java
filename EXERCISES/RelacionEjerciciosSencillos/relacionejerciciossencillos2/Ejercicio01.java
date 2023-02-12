/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos2;

/**
 *
 * @author amezc
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("RESOLVER ECUACIONES REALES");
        double a = getA();
        double b = funciones.LeerDatosTeclado.enterDouble("Introduce coeficiente b:");
        double c = funciones.LeerDatosTeclado.enterDouble("Introduce coeficiente c:");

        System.out.println(resolverEcuacion(a, b, c));
    }

    public static double getA() {
        double a = funciones.LeerDatosTeclado.enterDouble("Introduce coeficiente a:");

        if (a == 0) {
            throw new AssertionError("a no puede ser cero");
        }

        return a;
    }

    public static String resolverEcuacion(double a, double b, double c) {
        double discriminante= Math.pow(b, 2)-4*a*c;
        String finalMessage="";
        
        if(discriminante<0){
            finalMessage+="No tiene solucion real";
            
        }else if(discriminante==0){
            finalMessage+="x1= "+(-b/(2*a))+"\nx2= "+(-b/(2*a));
            
        }else{
            finalMessage+="x1: "+((-b+Math.sqrt(discriminante))/(2*a))+
                    "\nx2: "+((-b-Math.sqrt(discriminante))/(2*a));
        }
        
        
        return finalMessage;
    }
}
