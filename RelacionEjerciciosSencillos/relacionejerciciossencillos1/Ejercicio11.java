/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int hour= getHour(), min=getMin(), sec= getSec();
        
        System.out.println(printHour(hour, min, sec));
        System.out.println(printHour1Sec(hour, min, sec));

    }

    public static int getHour() {
        int hora = funciones.LeerDatosTeclado.enterInt("Introduce hora (0 - 23): ");

        if (hora < 0 || hora >= 24) {
            throw new AssertionError("rango de hora incorrecto");
        }

        return hora;
    }

    public static int getMin() {
        int min = funciones.LeerDatosTeclado.enterInt("Introduce minuto (0 - 59):");

        if (min < 0 || min > 60) {
            throw new AssertionError("rango de minuto incorrecto");
        }

        return min;
    }

    public static int getSec() {
        int sec = funciones.LeerDatosTeclado.enterInt("Introduce segundo (0 - 59):");

        if (sec < 0 || sec > 60) {
            throw new AssertionError("rango de segundo incorrecto");
        }
        
        return sec;
    }
    
    public static String printHour1Sec(int hour, int min, int sec){
        String secString="", minString="", hourString="";
        sec++;
        
        if(sec<10){
            secString="0"+sec;
        }else if(sec==60){
            secString="00";
            min++;
        }else{
            secString+=sec;
        }
        
        if(min<10){
            minString="0"+min;
        }else if(min==60){
            minString="00";
            hour++;
        }else{
            minString+=min;
        }
        
        if(hour<10){
            hourString="0"+hour;
        }else if(hour==24){
            hourString="00";
        }else{
            hourString+=hour;
        }
        
        return "1 segundo despues: "+hourString+"/"+minString+"/"+secString;
    }
    
    public static String printHour(int hour, int min, int sec){
        String secString="", minString="", hourString="";
        
        if(sec<10){
            secString="0"+sec;
        }else{
            secString+=sec;
        }
        
        if(min<10){
            minString="0"+min;
        }else{
            minString+=min;
        }
        
        if(hour<10){
            hourString="0"+hour;
        }else{
            hourString+=hour;
        }
        
        return "Hora actual: "+hourString+"/"+minString+"/"+secString;
    }
}
