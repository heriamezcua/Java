/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflix;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import funciones.ValidarDatos;

/**
 * Permite crear Peliculas para poder realizar distintas funciones con ellas.
 * Hereda de la clase Media.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class Pelicula extends Media {

    private String director, actorPrincipal;
    private int duracion;
    private Tematica categoria;
    private ArrayList<Integer> votos;

    /**
     * Constructor que permite instanciar un objeto de la clase Pelicula.
     *
     * @param nombre el nombre de la película
     * @param calificacionEdad la calificación por edad que tiene la película
     * @param fechaIncorporacion la fecha de incorporación al catálogo de la
     * película
     * @param estaDisponible la disponibilidad en el catálogo de la película
     * @param director el director de la película
     * @param actorPrincipal el actor principal de la película
     * @param duracion la duración de la pelicula
     * @param categoria la categoria de temática que tiene la película
     * @throws IllegalArgumentException si el nombre del director no es una
     * cadena de caracteres alfanuméricos que pueden tener tilde o ñ
     * @throws IllegalArgumentException si el nombre del actor principal no es
     * una cadena de caracteres alfanuméricos que pueden tener tilde o ñ
     * @throws IllegalArgumentException si la duración de la película es menor o
     * igual que 60 o mayor a 240 minutos (4 horas)
     */
    public Pelicula(String nombre, int calificacionEdad, LocalDate fechaIncorporacion, boolean estaDisponible,
            String director, String actorPrincipal, int duracion, Tematica categoria) {

        super(nombre, calificacionEdad, fechaIncorporacion, estaDisponible);

        if (!ValidarDatos.validarNombrePersona(director)) {
            throw new IllegalArgumentException("El nombre del director no cumple con los requisitos.");
        }
        if (!ValidarDatos.validarNombrePersona(actorPrincipal)) {
            throw new IllegalArgumentException("El nombre del actor principal no cumple con los requisitos.");
        }
        if (!ValidarDatos.validarDuracion(duracion)) {
            throw new IllegalArgumentException("La duración de la pelicula no cumple con los requisitos.");
        }

        //quito los espacios en blanco del inicio y final y los sobrantes entre palabras de los nombres
        this.director = director.trim().replaceAll("\\s+{2,}", " ");
        this.actorPrincipal = actorPrincipal.trim().replaceAll("\\s+{2,}", " ");
        this.duracion = duracion;
        this.categoria = categoria;
        this.votos = new ArrayList<>();

    }

    /**
     * Constructor copia que nos permite crear películas con el mismo estado que
     * la que se introduce por parámetro.
     *
     * @param p la película cuyo estado vamos a copiar
     */
    public Pelicula(Pelicula p) {
        this(p.getNombre(), p.getCalificacionEdad(), p.getFechaIncorporacionAlCatalogo(), p.getEstaDisponible(),
                p.director, p.actorPrincipal, p.duracion, p.categoria);

        //copio los votos de la lista de la pelicula, a la lista de la copia de la película
        //y no su referencia
        for (int i = 0; i < p.votos.size(); i++) {
            this.votos.add(p.votos.get(i));
        }
    }

    /**
     * Devuelve el nombre del director de la película.
     *
     * @return el nombre del director de la película
     */
    public String getDirector() {
        return director;
    }

    /**
     * Establece el nombre del director de la película si es válido. Un nombre
     * es válido si está compuesto de carácteres alfanuméricos con una longitud
     * minima de 1 caracter y una máxima de 40 y no está compuesto de carácteres
     * en blanco.
     *
     * @param director el nombre del director de la película que queremos
     * establecer
     */
    public void setDirector(String director) {
        if (ValidarDatos.validarNombrePersona(director)) {
            this.director = director;
        }
    }

    /**
     * Devuelve el nombre del actor principal de la película.
     *
     * @return el nombre del actor principal de la pelicula
     */
    public String getActorPrincipal() {
        return actorPrincipal;
    }

    /**
     * Establece el nombre del actor principal de la pelicula si es válido. Un
     * nombre es válido si está compuesto de carácteres alfanuméricos con una
     * longitud minima de 1 caracter y una máxima de 40 y no está compuesto de
     * carácteres en blanco.
     *
     * @param actorPrincipal el nombre del actor principal que queremos
     * establecer
     */
    public void setActorPrincipal(String actorPrincipal) {
        if (ValidarDatos.validarNombrePersona(actorPrincipal)) {
            this.actorPrincipal = actorPrincipal;
        }
    }

    /**
     * Devuelve la duración de la película en minutos.
     *
     * @return la duración de la pelicula en minutos
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Establece la duracion de la pelicula si la duración es un entero mayor
     * que 60 y menor o igual que 240.
     *
     * @param duracion la duracion de la película en minutos a establecer
     */
    public void setDuracion(int duracion) {
        if (ValidarDatos.validarDuracion(duracion)) {
            this.duracion = duracion;
        }
    }

    /**
     * Devuelve la categoría de la temática de la película.
     *
     * @return la categoria de la tematica de la pelicula
     */
    public Tematica getCategoria() {
        return categoria;
    }

    /**
     * Establece la categoría de la temática de la película.
     *
     * @param categoria la categoría de la temática de la película a establecer
     */
    public void setCategoria(Tematica categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve una representación en formato String de esta película.
     *
     * @return una representación en formato String de esta película.
     */
    @Override
    public String toString() {
        StringBuilder finalMessage = new StringBuilder(super.toString()).append("Director= ").append(director).append(", Actor principal= ");
        finalMessage.append(actorPrincipal).append(", Duración= ").append((duracion / 60)).append(" hora(s) y ");
        finalMessage.append(duracion % 60).append(" minuto(s)\nCategoría= ").append(categoria.tematica).append(", Puntuación= ").append(calcularPuntuacion()).append("\nVotos= ");
        int contador = 1;
        for (int voto : votos) {
            if (contador % 30 == 0) {
                finalMessage.append(voto).append("\n");
            }
            finalMessage.append(voto).append(" | ");
            contador++;
        }
        return finalMessage.toString();
    }

    /**
     * Compara dos películas. Son iguales si el estado de sus atributos
     * director, actorPrincipal, duración y categoría.
     *
     * @param obj el objeto Pelicula con el que se comparará
     * @return true si esas dos películas son iguales
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pelicula other = (Pelicula) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        if (!Objects.equals(this.actorPrincipal, other.actorPrincipal)) {
            return false;
        }
        return this.categoria == other.categoria;
    }

    /**
     * Añade un voto a la lista de votos si el valor del voto es mayor o igual a
     * 0 y menor o igual a 10.
     *
     * @param voto el voto que queremos añadir a la lista de votos de la
     * película
     * @return true si se ha añadido
     */
    public boolean votar(int voto) {
        if (voto >= 0 && voto <= 10) {
            this.votos.add(voto);
        }
        return (voto >= 0 && voto <= 10);
    }

        /**
     * Calcula la puntuación de la Pelicula. La puntuación en este caso se calcula
     * dividiendo la sumatoria de las puntuaciones de la serie entre el número
     * de temporadas. La puntuación varía entre 0 y 10.
     *
     * @return la puntuacion de la serie
     */
    @Override
    public int calcularPuntuacion() {
        int sumPuntuaciones = 0;

        for (int voto : votos) {
            sumPuntuaciones += voto;
        }

        return (int) ((double) sumPuntuaciones / votos.size());
    }

}
