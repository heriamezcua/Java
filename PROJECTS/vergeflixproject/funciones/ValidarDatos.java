/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.funciones;

import java.time.LocalDate;
import java.util.regex.Pattern;

/**
 * Clase con diferentes metodos que sirven para validar parámetros.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class ValidarDatos {

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
     * Método que nos sirve para validar si la calificación por edad de ese
     * Media (pelicula o serie) es válido.
     *
     * @param calificacionEdad la calificacion por edad de ese Media
     * @return true si la calificación por edad de ese Media es mayor o igual a
     * 0 y menor o igual que 18
     */
    public static boolean validarCalificacionEdad(int calificacionEdad) {
        return (calificacionEdad >= 0 && calificacionEdad <= 18);
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
     * Comprueba si la duración de la película es válida.
     *
     * @param duracion la duración de la película
     * @return true si la duración es un entero mayor que 60 y menor o igual que
     * 240
     */
    public static boolean validarDuracion(int duracion) {
        return (duracion > 60 && duracion <= 240);
    }

    /**
     * Comprueba si la emisión de un capítulo dentro de una temporada es válida.
     * Será valida la emisión del capítulo si la fecha de estreno de la
     * temporada es anterior o igual a la del capítulo.
     *
     * @param fechaTemporada la fecha de estreno de la temporada
     * @param fechaCapitulo la fecha de emisión del capítulo
     * @return true si la emisión es válida
     */
    public static boolean validarEmision(LocalDate fechaTemporada, LocalDate fechaCapitulo) {
        return (fechaTemporada.isBefore(fechaCapitulo) || fechaTemporada.isEqual(fechaCapitulo));
    }

    /**
     * Comprueba si un índice es válido dentro de una lista. Será válido si es
     * mayor o igual a cero y menor que la longitud de la lista.
     *
     * @param indice el índice que queremos comprobar
     * @param longitud la longitud de la lista
     * @return true si el índice es válido
     */
    public static boolean validarIndice(int indice, int longitud) {
        return (indice >= 0 && indice < longitud);
    }

    /**
     * Comprueba si el estreno de una temporada dentro de una serie es válido.
     * Es válido si se estrenan al mismo tiempo o si la fecha de estreno de la
     * temporada es posterior a la de la serie.
     *
     * @param fechaSerie la fecha de estreno de la serie
     * @param fechaTemporada la fecha de estreno de la temporada
     * @return true si la fecha de estreno de la temporada dentro de la serie es
     * válida
     */
    public static boolean validarEstreno(LocalDate fechaSerie, LocalDate fechaTemporada) {
        return (fechaSerie.isBefore(fechaTemporada) || fechaSerie.isEqual(fechaTemporada));
    }
    

    /**
     * Comprueba si dos temporadas se estrenan al mismo tiempo. Dos temporadas
     * se estrenan al mismo tiempo si su fecha de estreno es igual en mes y año.
     *
     * @param fecha1 la fecha de estreno de una temporada
     * @param fecha2 la fecha de estreno de otra temporada
     * @return true si se estrenan al mismo tiempo
     */
    public static boolean mismoEstreno(LocalDate fecha1, LocalDate fecha2) {
        return (fecha1.getMonthValue() == fecha2.getMonthValue() && fecha1.getYear() == fecha2.getYear());
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

    /**
     * Comprueba que la fecha introducida por el usuario se encuentra en formato
     * dd-MM-YYYY.
     *
     * @param s el string introducido por el usuario que simula una fecha y que
     * queremos comprobar
     * @return true si la fecha tiene ese formato
     */
    public static boolean validarFecha(String s) {
        return Pattern.matches("^(?:3[01]|[12][0-9]|0?[1-9])([-])(0?[1-9]|1[0-2])\\1\\d{4}$", s);
    }
}
