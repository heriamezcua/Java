/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos2;

/**
 *
 * @author amezc
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int elementos= funciones.LeerDatosTeclado.enterInt("Introduce el numero de elementos de la progresión:");
        int ti= funciones.LeerDatosTeclado.enterInt("Introduce el termino inicial: ");
        int r= funciones.LeerDatosTeclado.enterInt("Introduce el factor de progresión: ");
        
        String finalMessage= "La progresion es:";
        int [] arrayProgresion= progresion(elementos, ti, r);
        for(int i=0; i<arrayProgresion.length; i++){
            finalMessage+= " "+arrayProgresion[i];
        }
        
        System.out.println(finalMessage);
        

    }
    
    public static int[] progresion(int x, int y, int z){
        int [] arrayProgresion= new int[x];
        int ti= y;
        int r= z;
        int progresion= ti;
        
        
        int container=0;
        while(container!=arrayProgresion.length){
            arrayProgresion[container]= progresion;
            progresion*=r;
            container++;
        }
        
        return arrayProgresion;
    }
}
