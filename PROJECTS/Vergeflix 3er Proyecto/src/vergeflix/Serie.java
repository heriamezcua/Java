/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vergeflix;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Objects;
import funciones.ValidarDatos;

/**
 * Permite crear series para poder realizar distintas funciones con ellas.
 * Hereda de la clase Media.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 19
 */
public class Serie extends Media {

    private LocalDate fechaEstreno;
    private ArrayList<Temporada> temporadas;
    private static final DateTimeFormatter formatoEuropeo = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /**
     * Constructor que permite instanciar un objeto de la clase Serie.
     *
     * @param nombre el nombre de la serie
     * @param calificacionEdad la calificacion por edad de la serie
     * @param fechaIncorporacion la fecha de incorporación al catálogo de la
     * serie
     * @param estaDisponible la disponibilidad de la serie
     * @param fechaEstreno la fecha de estreno de la serie
     */
    public Serie(String nombre, int calificacionEdad, LocalDate fechaIncorporacion, boolean estaDisponible, LocalDate fechaEstreno) {
        super(nombre, calificacionEdad, fechaIncorporacion, estaDisponible);
        this.fechaEstreno = LocalDate.of(fechaEstreno.getYear(), fechaEstreno.getMonthValue(), fechaEstreno.getDayOfMonth());
        this.temporadas = new ArrayList<>();
    }

    /**
     * Constructor copia que permite copiar el estado de un objeto Serie en otra
     * nueva.
     *
     * @param s el objeto serie cuyo estado queremos copiar
     */
    public Serie(Serie s) {
        this(s.getNombre(), s.getCalificacionEdad(), s.getFechaIncorporacionAlCatalogo(),
                s.getEstaDisponible(), s.fechaEstreno);

        //haga una copia de la lista de temporadas con copias de sus capítulos mediante el constructor copia de temporada
        this.temporadas = new ArrayList<>();
        for (Temporada temporada : this.temporadas) {
            this.temporadas.add(new Temporada(temporada));
        }
    }

    /**
     * Devuelve una copia de la fecha de estreno de la serie.
     *
     * @return una copia de la fecha de estreno de la serie
     */
    public LocalDate getFechaEstreno() {
        return LocalDate.of(fechaEstreno.getYear(), fechaEstreno.getMonthValue(), fechaEstreno.getDayOfMonth());
    }

    /**
     * Devuelve una representación en formato String de esta serie.
     *
     * @return una representación en formato String de esta serie.
     */
    @Override
    public String toString() {
        StringBuilder finalMessage = new StringBuilder(super.toString()).append("Fecha de estreno= ").append(fechaEstreno.format(formatoEuropeo));
        finalMessage.append(", Temporadas= ").append(this.temporadas.size()).append(", Puntuación: ").append(calcularPuntuacion());
        //no muestro el contenido de las temporadas de la serie porque deberia mostrarse en el toString de temporada
        return finalMessage.toString();
    }

    /**
     * Compara dos series. Son iguales si la fecha de estreno es la misma. (Lo
     * combino con el de Media para los demás atributos)
     *
     * @param obj el objeto Pelicula con el que se comparará
     * @return true si esas dos series son iguales
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
        final Serie other = (Serie) obj;
        return Objects.equals(this.fechaEstreno, other.fechaEstreno);
    }

    /**
     * Crea una temporada vacía con fecha de estreno introducida por parámetro y
     * la añadirá a la lista de temporadas de la serie.
     *
     * @param fechaEstreno la fecha de estreno que queremos que tenga la
     * temporada a añadirá
     * @return true si fechaEstreno es mayor o igual que la fecha de estreno de
     * la serie
     */
    public boolean añadirTemporada(LocalDate fechaEstreno) {
        boolean seAñade = ValidarDatos.validarEstreno(this.fechaEstreno, fechaEstreno);

        //busco si alguna temporada coincide con el mes y año de fechaEstreno
        for (Temporada temporada : this.temporadas) {
            seAñade = (seAñade && !ValidarDatos.mismoEstreno(temporada.getFechaEstreno(), fechaEstreno));
        }

        if (seAñade) {
            this.temporadas.add(new Temporada(fechaEstreno));
        }

        return seAñade;
    }

