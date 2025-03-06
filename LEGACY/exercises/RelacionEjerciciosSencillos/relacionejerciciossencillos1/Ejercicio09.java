/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;
import java.util.Scanner;

/**
 *
 * @author amezc
 */
public class Ejercicio09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double base=enterBase(), y=1;
        
        int exponente=funciones.LeerDatosTeclado.enterInt("Introduce exponente");
        
        for(int i=0; i<exponente; i++){
            y*=base;
        }
        
        System.out.print(base+" elevado a "+exponente+" es igual a ");
        System.out.printf("%1.3f", y);
        System.out.println("");
    }
    
    public static double enterBase(){
        Scanner input= new Scanner(System.in);
        System.out.println("Introduce la base:");
        if(!input.hasNextDouble()){
            
            do{
                System.out.println("Enter a valid number!");
                input.nextLine();
                
            }while(!input.hasNextDouble());
        }
        
        return Math.abs(input.nextDouble());
    }
    
}
