/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparator;

import vergeflix.*;
import java.util.Comparator;

/**
 * Nos permite ordenar las películas de un ArrayList por temática.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class OrdenarPeliculasTematica implements Comparator<Pelicula> {

    /**
     * Establece una ordenación no natural para una película la cual será mayor
     * si su temática tiene menor valor numerico que la que tiene con la que se
     * está comparando.
     *
     * @param o1 la tematica de la primera pelicula
     * @param o2 la tematica de la segunda pelicula
     * @return -1, 0, 1 dependiendo de si es mayor, igual o menor
     * respectivamente.
     */
    @Override
    public int compare(Pelicula o1, Pelicula o2) {
        if (o1.getCategoria().compareTo(o2.getCategoria()) < 0) {
            return -1;
        } else if (o1.getCategoria().compareTo(o2.getCategoria()) == 0) {
            return 0;
        } else {
            return 1;
        }
    }

}
