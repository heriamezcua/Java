/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        double callTime= getCallTime();
        int importe= getImporte(callTime);
        
        System.out.println("Coste de llamada: "+importe+" centimos");
    }
    
    
    public static double getCallTime(){
        double callTime= funciones.LeerDatosTeclado.enterDouble("Introduce el tiempo de llamada (en minutos):");
        
        if(callTime<=0){
            throw new AssertionError("El tiempo de llamada no puede ser negativo");
        }
        
        return callTime;
    }
    
    public static int getImporte(double x){
        double callTime=Math.ceil(x);
        int importe=0;
        
        if(callTime<=1){
            importe+=15;
        }else if(callTime<=2){
            importe+=30;
        }else if(callTime<=3){
            importe+=45;
        }else{
            importe+=45;
            importe+=((callTime-3)*7);
        }
        
        return importe;
    }
}
