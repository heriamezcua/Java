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
public class Ejercicio10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        String num= ""+funciones.LeerDatosTeclado.enterDouble("Enter a double number:");
        Scanner input = new Scanner(num);
        input.useDelimiter("\\.");
        int digits=0;

        int intPart= Integer.parseInt(input.next());
        int decPart= Integer.parseInt(input.next());

        while(intPart!=0){
            intPart/=10;
            digits++;
        }
        
        while(decPart!=0){
            decPart/=10;
            digits++;
        }
        
        System.out.println(num+" tiene "+digits+" digitos");

    }

}
