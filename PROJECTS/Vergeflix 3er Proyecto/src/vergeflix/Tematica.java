/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package vergeflix;

/**
 * Enum con distintas temáticas para series y películas.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public enum Tematica {
    COMEDIA("Comedia"),
    DRAMA("Drama"),
    TERROR("Terror"),
    SUSPENSE("Suspense"),
    CIENCIA_FICCION("Ciencia Ficción"),
    FANTASIA("Fantasía");

    String tematica;

    Tematica(String tematica) {
        this.tematica = tematica;
    }
}
