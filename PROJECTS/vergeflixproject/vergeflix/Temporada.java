/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflixproject.vergeflix;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;
import java.util.regex.Pattern;
import funciones.ValidarDatos;
import comparator.OrdenarCapitulosVotos;

/**
 * Clase que nos permite instanciar temporadas y realizar distintas acciones con
 * ellas como almacenar capítulos.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class Temporada implements Valorable {

    private LocalDate fechaEstreno;
    private ArrayList<Capitulo> capitulos;
    private static final DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Permite instanciar un objeto de la clase Temporada.
     *
     * @param fechaEstreno la fecha en que se estrenará la temporada
     */
    public Temporada(LocalDate fechaEstreno) {
        this.fechaEstreno = LocalDate.of(fechaEstreno.getYear(), fechaEstreno.getMonthValue(), fechaEstreno.getDayOfMonth());
        this.capitulos = new ArrayList<>();
    }

    /**
     * Permite copiar un objeto de la clase Temporada.
     *
     * @param t la temporada cuyo estado copiaremos
     */
    public Temporada(Temporada t) {
        this(t.fechaEstreno);
        this.capitulos = new ArrayList<>();

        //introduzco las copias de los capitulos en la lista de capítulos
        for (Capitulo capitulo : t.capitulos) {
            this.capitulos.add(new Capitulo(capitulo));
        }
    }

    /**
     * Devuelve una representación en formato String de esta temporada.
     *
     * @return una representación en formato String de esta temporada.
     */
    @Override
    public String toString() {
        StringBuilder finalMessage = new StringBuilder("Fecha de estreno: ").append(fechaEstreno.format(formatoEuropeo)).append(" Capítulos: ")
                .append(this.capitulos.size()).append("\n");
        int contador = 1;
        for (Capitulo c : this.capitulos) {
            finalMessage.append("Capítulo ").append(contador).append(": ").append(c).append("\n");
            contador++;
        }

        return finalMessage.toString().trim();
    }

    /**
     * Compara estáticamente dos temporadas. Son iguales si sus fechas de
     * estreno y número de capítulos son iguales.
     *
     * @param obj el objeto Temporada con el que se comparará
     * @return true si esas dos temporadas son iguales
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
        final Temporada other = (Temporada) obj;
        if (!Objects.equals(this.fechaEstreno, other.fechaEstreno)) {
            return false;
        }
        return Objects.equals(this.capitulos, other.capitulos);
    }

    /**
     * Devuelve una copia de la fecha de estreno de la película.
     *
     * @return la fecha de estreno de la pelicula
     */
    public LocalDate getFechaEstreno() {
        return LocalDate.of(fechaEstreno.getYear(), fechaEstreno.getMonthValue(), fechaEstreno.getDayOfMonth());
    }

    /**
     * Permite añadir un capítulo a una temporada. Para que esto suceda, el
     * capítulo debe tener una fecha de emisión posterior a la fecha de estreno
     * y no estar dentro aún en la temporada.
     *
     * @param capitulo el capítulo que queremos añadir a la temporada
     * @return true si el capítulo se ha añadido
     */
    public boolean añadirCapitulo(Capitulo capitulo) {
        boolean seAñade = false;

        //contains funciona correctamente siempre que se haya sobreescrito el método equals en Capitulo
        if (!this.capitulos.contains(capitulo) && ValidarDatos.validarEmision(this.fechaEstreno, capitulo.getFechaEmision())) {
            this.capitulos.add(new Capitulo(capitulo.getTitulo(), capitulo.getFechaEmision()));
            seAñade = true;
        }

        return seAñade;
    }

    /**
     * Permite añadir un capítulo a una temporada a través de una fecha de
     * emisión y el título del capítulo. El capítulo debe tener una fecha de
     * emisión posterior a la fecha de estreno de la temporada y no estar aún
     * dentro de la temporada.
     *
     * @param fechaEmision la fecha de emisión del capítulo que queremos añadir
     * @param titulo el título del capítulo que queremos a añadir
     * @return true si se ha añadido
     */
    public boolean añadirCapitulo(LocalDate fechaEmision, String titulo) {
        boolean seAñade = true;

        for (Capitulo capitulo : this.capitulos) {
            if (seAñade && capitulo.getTitulo().equalsIgnoreCase(titulo)) {
                seAñade = false;
            }
        }

        if (seAñade && ValidarDatos.validarEmision(this.fechaEstreno, fechaEmision)) {
            this.capitulos.add(new Capitulo(titulo, fechaEmision));
        } else {
            seAñade = false;
        }

        return seAñade;
    }

    /**
     * Permite añadir un capítulo a una temporada en la posición deseada. Para
     * que esto suceda, el capítulo debe tener una fecha de emisión posterior de
     * la fecha de estreno de la temporada y no estar aún contenido en la
     * temporada.
     *
     * @param posicion la posicion del capitulo (no concuerda con el indice de
     * la lista de capítulos de la temporada)
     * @param capitulo el capítulo que queremos introducir en la temporada
     * @return true si se ha añadido
     */
    public boolean añadirCapitulo(int posicion, Capitulo capitulo) {
        posicion--;
        boolean seAñade = false;

        if (posicion >= 0 && posicion <= this.capitulos.size() && !this.capitulos.contains(capitulo)
                && ValidarDatos.validarEmision(this.fechaEstreno, capitulo.getFechaEmision())) {
            this.capitulos.add(posicion, new Capitulo(capitulo.getTitulo(), capitulo.getFechaEmision()));
            seAñade = true;
        }

        return seAñade;
    }

    /**
     * Permite añadir un capítulo a una temporada a través de una fecha de
     * emisión y el título del capítulo. El capítulo debe tener una fecha de
     * emisión posterior a la fecha de estreno de la temporada y no estar aún
     * contenido en la temporada.
     *
     * @param posicion la posicion del capitulo (no concuerda con el indice de
     * la lista de capítulos de la temporada)
     * @param fechaEmision la fecha de emisión del capítulo que queremos añadir
     * @param titulo el título del capitulo que queremos a añadir
     * @return true si se ha añadido
     */
    public boolean añadirCapitulo(int posicion, LocalDate fechaEmision, String titulo) {
        posicion--;
        boolean seAñade = true;

        for (Capitulo capitulo : this.capitulos) {
            if (seAñade && capitulo.getTitulo().equalsIgnoreCase(titulo)) {
                seAñade = false;
            }
        }

        if (seAñade && posicion >= 0 && posicion < this.capitulos.size() && ValidarDatos.validarEmision(this.fechaEstreno, fechaEmision)) {
            this.capitulos.add(posicion, new Capitulo(titulo, fechaEmision));

        } else {
            seAñade = false;
        }

        return seAñade;
    }

    /**
     * Elimina el capítulo que tenga el título introducido por parámetro.
     *
     * @param titulo el título del capítulo que queremos eliminar
     * @return true si se ha eliminado algun capítulo con ese título
     */
    public boolean eliminarCapitulo(String titulo) {
        boolean seElimino = false;

        Iterator<Capitulo> iterador = this.capitulos.iterator();

        while (iterador.hasNext()) {

            Capitulo capitulo = iterador.next();
            if (capitulo.getTitulo().equalsIgnoreCase(titulo)) {
                iterador.remove();
                seElimino = true;
            }
        }
        return seElimino;
    }

    /**
     * Elimina los capítulos de la temporada que coinciden con la expresión
     * regular introducida.
     *
     * @param expresionRegular la expresión regular con la que eliminaremos los
     * capítulos
     * @return el número de capítulos eliminados
     */
    public int eliminarCapitulos(String expresionRegular) {
        int numEliminados = 0;

        Iterator<Capitulo> iterador = this.capitulos.iterator();

        while (iterador.hasNext()) {

            Capitulo capitulo = iterador.next();
            if (Pattern.matches(expresionRegular, capitulo.getTitulo())) {
                iterador.remove();
                numEliminados++;
            }
        }

        return numEliminados;
    }

    /**
     * Devuelve una copia del capítulo cuya posición es la introducida.
     *
     * @param posicion la posicion del capitulo (no concuerda con el indice de
     * la lista de capítulos de la temporada)
     * @return el capítulo cuya posición en la lista coincide con la introducida
     */
    public Capitulo getCapitulo(int posicion) {
        posicion--;
        boolean esValida = (posicion >= 0 && posicion < this.capitulos.size());

        return (esValida) ? new Capitulo(this.capitulos.get(posicion)) : null;
    }

    /**
     * Modificará el título y la fecha de emisión del capítulo cuya posición es
     * la introducida por parámetro.
     *
     * @param posicion la posicion del capitulo (no concuerda con el indice de
     * la lista de capítulos de la temporada)
     * @param fechaEmision la fecha de emisión que queremos establecer
     * @param titulo el título que queremos establecer
     * @return true si el capítulo se ha modificado
     */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision, String titulo) {
        posicion--;
        boolean seModifica = true;

        //compruebo si el capítulo que quiero introducir ya lo está
        for (Capitulo capitulo : this.capitulos) {
            if (seModifica && capitulo.getTitulo().equalsIgnoreCase(titulo)) {
                seModifica = false;
            }
        }

        if (seModifica && posicion >= 0 && posicion < this.capitulos.size() && ValidarDatos.validarEmision(this.fechaEstreno, fechaEmision)) {
            this.capitulos.get(posicion).setTitulo(titulo);
            this.capitulos.get(posicion).setFechaEmision(fechaEmision);
        } else {
            seModifica = false;
        }

        return seModifica;
    }

    /**
     * Modificará la fecha de emisión del capítulo cuya posición es la
     * introducida por parámetro.
     *
     * @param posicion la posición del capitulo (no concuerda con el indice de
     * la lista de capítulos de la temporada)
     * @param fechaEmision la fecha de emisión que queremos establecer
     * @return true si el capítulo se ha modificado
     */
    public boolean setCapitulo(int posicion, LocalDate fechaEmision) {
        posicion--;
        boolean seModifica = false;

        if (posicion >= 0 && posicion < this.capitulos.size() && ValidarDatos.validarEmision(this.fechaEstreno, fechaEmision)) {
            this.capitulos.get(posicion).setFechaEmision(fechaEmision);
            seModifica = true;
        }

        return seModifica;
    }

    /**
     * Modificará el título del capítulo cuya posición es la introducida por
     * parámetro.
     *
     * @param posicion la posición del capítulo (no concuerda con el indice de
     * la lista de capítulos de la temporada)
     * @param titulo el título que queremos establecer
     * @return true si el capitulo se ha modificado
     */
    public boolean setCapitulo(int posicion, String titulo) {
        posicion--;
        boolean seModifica = true;

        //compruebo si el capítulo que quiero introducir ya lo está
        for (Capitulo capitulo : this.capitulos) {
            if (seModifica && capitulo.getTitulo().equals(titulo)) {
                seModifica = false;
            }
        }

        if (seModifica && posicion >= 0 && posicion < this.capitulos.size()) {
            this.capitulos.get(posicion).setTitulo(titulo);

        } else {
            seModifica = false;
        }

        return seModifica;
    }

    /**
     * Añade un voto positivo o negativo dependiendo del parámetro like. Se
     * podrá dar like a un capítulo si la posición de este es mayor o igual que
     * cero y menor que el tamaño de la lista de capítulos.
     *
     * @param posicionCapitulo la posición del capítulo (no concuerda con el
     * indice de la lista de capítulos de la temporada)
     * @param like si es true significa que el capítulo obtendra un voto
     * positivo
     * @return true si se ha podido dar me gusta
     */
    public boolean meGusta(int posicionCapitulo, boolean like) {
        posicionCapitulo--;
        boolean seVota = false;

        if (posicionCapitulo >= 0 && posicionCapitulo < this.capitulos.size()) {
            this.capitulos.get(posicionCapitulo).meGusta(like);
            seVota = true;
        }

        return seVota;
    }

    /**
     * Añade un voto positivo o negativo dependiendo del parametro like.
     *
     * @param titulo el título del capítulo que queremos votar
     * @param like si es true significa que el capítulo obtendra un voto
     * positivo
     * @return true si se ha podido dar me gusta
     */
    public boolean meGusta(String titulo, boolean like) {
        boolean seVota = false;

        for (Capitulo capitulo : this.capitulos) {
            if (capitulo.getTitulo().equalsIgnoreCase(titulo)) {
                capitulo.meGusta(like);
                seVota = true;
            }
        }

        return seVota;
    }

    /**
     * Modifica la fecha de estreno de la temporada.
     *
     * @param fecha la nueva fecha que queremos establecerle a la temporada
     * @return true si la fecha introducida por parámetro es anterior a la fecha
     * de emisión de cada capítulo o si la temporada no tiene ningún capítulo
     */
    public boolean setFechaEstreno(LocalDate fecha) {
        boolean estrenoCambiado = false;
        int numValidas = 0;

        for (Capitulo capitulo : this.capitulos) {
            if (capitulo.getFechaEmision().isAfter(fecha)) {
                numValidas++;
            }
        }

        //si todos los capitulos tienen fecha de emisión posterior a la que queremos modificar
        if (numValidas == this.capitulos.size()) {
            this.fechaEstreno = LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
            estrenoCambiado = true;
        }

        return estrenoCambiado;
    }

    /**
     * Devuelve una lista con n capítulos ordenados de mejor valorados a peor
     * valorados. Un capítulo esta mejor valorado que otro cuando tiene mayor
     * cantidad de votos positivos.
     *
     * @param n la cantidad de capítulos a mostrar
     * @return una lista del tipo ArrayList
     */
    public ArrayList<Capitulo> capitulosMejorValorados(int n) {

        //creo una nueva lista porque la lista "original" no es la que quiero ordenar
        ArrayList<Capitulo> copiaLista = new ArrayList<>();
        for (Capitulo capitulo : this.capitulos) {
            copiaLista.add(new Capitulo(capitulo));
        }

        OrdenarCapitulosVotos ordenarVotos = new OrdenarCapitulosVotos();
        Collections.sort(copiaLista, ordenarVotos);

        n = (n <= 0) ? this.capitulos.size() - 1 : n;
        n = (n >= this.capitulos.size()) ? this.capitulos.size() - 1 : n;

        return new ArrayList<>(copiaLista.subList(0, n));
    }

    /**
     * Calcula la puntuación de la Temporada. La puntuación en este caso se
     * calcula dividiendo la sumatoria de las puntuaciones de los capitulos de
     * la temporada entre el número de capítulos. La puntuación varía entre 0 y
     * 10.
     *
     * @return la puntuacion de la temporada
     */
    @Override
    public int calcularPuntuacion() {
        int sumPuntuaciones = 0;

        for (Capitulo c : this.capitulos) {
            sumPuntuaciones += c.calcularPuntuacion();
        }

        return (int) (((double) sumPuntuaciones / this.capitulos.size()));
    }

}
