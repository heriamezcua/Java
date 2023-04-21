/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparator;

import vergeflix.*;
import java.util.Comparator;

/**
 * Nos permite ordenar los elementos de un ArrayList de series. A través de las
 * series con mayor puntuacion.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class OrdenarMejoresSeries implements Comparator<Serie> {

    /**
     * Establece una ordenación no natural para una serie la cual será mayor si su
     * puntuacion es mayor que la que tiene tiene con la que se está comparando.
     *
     * @param o1 una serie
     * @param o2 la serie con la que se compara la primera
     * @return -1, 0, 1 dependiendo de si es mayor, igual o menor
     * respectivamente.
     */
    @Override
    public int compare(Serie o1, Serie o2) {
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
