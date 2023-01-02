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
public class Ejercicio08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int year= enterYear();
        boolean isLeapYear = false;

        if (year % 4 == 0) {
            
            if(year>=100){
                String yearString= String.valueOf(year);
                String lastTwoNum = yearString.substring(Math.max(yearString.length() - 2, 0));
                
                if(!lastTwoNum.equals("99")){
                    isLeapYear=true;
                }
            }
            
            isLeapYear=true;

        } else if (year % 100 == 0) {
            if (year % 400 == 0) {
                isLeapYear = true;
            }
        }
        
        System.out.println(leapYearMessage(isLeapYear, year));
    }

    public static int enterYear() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year");

        if (!input.hasNextInt())
        {

            do {
                System.out.println("Enter a valid year!");
                input.nextLine();
            } while (!input.hasNextInt());

        }

        return Math.abs(input.nextInt());
    }
    
    //
    public static String leapYearMessage(boolean x, int y){
        boolean leapYear= x;
        int year= y;
        String finalMessage;
        
        if(!leapYear){
           finalMessage= year+ " is not a leap year";
        }else{
           finalMessage= year+ " is a leap year";
        }

        return finalMessage;
    }
}
