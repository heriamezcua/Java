/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos2;

import java.util.Arrays;

/**
 * Clase que nos permite crear un album de canciones.
 *
 * @author Hoxuro
 * @version 1.0
 */
public class Album {

    private Cancion[] canciones;
    private int contador;

    /**
     * Metodo constructor por defecto que crea un album con 0 canciones.
     */
    public Album() {
        this.canciones = new Cancion[0];
    }

    /**
     * Metodo que devuelve la cantidad de canciones que hay en un album.
     *
     * @return la cantidad de canciones de un album
     */
    public int numeroCanciones() {
        return (this.canciones.length);
    }

    /**
     * Metodo que devuelve la cancion de esa posicion itroducida.
     *
     * @param numeroCancion la posicion de la cancion en el album
     * @return la cancion en esa posicion
     */
    public Cancion dameCancion(int numeroCancion) {
        return this.canciones[numeroCancion - 1];
    }

    /**
     * Metodo que agrega una cancion al final del album.
     *
     * @param cancion la cancion a introducir al final
     * @return un string indicando que se ha agregado la cancion
     */
    public String agrega(Cancion cancion) {
        Cancion[] albumExtendido = Arrays.copyOf(this.canciones, this.canciones.length + 1);
        Arrays.fill(albumExtendido, (albumExtendido.length - 1), (albumExtendido.length), cancion);
        this.canciones = albumExtendido;
        return "Se ha agregado la cancion " + cancion;
    }

    /**
     * Metodo que elimina la cancion de la posicion introducida. Para futuras
     * mejoras podemos hacer que el tamanio del array de canciones disminuya al
     * eliminar la cancion.
     *
     * @param numeroCancion la posicion de la cancion a eliminar.
     * @return un string indicando que se ha eliminado la cancion.
     */
    public String elimina(int numeroCancion) {
        this.canciones[numeroCancion - 1] = new Cancion();
        return "Cancion " + numeroCancion + " eliminada";
    }

    public String grabaCancion(int numeroCancion, Cancion cancion) {
        this.canciones[numeroCancion - 1] = cancion;
        return "Se ha grabado la cancion";
    }

}
/*MAIN
        Cancion c1 = new Cancion("Titi me pregunto", "Bad Bunny");
        Cancion c2 = new Cancion("Aguacero", "Bad Bunny");
        Cancion c3 = new Cancion("Me porto bonito", "Bad Bunny");
        Cancion c4 = new Cancion("Ojitos lindos", "Bad Bunny");
        Cancion c5 = new Cancion("Party", "Bad Bunny");

        System.out.println("Cancion 1: " + c1);

        System.out.println(c1.getTitulo());
        System.out.println(c1.getAutor());

        Album unVeranoSinTi = new Album();

        unVeranoSinTi.agrega(c1);
        unVeranoSinTi.agrega(c2);
        unVeranoSinTi.agrega(c3);
        unVeranoSinTi.agrega(c4);
        unVeranoSinTi.agrega(c5);

        for (int i = 1; i <= unVeranoSinTi.numeroCanciones(); i++) {
            System.out.println("Cancion " + i + " " + unVeranoSinTi.dameCancion(i));
        }

        System.out.println("Total canciones: " +unVeranoSinTi.numeroCanciones());
*/
