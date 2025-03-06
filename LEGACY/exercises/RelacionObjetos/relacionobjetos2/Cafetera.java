/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos2;

/**
 * Metodo que nos permite simular una cafetera e interactuar con ella.
 *
 * @version 1.0
 * @author Hoxuro
 */
public class Cafetera {

    private int capacidadMaxima, capacidadActual;

    /**
     * Metodo que nos inicializa una cafetera con una capacidad maxima y actual
     * introducidas por el usuario.
     *
     * @param capacidadMaxima la capacidad maxima que puede almacenar la
     * cafetera.
     * @param capacidadActual la capacidad actual que almacena la cafetera
     * @throws IllegalArgumentException si la capacidad maxima es sobrepasada
     * por la actual.
     */
    public Cafetera(int capacidadMaxima, int capacidadActual) {
        if (capacidadActual > capacidadMaxima) {
            throw new IllegalArgumentException("La capacidad actual no puede"
                    + " ser superior a la capacidad maxima");
        }
        this.capacidadActual = capacidadActual;
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Metodo constructor por defecto que nos crea una cafetera con una
     * capacidad maxima de 1000ml y su capacidad actual a cero.
     */
    public Cafetera() {
        this(1000, 0);
    }

    /**
     * Metodo constructor que nos crea una cafetera con la capacidad maxima que
     * el usuario le introduzca y una capacidad actual igual a la maxima.
     *
     * @param capacidadMaxima capacidad maxima que puede almacenar la cafetera.
     */
    public Cafetera(int capacidadMaxima) {
        this.capacidadActual = capacidadMaxima;
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("La capacidad maxima no puede ser nula o negativa");
        }
        this.capacidadMaxima = capacidadMaxima;
    }

    public void setCapacidadActual(int capacidadActual) {
        if (capacidadActual < 0) {
            throw new IllegalArgumentException("La capacidad actual no puede ser negativa");
        }
        this.capacidadActual = capacidadActual;
    }

    public int getCapacidadMaxima() {
        return this.capacidadMaxima;
    }

    public int getCapacidadActual() {
        return this.capacidadActual;
    }

    /**
     * Metodo que simula llenar la cafetera poniendo la capacidad actual igual a
     * la maxima.
     */
    public void llenarCafetera() {
        this.capacidadActual = this.capacidadMaxima;
    }

    /**
     * Metodo que simula la accion de servir una taza con la cantidad que le
     * indique el usuario.
     *
     * @param cantidad cantidad de ml que se sirve en la taza.
     * @return un string diciendo la cantidad servida.
     */
    public String servirTaza(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad servida no puede ser negativa o nula");
        }

        this.capacidadActual -= cantidad;
        return "Sirviendo taza de capacidad " + cantidad + "ml...";
    }

    /**
     * Metodo que "vacia" la cafetera poniendo la capacidad actual en cero.
     */
    public void vaciarCafetera() {
        this.capacidadActual = 0;
    }

    public void agregarCafe(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de cafe agregada no puede ser negativa o nula");
        }
        this.capacidadActual = cantidad;
    }

    @Override
    public String toString() {
        return "CapacidadMaxima=" + capacidadMaxima + "| CapacidadActual=" + capacidadActual;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.capacidadMaxima;
        hash = 67 * hash + this.capacidadActual;
        return hash;
    }

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
        final Cafetera other = (Cafetera) obj;
        if (this.capacidadMaxima != other.capacidadMaxima) {
            return false;
        }
        return this.capacidadActual == other.capacidadActual;
    }

}

/*MAIN
        Cafetera cafet1 = new Cafetera(1200, 500);
        Cafetera cafet2 = new Cafetera();
        Cafetera cafet3 = new Cafetera(800);
        System.out.println("Cafet1: " + cafet1);
        System.out.println("Cafet2: " + cafet2);
        System.out.println("Cafet3: " + cafet3);

        cafet2.llenarCafetera();
        System.out.println("Cafet2: " + cafet2);
        System.out.println(cafet1.servirTaza(500));
        System.out.println("Cafet1: " + cafet1);

        cafet1.setCapacidadActual(800);
        System.out.println(cafet1.getCapacidadActual());
        cafet3.setCapacidadMaxima(5000);
        System.out.println(cafet3.getCapacidadMaxima());

        cafet1.vaciarCafetera();
        System.out.println(cafet1);

        cafet1.agregarCafe(500);
        System.out.println(cafet1);
*/
