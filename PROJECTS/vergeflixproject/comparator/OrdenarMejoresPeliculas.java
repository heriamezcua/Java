/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.comparator;

import vergeflix.*;
import java.util.Comparator;

/**
 * Nos permite ordenar los elementos de un ArrayList de peliculas. A través de
 * las peliculas con mayor puntuacion.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class OrdenarMejoresPeliculas implements Comparator<Pelicula> {

    /**
     * Establece una ordenación no natural para una pelicula la cual será mayor si su
     * puntuacion es mayor que la que tiene tiene con la que se está comparando.
     *
     * @param o1 una pelicula
     * @param o2 la pelicula con la que se compara la primera
     * @return -1, 0, 1 dependiendo de si es mayor, igual o menor
     * respectivamente.
     */
    @Override
    public int compare(Pelicula o1, Pelicula o2) {
        int result = 0;

        if (o1.calcularPuntuacion() > o2.calcularPuntuacion()) {
            result = -1;
        } else if (o1.calcularPuntuacion() == o2.calcularPuntuacion()) {
            result = 0;
        } else {
            result = 1;
        }

        return result;
    }

}
