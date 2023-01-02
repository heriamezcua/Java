/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int dia = leerDia();       
        int mes = leerMes();
        int year = leerYear();

        System.out.println(imprimirFecha(dia, mes, year));

    }

    public static String imprimirFecha(int dia, int mes, int year) {
        
        String finalMessage="";

        switch (mes) {
            case 4:
            case 6:
            case 9:
            case 11:
                if (dia > 30) {
                    finalMessage="Fecha incorrecta: " + dia + "-" + mes + "-" + year;
                } else {
                    finalMessage="Fecha correcta: " + dia + "-" + mes + "-" + year;                }
                break;
            case 2:
                if (dia > 28) {
                    finalMessage="Fecha incorrecta: " + dia + "-" + mes + "-" + year;
                } else {
                    finalMessage="Fecha correcta: " + dia + "-" + mes + "-" + year;                }
                break;
            default:
                finalMessage="Fecha correcta: " + dia + "-" + mes + "-" + year;
        }
        
        return finalMessage;
    }

    public static int leerDia() {
        int dia = funciones.LeerDatosTeclado.enterInt("Introduce dia:");

        if (dia <= 0 || dia > 31) {
            throw new AssertionError("Rango de dia incorrecto");
        }

        return dia;
    }

    public static int leerMes() {
        int mes = funciones.LeerDatosTeclado.enterInt("Introduce mes:");

        if (mes <= 0 || mes > 12) {
            throw new AssertionError("Rango de mes incorrecto");
        }

        return mes;
    }

    public static int leerYear() {
        int year = funciones.LeerDatosTeclado.enterInt("Introduce year:");

        if (year < 0) {
            throw new AssertionError("Rango de year incorrecto");
        }

        return year;
    }

}