    /**
     * Añade una copia de la temporada introducida por parámetro y la añadirá a
     * la lista de temporadas de la serie.
     *
     * @param temporada la temporada que vamos a añadir
     * @return true si la temporada se estrena en un mes distinto a las demás y
     * se estrena después o el mismo dia que la serie
     */
    public boolean añadirTemporada(Temporada temporada) {
        boolean seAñade = ValidarDatos.validarEstreno(this.fechaEstreno, temporada.getFechaEstreno());

        //busco si alguna temporada coincide con el mes de fechaEstreno en el mismo año
        for (Temporada temp : this.temporadas) {
            seAñade = (seAñade && !ValidarDatos.mismoEstreno(temp.getFechaEstreno(), temporada.getFechaEstreno()));
        }

        if (seAñade) {
            this.temporadas.add(new Temporada(temporada));
        }

        return seAñade;
    }

    /**
     * Elimina la temporada situada en el índice n
     *
     * @param n el número de la temporada dentro de la serie que queremos
     * eliminar (No coincide con el índice de la temporada en la lista). n es
     * válido si es mayor o igual a cero y menor que el tamaño de la lista
     * @return true si se elimina la tempordada
     */
    public boolean eliminarTemporada(int n) {
        n--;
        boolean seElimina = false;

        if (n >= 0 && n < this.temporadas.size()) {
            this.temporadas.remove(n);
            seElimina = true;
        }

        return seElimina;
    }

    /**
     * Añade un capitulo a una temporada introducidos por parámetro.
     *
     * @param nTemporada el índice más 1 de la temporada ya que el usuario no
     * maneja índices de listas
     * @param capitulo el capítulo que vamos a copiar en la temporada
     * @return true si el índice de la temporada es mayor o igual que cero y el
     * capítulo tiene distinto título de los que ya tiene la temporada
     */
    public boolean añadirCapitulo(int nTemporada, Capitulo capitulo) {
        //hago que el numero de temporada se adapte a los indices de la lista
        nTemporada--;
        boolean seAñade = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (seAñade) {
            seAñade = this.temporadas.get(nTemporada).añadirCapitulo(capitulo);
        }

        return seAñade;
    }

    /**
     * Añade un capítulo con título y fecha de emisión introducidos por
     * parámetro a una temporada introducida.
     *
     * @param nTemporada el número de temporada (no concuerda con el índice de
     * la lista de temporadas de la serie)
     * @param fechaEmision la fecha de emisión del capítulo vamos a introducir
     * @param titulo el título del capítulo que vamos a introducir
     * @return true si se añade el capítulo, un capítulo se añade si el número
     * de temporada menos uno es mayor o igual que cero y menor que el tamaño de
     * la lista
     */
    public boolean añadirCapitulo(int nTemporada, LocalDate fechaEmision, String titulo) {
        //hago que el numero de temporada se adapte a los indices de la lista
        nTemporada--;
        boolean seAñade = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (seAñade) {
            seAñade = this.temporadas.get(nTemporada).añadirCapitulo(fechaEmision, titulo);
        }

        return seAñade;
    }

    /**
     * Añade un capítulo a una temporada y en una posición concreta introducidos
     * por parámetro.
     *
     * @param nTemporada el número de temporada (no concuerda con el índice de
     * la lista de temporadas de la serie)
     * @param posicion la posicion en la que queremos introducir el capitulo (no
     * concuerda con el indice de la lista de temporadas de la serie)
     * @param capitulo el capitulo que vamos a añadir
     * @return true si se añade el capítulo, un capítulo se añade si el número
     * de temporada menos uno es mayor o igual que cero y menor que el tamaño de
     * la lista
     */
    public boolean añadirCapitulo(int nTemporada, int posicion, Capitulo capitulo) {
        //hago que el numero de temporada se adapte a los indices de la lista
        nTemporada--;
        boolean seAñade = false, indiceValido = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (indiceValido) {
            seAñade = this.temporadas.get(nTemporada).añadirCapitulo(posicion, capitulo);
        }

        return seAñade;
    }

