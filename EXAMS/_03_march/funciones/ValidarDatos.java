/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package _03_march.funciones;

import desarrollozaidin.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Clase con diferentes metodos que sirven para validar parámetros.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class ValidarDatos {

    public static boolean validarSalario(double salario) {
        return (salario >= 1000);
    }

    public static boolean validarAntiguedad(int años) {
        return (años >= 0);
    }

    public static boolean validarLenguaje(String leng) {
        boolean esValido = false;
        if (ValidarDatos.validarTitulo(leng)) {
            for (Lenguajes l : Lenguajes.values()) {
                if (l.lenguaje.equals(ValidarDatos.toTitleCase(leng))) {
                    esValido = true;
                }
            }
        }

        return esValido;
    }

    public static boolean validarPlus(int plus) {
        return (plus > 0);
    }

    //n puede ser cero prorque puede haber trabajadores liberados
    public static boolean validarNProyect(int n) {
        return (n >= 0);
    }

    /**
     * Transforma formato del string introducido en Titlecase. Ejemplo: Texto En
     * Titlecase.
     *
     * @param s el string que queremos que tenga formato Titlecase
     * @return el string en Titlecase
     */
    public static String toTitleCase(String s) {
        Scanner input = new Scanner(s);

        StringBuilder sB = new StringBuilder("");
        do {
            String palabra = input.next();
            sB.append(palabra.substring(0, 1).toUpperCase()).append(palabra.substring(1).toLowerCase()).append(" ");
        } while (input.hasNext());

        return sB.toString().trim();
    }

    /**
     * Método que nos sirve para validar si un nombre de un Media (pelicula o
     * serie) es válido.
     *
     * @param nombre el nombre de ese Media
     * @return true si el nombre de ese Media no está vacío o compuesto
     * solamente de espacios en blanco
     */
    public static boolean validarTitulo(String nombre) {
        return (!Pattern.matches("^\\s*$", nombre));
    }


    /**
     * Comprueba si el nombre de una persona es válido. Será válido si está
     * compuesto de carácteres alfanuméricos con una longitud minima de 1
     * caracter y una máxima de 40 y no está compuesto de carácteres en blanco.
     *
     * @param nombre el nombre que queremos validar
     * @return true si el nombre es valido
     */
    public static boolean validarNombrePersona(String nombre) {
        return (!(Pattern.matches("^\\s+{1,40}$", nombre)
                || !Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{1,40}", nombre)));
    }



    /**
     * Comprueba que el numero introducido por el usuario se encuentra dentro
     * del rango requerido.
     *
     * @param inicio el numero donde empieza el rango (incluido)
     * @param fin el numero donde termina el rango (incluido)
     * @param intro el numero introducido por el usuario que queremos validar
     * @param mensajeError el mensaje que queremos mostrar hasta que no
     * introduzca un numero valido
     * @return true si el numero se encuentra dentro del rango requerido
     */
    public static int calcNumRango(int inicio, int fin, int intro, String mensajeError) {
        do {
            if (!(intro >= inicio && intro <= fin)) {
                System.err.println(mensajeError);
                intro = LeerDatosTeclado.enterInt("");
            }
        } while (!(intro >= inicio && intro <= fin));
        return intro;
    }

}
