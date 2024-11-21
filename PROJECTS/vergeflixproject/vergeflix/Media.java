/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.vergeflix;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import funciones.ValidarDatos;

/**
 * Esta clase proporciona métodos y atributos que sirven como punto de partida
 * para otras clases hijas y que así estas puedan especializarse hacia un Media
 * en concreto.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public abstract class Media implements Valorable, Comparable<Media> {

    private String nombre;
    private int calificacionEdad;
    private LocalDate fechaIncorporacionAlCatalogo;
    private boolean estaDisponible;
    private static final DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Constructor que permite instanciar un objeto de la clase Media. En este
     * caso nos sirve como base para los constructores de las clases que hereden
     * de Media porque Media es una clase abstracta.
     *
     * @param nombre el nombre del Media que vamos a crear
     * @param calificacionEdad la edad para la que esta calificada
     * @param fechaIncorporacion la fecha en la que se incorpora al catálogo
     * @param estaDisponible si ese Media esta disponible para su consumo o no
     * @throws IllegalArgumentException si nombre esta vacío o compuesto de
     * espacios en blanco
     * @throws IllegalArgumentException si calificacionEdad no es un entero
     * entre 0 y 18
     */
    public Media(String nombre, int calificacionEdad, LocalDate fechaIncorporacion, boolean estaDisponible) {
        if (!ValidarDatos.validarTitulo(nombre)) {
            throw new IllegalArgumentException("El título no cumple con los requisitos.");
        }
        if (!ValidarDatos.validarCalificacionEdad(calificacionEdad)) {
            throw new IllegalArgumentException("La calificación por edad no es válida");
        }

        //quito los espacios en blanco que sobran
        this.nombre = nombre.trim().replaceAll("\\s+{2,}", " ");
        this.calificacionEdad = calificacionEdad;
        this.fechaIncorporacionAlCatalogo = LocalDate.of(fechaIncorporacion.getYear(), fechaIncorporacion.getMonthValue(), fechaIncorporacion.getDayOfMonth());
        this.estaDisponible = estaDisponible;
    }

    /**
     * Devuelve el nombre de ese Media.
     *
     * @return el nombre de ese Media
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Modifica el nombre de ese Media.
     *
     * @param nombre el nombre que queremos establecer a ese Media
     */
    public void setNombre(String nombre) {
        if (ValidarDatos.validarTitulo(nombre)) {
            this.nombre = nombre;
        }
    }

    /**
     * Devuelve la calificación por edad de ese Media.
     *
     * @return la calificacion por edad de ese Media
     */
    public int getCalificacionEdad() {
        return calificacionEdad;
    }

    /**
     * Modifica la calificación por edad de ese media. Se modificará siempre que
     * la calificación por edad sea mayor o igual a cero y menor o igual a 18.
     *
     * @param calificacionEdad la calificacion por edad que queremos establecer
     * a ese Media
     */
    public void setCalificacionEdad(int calificacionEdad) {
        if (ValidarDatos.validarCalificacionEdad(calificacionEdad)) {
            this.calificacionEdad = calificacionEdad;
        }
    }

    /**
     * Devuelve la fecha en que ese Media se incorporó al catálogo.
     *
     * @return la fecha en la que se incorporó al catálogo
     */
    public LocalDate getFechaIncorporacionAlCatalogo() {
        return fechaIncorporacionAlCatalogo;
    }

    /**
     * Modifica la fecha en que ese Media es incorporó al catálogo. Se creará
     * una copia de la fecha introducida por parámetro en
     * fechaIncorporacionAlCatalogo del Media.
     *
     * @param fechaIncorporacionAlCatalogo la fecha en que se incorporo al
     * catálogo ese Media
     */
    public void setFechaIncorporacionAlCatalogo(LocalDate fechaIncorporacionAlCatalogo) {
        this.fechaIncorporacionAlCatalogo = LocalDate.of(fechaIncorporacionAlCatalogo.getYear(), fechaIncorporacionAlCatalogo.getMonthValue(), fechaIncorporacionAlCatalogo.getDayOfMonth());
    }

    /**
     * Devuelve la disponibilidad de visualización de ese Media.
     *
     * @return true si está disponible dependiendo del valor de estaDisponible
     */
    public boolean getEstaDisponible() {
        return estaDisponible;
    }

    /**
     * Establece el estado de disponibilidad de ese Media mediante un parámetro
     * booleano.
     *
     * @param estaDisponible el estado de disponibilidad de ese Media
     */
    public void setEstaDisponible(boolean estaDisponible) {
        this.estaDisponible = estaDisponible;
    }

    /**
     * Devuelve una representación en formato String de este Media. (Al ser una
     * clase abstracta, lo podrán usar las clase que hereden de Media)
     *
     * @return una representación en formato String de este Media.
     */
    @Override
    public String toString() {
        StringBuilder finalMessage = new StringBuilder("Título= ").append(nombre).append(", Calificacion por edad= ").append(calificacionEdad);
        finalMessage.append(", Fecha de incorporación al catálogo= ").append(fechaIncorporacionAlCatalogo.format(formatoEuropeo));
        finalMessage.append(", Disponibilidad= ");
        if (estaDisponible) {
            finalMessage.append("Disponible\n");
        } else {
            finalMessage.append("No disponible\n");
        }
        return finalMessage.toString();
    }

    /**
     * Compara estáticamente dos Media. Son iguales si el estado de sus
     * atributos nombre, calificacionEdad, fechaIncorporacionAlCatalogo y
     * estaDisponible son iguales.
     *
     * @param obj el objeto Media con el que se comparará
     * @return true si esos dos Media son iguales
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
        final Media other = (Media) obj;
        if (this.calificacionEdad != other.calificacionEdad) {
            return false;
        }
        if (this.estaDisponible != other.estaDisponible) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.fechaIncorporacionAlCatalogo, other.fechaIncorporacionAlCatalogo);
    }

    /**
     * Compara en base al orden alfabético del nombre, a igualdad de nombre el
     * menor sera el que tenga la calificación por edad más baja.
     *
     * @param o el otro objeto Media con el que vamos a comparar el primero
     * @return 1 si el objeto 1 es mayor que el objeto 2, -1 si el objeto 1 es
     * menor que el objeto 2 o 0 si el objeto 1 es igual al objeto 2
     */
    @Override
    public int compareTo(Media o) {
        int result;

        //si el valor numérico del objeto 1 es menor que el del objeto 2
        if (this.getNombre().compareTo(o.getNombre()) < 0) {
            result = -1;

            //si el valor numérico del objeto 1 es mayor que el del objeto 2
        } else if (this.getNombre().compareTo(o.getNombre()) > 0) {
            result = 1;

            //si el valor numérico de ambos son iguales
        } else {
            //si la calificación por edad del objeto 1 es menor que la del objeto 2
            if (this.calificacionEdad < o.getCalificacionEdad()) {
                result = -1;
                //si la calificación por edad del objeto 1 es mayor que la del objeto 2
            } else if (this.calificacionEdad > o.getCalificacionEdad()) {
                result = 1;
                //sino iguales
            } else {
                result = 0;
            }
        }

        return result;
    }

}
