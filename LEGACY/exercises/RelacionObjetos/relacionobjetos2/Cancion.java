/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos2;

/**
 *
 * @author amezc
 */
public class Cancion {

    private String titulo, autor;

    /**
     * Metodo constructor por defecto que inicializa todos los atributos de
     * cancion a cadenas vacías.
     *
     */
    public Cancion() {
        this.titulo = "";
        this.autor = "";
    }

    /**
     * Metodo constructor por defecto que establece el titulo y el autor que el
     * usuario introduzca.
     *
     * @param titulo el titulo de la cancion
     * @param autor el autor de la cancion
     */
    public Cancion(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    /**
     * Metodo getter que devuelve el titulo de la cancion.
     *
     * @return El titulo de la cancion
     */
    public String getTitulo() {
        return this.titulo;
    }

    /**
     * Metodo getter que devuelve el autor de la cancion.
     *
     * @return El autor de la cancion
     */
    public String getAutor() {
        return this.autor;
    }

    /**
     * Metodo setter que establece el titulo de la cancion.
     *
     * @param titulo el titulo de la cancion
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Metodo setter que establece el autor de la cancion.
     *
     * @param autor el autor de la cancion
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Titulo=" + titulo + ", autor=" + autor;
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
