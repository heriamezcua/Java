/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package vergeflixproject.vergeflix;

/**
 * Interface que nos permite definir el comportamiento a la hora de valorar de
 * las clases que la implementen.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public interface Valorable {

    /**
     * Calcula la puntuacion dependiendo del objeto que la implemente
     * (polimorfismo).
     *
     * @return un entero que representa la puntuacion de ese objeto
     */
    int calcularPuntuacion();

}
