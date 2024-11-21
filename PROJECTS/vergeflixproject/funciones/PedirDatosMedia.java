/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.funciones;

import vergeflix.*;
import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * Clase con diferentes metodos que facilitan la peticion de los diferentes
 * datos necesarios para construir un objeto tipo Media.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class PedirDatosMedia {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\033[0;31m";
    private static final String BLUE = "\u001B[34m";

    /**
     * Pide el titulo de una pelicula o serie hasta que sea válido. Es válido
     * cuando no está vació o compuesto de espacios en blanco.
     *
     * @param nombreMedia el nombre de ese objeto Media concreto
     * @return el titulo de esa serie o pelicula
     */
    public static String pedirTitulo(String nombreMedia) {
        //hago que introduzca el nombre de la pelicula hasta que no esté vacío
        if (nombreMedia.equalsIgnoreCase("capítulo")) {
            System.out.println(new StringBuilder("Introduzca el nombre del ").append(nombreMedia).append(":"));

        } else {
            System.out.println(new StringBuilder("Introduzca el nombre de la ").append(nombreMedia).append(":"));
        }

        StringBuilder nombre = new StringBuilder();
        do {
            nombre.setLength(0);
            nombre.append(LeerDatosTeclado.enterStringNextLine(""));
            if (!ValidarDatos.validarTitulo(nombre.toString())) {
                System.out.println("\033[0;31mIntroduzca el nombre correctamente\u001B[0m");
            }
        } while (!ValidarDatos.validarTitulo(nombre.toString()));
        nombre = new StringBuilder(nombre.toString().trim().replaceAll("\\s+{2,}", " "));

        return nombre.toString();
    }

    /**
     * Pide la calificacion por edad hasta que sea válida. Es valida cuando es
     * mayor o igual a 0 y menor o igual a 18.
     *
     * @return la calificacion por edad
     */
    public static int pedirCalificacionEdad() {
        return ValidarDatos.calcNumRango(0, 18, LeerDatosTeclado.enterInt("Introduzca la calificación de edad (de 0 a 18):"), "Seleccione correctamente (de 0 a 18):");
    }

    /**
     * Pide la fecha de incorporacion al catalogo de esa pelicula o serie. Es
     * valida si introduce para dia de 1 a 31, para mes de 1 a 12 y para año
     * maximo 31-12-999999999 y minimo 01-01-(-999999999)
     *
     * @param message el nombre de esa fecha en concreto
     * @return una fecha válida
     */
    public static LocalDate pedirFecha(String message) {
        System.out.println(message);
        StringBuilder fechaIncStr = new StringBuilder();
        boolean fechaValida = false;
        int dia = 0, mes = 0, año = 0;
        do {
            do {
                fechaIncStr.setLength(0);
                fechaIncStr.append(LeerDatosTeclado.enterStringNextLine(""));
                if (!ValidarDatos.validarFecha(fechaIncStr.toString())) {
                    System.err.println("Formato de fecha incorrecto, introduzca de nuevo");
                }
            } while (!ValidarDatos.validarFecha(fechaIncStr.toString()));
            dia = Integer.parseInt(fechaIncStr.toString().split("-")[0]);
            mes = Integer.parseInt(fechaIncStr.toString().split("-")[1]);
            año = Integer.parseInt(fechaIncStr.toString().split("-")[2]);

            //compruebo los meses normales
            switch (mes) {
                case 4, 6, 9, 11 -> {
                    if (dia > 30) {
                        fechaValida = !(dia == 31);
                    }
                }
            }

            //si es febrero compruebo que sea valida su fecha
            if (!fechaValida && añoBisiesto(año) && mes == 2) {
                fechaValida = (mes == 2 && dia <= 29);
            } else if (mes == 2) {
                fechaValida = (mes == 2 && dia <= 28);
            } else {
                fechaValida = true;
            }

            if (!fechaValida) {
                System.err.println("La fecha introducida no es correcta (tenga en cuenta años bisiestos y meses de 30 o 31 días)");
            }
        } while (!fechaValida);

        return LocalDate.of(año, mes, dia);
    }

    /**
     * Comprueba si un año es bisiesto. Un año es bisiesto en el calendario
     * Gregoriano, si es divisible entre 4 y no divisible entre 100, y también
     * si es divisible entre 400.
     *
     * @param año el año que queremos comprobar si es bisiesto
     * @return true si es bisiesto
     */
    private static boolean añoBisiesto(int año) {
        GregorianCalendar calendar = new GregorianCalendar();
        return (calendar.isLeapYear(año));
    }

    /**
     * Pide la disponibilidad de la pelicula hasta que sea valida. Sera valida
     * si introduce 1 o 2.
     *
     * @return true si el usuario ha escogido 1, false si ha escogido 2
     */
    public static boolean pedirDisponibilidad() {
        return (ValidarDatos.calcNumRango(1, 2, LeerDatosTeclado.enterInt("Introduzca 1 si está disponible, 2 si no lo está"), "Seleccione correctamente (1 o 2):") == 1);
    }

    /**
     * Pide el nombre de una persona hasta que sea valido. Será valido si
     * introduce unicamente caracteres alfanumericos, ñ o tildes.
     *
     * @param pedido el nombre de lo que queremos pedir (director, actor,
     * bombero...)
     * @return el nombre de esa persona
     */
    public static String pedirNombre(String pedido) {
        System.out.println(new StringBuilder("Introduzca el nombre del ").append(pedido).append(":"));
        StringBuilder nombre = new StringBuilder();
        do {
            nombre.setLength(0);
            nombre.append(LeerDatosTeclado.enterStringNextLine(""));
            if (!ValidarDatos.validarNombrePersona(nombre.toString())) {
                System.err.println("Introduzca un nombre con carácteres alfanuméricos");
            }
        } while (!ValidarDatos.validarNombrePersona(nombre.toString()));

        return nombre.toString().trim().replaceAll("\\s+{2,}", " ");
    }

    /**
     * Pide la duracion de la pelicula en minutos hasta que sea valida. Será
     * valida si introduce un valor de mayor que 60 y menor o igual a 240.
     *
     * @return la duracion de la pelicula
     */
    public static int pedirDuracion() {
        //pido la duración de la pelicula
        System.out.println("Introduzca la nueva duración de la película entre 61 y 240 minutos:");
        int duracion = 0;
        do {
            duracion = LeerDatosTeclado.enterInt("");
            if (!ValidarDatos.validarDuracion(duracion)) {
                System.err.println("Introduzca una duración válida (61 - 240):");
            }
        } while (!ValidarDatos.validarDuracion(duracion));
        return duracion;
    }

    /**
     * Pide la categoria temática de la pelicula hasta que sea valida. Sera
     * valida si introduce un numero del 1 al 6 correspondiente al numero de
     * categorias.
     *
     * @return la categoria tematica de la pelicula
     */
    public static Tematica pedirCategoria() {
        //pido la temática de la pelicula
        System.out.println("""
                           Seleccione entre las tem\u00e1ticas disponibles:
                           1. Comedia
                           2. Drama
                           3. Terror
                           4. Suspense
                           5. Ciencia Ficci\u00f3n
                           6. Fantas\u00eda""");

        int elegirCategoria = ValidarDatos.calcNumRango(1, 6, LeerDatosTeclado.enterInt(""), "Por favor, seleccione entre las temáticas disponibles") - 1;
        return Tematica.values()[elegirCategoria];
    }

}
