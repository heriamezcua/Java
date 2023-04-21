/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparator;

import vergeflix.*;
import java.util.Comparator;

/**
 * Nos permite ordenar los elementos de un ArrayList de Media. A través de los
 * elementos (series y peliculas) con menor calificacion de edad.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class OrdenarMediaEdad implements Comparator<Media> {

    /**
     * Establece una ordenación no natural para un objeto tipo Media el cual
     * será mayor si su calificacion de edad es menor que la que tiene tiene con la que se
     * está comparando.
     *
     * @param o1 una serie
     * @param o2 la serie con la que se compara la primera
     * @return -1, 0, 1 dependiendo de si es mayor, igual o menor
     * respectivamente.
     */
    @Override
    public int compare(Media o1, Media o2) {
        int result = 0;

        if (o1.getCalificacionEdad() > o2.getCalificacionEdad()) {
            result = 1;
        } else if (o1.getCalificacionEdad() == o2.getCalificacionEdad()) {
            result = 0;
        } else {
            result = -1;
        }

        return result;
    }

}
