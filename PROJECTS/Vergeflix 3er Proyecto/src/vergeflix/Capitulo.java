/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflix;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import funciones.ValidarDatos;

/**
 * Clase que nos permite crear capitulos de series con los que podremos realizar
 * distintas acciones.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class Capitulo implements Valorable {

    private String titulo;
    private LocalDate fechaEmision;
    private int votosPositivos, votosNegativos;
    private static final DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Constructor que permite instanciar un objeto de la clase Capitulo.
     *
     * @param titulo el título del capítulo
     * @param fechaEmision la fecha de emisión del capítulo
     * @throws IllegalArgumentException si el nombre del capitulo esta vacio o
     * compuesto de espacios en blanco
     */
    public Capitulo(String titulo, LocalDate fechaEmision) {
        if (!ValidarDatos.validarTitulo(titulo)) {
            throw new IllegalArgumentException("El título del capítulo no cumple con los requisitos.");
        }

        //quito los espacios en blanco del inicio y final y los sobrantes entre palabras
        this.titulo = titulo.trim().replaceAll("\\s+{2,}", " ");
        this.fechaEmision = LocalDate.of(fechaEmision.getYear(), fechaEmision.getMonthValue(), fechaEmision.getDayOfMonth());
    }

    /**
     * Constructor copia que crea un capítulo cuyo estado es el del capítulo
     * introducido por parámetro.
     *
     * @param c el capítulo cuyo estado queremos copiar
     */
    public Capitulo(Capitulo c) {
        this(c.titulo, c.fechaEmision);
        this.votosPositivos = c.votosPositivos;
        this.votosNegativos = c.votosNegativos;
    }

    /**
     * Devuelve el título del capítulo.
     *
     * @return el título del capitulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Establece el título del capítulo siempre que no esté vacío o compuesto
     * únicamente de espacios en blanco.
     *
     * @param titulo el título del capítulo que queremos establecer
     */
    public void setTitulo(String titulo) {
        if (ValidarDatos.validarTitulo(titulo)) {
            this.titulo = titulo;
        }
    }

    /**
     * Devuelve una copia de la fecha de emisión del capítulo.
     *
     * @return una copia de la fecha de emisión del capítulo
     */
    public LocalDate getFechaEmision() {
        return LocalDate.of(fechaEmision.getYear(), fechaEmision.getMonthValue(), fechaEmision.getDayOfMonth());
    }

    /**
     * Establece la fecha de emisión del capítulo.
     *
     * @param fechaEmision la fecha que queremos establecer para la emisión del
     * capítulo.
     */
    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = LocalDate.of(fechaEmision.getYear(), fechaEmision.getMonthValue(), fechaEmision.getDayOfMonth());
    }

    /**
     * Devuelve el total de votos positivos que tiene el el capítulo.
     *
     * @return el total de votos positivos que tiene el capítulo
     */
    public int getVotosPositivos() {
        return votosPositivos;
    }

    /**
     * Devuelve la cantidad de votos negativos que tiene el capítulo.
     *
     * @return la cantidad de votos negativos que tiene el capítulo
     */
    public int getVotosNegativos() {
        return votosNegativos;
    }

    /**
     * Devuelve una representación en formato String de este capítulo.
     *
     * @return una representación en formato String de este capítulo.
     */
    @Override
    public String toString() {
        StringBuilder finalMessage = new StringBuilder("Título= ").append(titulo).append(", Fecha de emisión= ");
        finalMessage.append(fechaEmision.format(formatoEuropeo)).append(", Votos positivos= ").append(votosPositivos);
        finalMessage.append(", Votos negativos= ").append(votosNegativos);
        return finalMessage.toString();
    }

    /**
     * Compara dos capítulos. Son iguales si sus títulos son iguales.
     *
     * @param obj el objeto Capitulo con el que se comparará
     * @return true si esos dos capítulos son iguales
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
        final Capitulo other = (Capitulo) obj;
        return Objects.equals(this.titulo, other.titulo);
    }

    /**
     * Añade un voto positivo o negativo dependiendo del parámetro like.
     *
     * @param like parametro booleano que si es true significa que le gusta el
     * capítulo y si es false no lo ha hecho
     */
    public void meGusta(boolean like) {
        if (like) {
            this.votosPositivos++;
        } else {
            this.votosNegativos++;
        }
    }

    /**
     * Calcula la puntuación del capítulo. La puntuación en este caso se calcula
     * dividiendo el número de votos positivos entre los votos totales y
     * multiplicando ese resultado por 10. La puntuación varía entre 0 y 10.
     *
     * @return la puntuacion del capítulo
     */
    @Override
    public int calcularPuntuacion() {
        return (int) (((double) this.votosPositivos / (this.votosPositivos + this.votosNegativos)) * 10);
    }

}
