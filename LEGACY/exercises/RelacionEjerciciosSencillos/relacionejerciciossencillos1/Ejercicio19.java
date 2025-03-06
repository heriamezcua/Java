/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio19 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int number= funciones.LeerDatosTeclado.enterInt("Introduce un numero entero:");
        boolean isPrime= isPrimeNumber(number);
        
        if(isPrime){
            System.out.println("El numero "+number+" es primo");
        }else{
            System.out.println("El numero "+number+" no es primo");
        }
        
    }
    
    public static boolean isPrimeNumber(int number){
        boolean isPrime= false;
        int divisibles=0;
        for(int i=1; i<=number; i++){
            if(number%i==0){
                divisibles++;
            }
        }
        
        if(divisibles==2){
            isPrime=true;
        }
        
        return isPrime;
    }
    
}
