/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.comparator;

import vergeflix.*;
import java.util.Comparator;

/**
 * Nos permite ordenar los elementos de un ArrayList de capitulos. A través de
 * los capítulos con mayor número de votos positivos. A igual número de votos
 * positivos, el mayor será el que menos votos negativos tenga.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class OrdenarCapitulosVotos implements Comparator<Capitulo> {

    /**
     * Establece una ordenación no natural para un capítulo el cual será mayor
     * si su numero de votos positivos tiene es mayor que el que tiene tiene con
     * el que se está comparando. A mayor numero de votos positivos el mayor
     * será el que menos votos negativos tenga.
     *
     * @param o1 un capitulo
     * @param o2 el capitulo con el que se compara el primero
     * @return -1, 0, 1 dependiendo de si es mayor, igual o menor
     * respectivamente.
     */
    @Override
    public int compare(Capitulo o1, Capitulo o2) {
        int result;

        if (o1.getVotosPositivos() > o2.getVotosPositivos()) {
            result = -1;
        } else if (o1.getVotosPositivos() == o2.getVotosPositivos()) {
            if (o1.getVotosNegativos() > o2.getVotosNegativos()) {
                result = -1;
            } else if (o1.getVotosNegativos() == o2.getVotosNegativos()) {
                result = 0;
            } else {
                result = 1;
            }
        } else {
            result = 1;
        }

        return result;
    }

}
