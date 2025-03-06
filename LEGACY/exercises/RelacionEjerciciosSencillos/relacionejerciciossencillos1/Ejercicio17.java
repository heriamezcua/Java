/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int AlumSus= getAlumSus();
        int AlumApr= getAlumApr();
        int AlumNot= getAlumNot();
        int AlumSob= getAlumSob();
        int numAlum= AlumSus+AlumApr+AlumNot+AlumSob;
        int totalApr= AlumApr+AlumNot+AlumSob;
        
        System.out.println("Total aprobados: "+getPorTotalApr(numAlum, totalApr)+"%");
        System.out.println("Porcentaje de suspensos: "+getPorSus(numAlum, AlumSus)+"%");
        System.out.println("Porcentaje de aprobados: "+getPorApr(numAlum, AlumApr)+"%");
        System.out.println("Porcentaje de notables: "+getPorNot(numAlum, AlumNot)+"%");
        System.out.println("Porcentaje de sobresalientes: "+getPorSob(numAlum, AlumSob)+"%");
        
    }
    
    public static int getAlumSus(){
        int numAlumF= funciones.LeerDatosTeclado.enterInt("Introduce cantidad de alumnos suspensos: ");
        
        if(numAlumF<0){
            throw new AssertionError("Numero de alumnos no puede ser negativo");
            
        }
        
        return numAlumF;
    }
    
    public static int getAlumApr(){
        int numAlumApr= funciones.LeerDatosTeclado.enterInt("Introduce cantidad de alumnos aprobados: ");
        
        if(numAlumApr<0){
            throw new AssertionError("Numero de alumnos no puede ser negativo");
            
        }
        
        return numAlumApr;
    }
    
    public static int getAlumNot(){
        int numAlumNot= funciones.LeerDatosTeclado.enterInt("Introduce cantidad de alumnos notables: ");
        
        if(numAlumNot<0){
            throw new AssertionError("Numero de alumnos no puede ser negativo");
            
        }
        
        return numAlumNot;
    }
    
    public static int getAlumSob(){
        int numAlumSob= funciones.LeerDatosTeclado.enterInt("Introduce cantidad de alumnos sobresalientes: ");
        
        if(numAlumSob<0){
            throw new AssertionError("Numero de alumnos no puede ser negativo");
            
        }
        
        return numAlumSob;
    }
    
    public static int getPorTotalApr(int x, int y){
        int numAlum=x;
        int numAlumApr= y;
        int porcApr= (numAlumApr*100)/numAlum;
        
        return porcApr;
    }
    
    public static int getPorSus(int x, int y){
        int numAlum=x;
        int numAlumSus= y;
        int porSus= (numAlumSus*100)/numAlum;
        
        return porSus;
    }
    
    public static int getPorApr(int x, int y){
        int numAlum=x;
        int numAlumApr= y;
        int porApr= (numAlumApr*100)/numAlum;
        
        return porApr;
    }
    
    public static int getPorNot(int x, int y){
        int numAlum=x;
        int numAlumNot= y;
        int porNot= (numAlumNot*100)/numAlum;
        
        return porNot;
    }
    
    public static int getPorSob(int x, int y){
        int numAlum=x;
        int numAlumSob= y;
        int porSob= (numAlumSob*100)/numAlum;
        
        return porSob;
    }
    
}