    /**
     * Añade un capítulo en la posicion introducida por parámetro de título y
     * fecha de emisión introducidos por parámetro a una temporada introducida.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param posicion la posicion en la que queremos introducir el capitulo (no
     * concuerda con el indice de la lista de temporadas de la serie)
     * @param fechaEmision la fecha de emisión del capitulo vamos a introducir
     * @param titulo el título del capítulo que vamos a introducir
     * @return true si se añade el capítulo, un capítulo se añade si el número
     * de temporada menos uno es mayor o igual que cero y menor que el tamaño de
     * la lista
     */
    public boolean añadirCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo) {
        //hago que el numero de temporada se adapte a los indices de la lista
        nTemporada--;
        boolean seAñade = false, indiceValido = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (indiceValido) {
            seAñade = this.temporadas.get(nTemporada).añadirCapitulo(posicion, fechaEmision, titulo);
        }

        return seAñade;
    }

    /**
     * Elimina el capitulo de la temporada con un índice nTemporada - 1 que
     * tenga el título introducido por parámetro.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param titulo el título del capítulo que vamos a introducir
     * @return true si se ha eliminado el capítulo. Un capítulo de una temporada
     * se elimina si tiene el mismo título que el introducido por parámetro.
     */
    public boolean eliminarCapitulo(int nTemporada, String titulo) {
        nTemporada--;
        boolean seElimina = false, indiceValido = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (indiceValido) {
            seElimina = this.temporadas.get(nTemporada).eliminarCapitulo(titulo);
        }

        return seElimina;
    }

    /**
     * Elimina todos los capítulos de todas las temporadas de la serie que
     * cumplan la expresión regular introducida por parámetro.
     *
     * @param expresionRegular la expresión regular que el método seguirá para
     * eliminar un capítulo o no
     * @return el número de capítulos eliminados
     */
    public int eliminarCapítulos(String expresionRegular) {
        int numEliminados = 0;

        for (Temporada temporada : this.temporadas) {
            numEliminados += temporada.eliminarCapitulos(expresionRegular);
        }

        return numEliminados;
    }

    /**
     * Devuelve una copia del capítulo cuya temporada y posición en esta se
     * introducen por parámetro.
     *
     * @param nTemporada el número de temporada (no concuerda con el índice de
     * la lista de temporadas de la serie)
     * @param posicion la posición en la que queremos introducir el capítulo (no
     * concuerda con el índice de la lista de temporadas de la serie)
     * @return una copia del capítulo cuya temporada y posición en esta se
     * introducen por parámetro, si la posición no es válida devuelve null
     */
    public Capitulo getCapitulo(int nTemporada, int posicion) {
        nTemporada--;
        posicion--;
        return (this.temporadas.get(nTemporada).getCapitulo(posicion + 1) != null)
                ? new Capitulo(this.temporadas.get(nTemporada).getCapitulo(posicion + 1)) : null;
    }

    /**
     * Modificará el título y la fecha de emisión del capítulo cuya posición y
     * temporada son introducidas por parámetro.
     *
     * @param nTemporada el número de temporada (no concuerda con el índice de
     * la lista de temporadas de la serie)
     * @param posicion la posición en la que queremos introducir el capítulo (no
     * concuerda con el índice de la lista de temporadas de la serie)
     * @param fechaEmision la nueva fecha de emisión que tendrá el capítulo
     * @param titulo el nuevo título que tendrá el capítulo
     * @return true si se ha podido modificar el cápitulo
     */
    public boolean setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision, String titulo) {
        nTemporada--;
        boolean seModifica = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (seModifica) {
            //la posicion no la modifico ya que el método setCapitulo ya la modificaba
            seModifica = this.temporadas.get(nTemporada).setCapitulo(posicion, fechaEmision, titulo);
        }

        return seModifica;
    }

    /**
     * Modificará la fecha de emisión del capítulo cuya posición y temporada son
     * introducidas por parámetro.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param posicion la posicion en la que queremos introducir el capitulo (no
     * concuerda con el indice de la lista de temporadas de la serie)
     * @param fechaEmision la nueva fecha de emisión que tendrá el capítulo
     * @return true si se ha podido modificar el cápitulo
     */
    public boolean setCapitulo(int nTemporada, int posicion, LocalDate fechaEmision) {
        nTemporada--;
        posicion--;
        boolean seModifica = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (seModifica) {
            seModifica = this.temporadas.get(nTemporada).setCapitulo(posicion + 1, fechaEmision);
        }

        return seModifica;
    }

    /**
     * Modificará el título del capítulo cuya posición y temporada son
     * introducidas por parámetro.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param posicion la posicion en la que queremos introducir el capitulo (no
     * concuerda con el indice de la lista de temporadas de la serie)
     * @param titulo el nuevo título que tendrá el capítulo
     * @return true si se ha podido modificar el cápitulo
     */
    public boolean setCapitulo(int nTemporada, int posicion, String titulo) {
        nTemporada--;
        posicion--;
        boolean seModifica = (nTemporada >= 0 && nTemporada < this.temporadas.size());

        if (seModifica) {
            seModifica = this.temporadas.get(nTemporada).setCapitulo(posicion + 1, titulo);
        }

        return seModifica;
    }

    /**
     * Modificará la fecha de emisión del capítulo cuya posición y temporada son
     * introducidas por parámetro.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param fechaEstreno la nueva fecha de estreno que tendrá la temporada
     * @return true si se ha podido modificar la fecha de estreno de la
     * temporada
     */
    public boolean setTemporada(int nTemporada, LocalDate fechaEstreno) {
        nTemporada--;
        boolean seModifica = false;

        if (ValidarDatos.validarEstreno(this.fechaEstreno, fechaEstreno)) {
            if (this.temporadas.get(nTemporada).setFechaEstreno(fechaEstreno)) {
                seModifica = true;
            }
        }

        return seModifica;
    }

    /**
     * Añade un voto positivo o negativo a un capítulo de una temporada
     * introducidos por parámetro dependiendo del valor de like.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param posicionCapitulo la posicion del capitulo (no concuerda con el
     * índice de la lista de temporadas de la serie)
     * @param like valor booleano que representa si gusta o no el capítulo
     * @return true si se ha podido valorar el capítulo
     */
    public boolean meGusta(int nTemporada, int posicionCapitulo, boolean like) {
        nTemporada--;
        boolean vota = ValidarDatos.validarIndice(nTemporada, this.temporadas.size());

        if (vota) {
            vota = this.temporadas.get(nTemporada).meGusta(posicionCapitulo, like);
        }

        return vota;
    }

    /**
     * Añade un voto positivo o negativo a un capítulo de una temporada cuya
     * posición y título son introducidos por parámetro dependiendo del valor de
     * like.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @param titulo el nuevo título que tendrá el capítulo
     * @param like valor booleano que representa si gusta o no el capítulo
     * @return true si se ha podido valorar el capítulo
     */
    public boolean meGusta(int nTemporada, String titulo, boolean like) {
        nTemporada--;
        boolean vota = ValidarDatos.validarIndice(nTemporada, this.temporadas.size());

        if (vota) {
            vota = (this.temporadas.get(nTemporada).meGusta(titulo, like));
        }

        return vota;
    }

    /**
     * Cambia la fecha de estreno de la serie. La fecha de estreno se puede
     * cambiar si es anterior o igual a la fecha de estreno de cada temporada.
     *
     * @param fecha la nueva fecha de estreno de la serie
     * @return true si se ha podido cambiar la fecha de estreno
     */
    public boolean setFechaEstreno(LocalDate fecha) {
        boolean puedeCambiar = true;

        for (Temporada temporada : this.temporadas) {
            if (puedeCambiar && temporada.getFechaEstreno().isBefore(fecha)) {
                puedeCambiar = false;
            }
        }

        if (puedeCambiar) {
            this.fechaEstreno = LocalDate.of(fecha.getYear(), fecha.getMonthValue(), fecha.getDayOfMonth());
        }

        return puedeCambiar;
    }

    /**
     * Devuelve una copia de la temporada cuya posicion se introduce por
     * parámetro.
     *
     * @param nTemporada el numero de temporada (no concuerda con el indice de
     * la lista de temporadas de la serie)
     * @return una copia de la temporada cuya posición es la de nTemporada -1 o
     * null si nTemporada -1 no es mayor o igual a cero y menor que tamaño de la
     * lista de temporadas de la serie
     */
    public Temporada getCopiaTemporada(int nTemporada) {
        nTemporada--;
        return (nTemporada >= 0 && nTemporada < this.temporadas.size()) ? new Temporada(this.temporadas.get(nTemporada)) : null;
    }

    /**
     * Calcula la puntuación de la serie. La puntuación en este caso se calcula
     * dividiendo la sumatoria de las puntuaciones de la serie entre el número
     * de temporadas. La puntuación varía entre 0 y 10.
     *
     * @return la puntuacion de la serie
     */
    @Override
    public int calcularPuntuacion() {
        int sumPuntuaciones = 0;

        for (Temporada t : this.temporadas) {
            sumPuntuaciones += t.calcularPuntuacion();
        }

        return (int) ((double) sumPuntuaciones / this.temporadas.size());
    }
}
