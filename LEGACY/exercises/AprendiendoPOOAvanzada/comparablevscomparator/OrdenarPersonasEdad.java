/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparablevscomparator;

import java.util.Comparator;

/**
 * Ordena una lista de personas a partir de la edad de manera que las que tienen
 * edad par van antes que las que tienen edades impares.
 *
 * @author Hoxuro
 */
public class OrdenarPersonasEdad implements Comparator<Persona> {

    @Override
    public int compare(Persona o1, Persona o2) {
        if (o1.getEdad() % 2 == 0 && o2.getEdad() % 2 == 0 || o1.getEdad() % 2 != 0 && o2.getEdad() % 2 != 0) {
            return 0;
        } else if (o1.getEdad() % 2 != 0 && o2.getEdad() % 2 == 0) {
            return 1;
        } else {
            return -1;
        }
    }

}
