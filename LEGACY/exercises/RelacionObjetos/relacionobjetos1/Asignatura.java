/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos1;

import java.util.Objects;

/**
 * Clase que simula una asignatura y nos permite hacer algunas operaciones con
 * ella.
 *
 * @author Hoxuro
 * @version 1.0
 */
public class Asignatura {

    private String nombre;
    private int horas;

    /**
     * Metodo con el que podemos crear una asignatura introduciendo el nombre de
     * esta y las horas que acumula.
     *
     * @param nombre el nombre de la asignatura
     * @param horas el numero de horas que tiene
     * @throws IllegalArgumentException si las horas son negativas
     */
    public Asignatura(String nombre, int horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("Una asignatura no puede tener horas negativas");
        }

        this.nombre = nombre;
        this.horas = horas;
    }

    /**
     * Metodo que crea una asignatura exactamente igual a otra.
     *
     * @param a asignatura que queremos copiar
     */
    public Asignatura(Asignatura a) {
        this.horas = a.horas;
        this.nombre = a.nombre;

    }

    /**
     * Metodo que nos devuelve el nombre de la asignatura.
     *
     * @return el nombre de la asignatura
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Metodo que nos develve las horas acumuladas en la asignatura.
     *
     * @return las horas acumuladas en la asignatura
     */
    public int getHoras() {
        return this.horas;
    }

    /**
     * Metodo que nos permite poner el nombre a esa asignatura.
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que no permite poner las horas que queramos a esa asignatura.
     *
     * @param horas
     * @throws IllegalArgumentException si las horas son negativas o nulas
     */
    public void setHoras(int horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("Las horas no pueden ser nulas o negativas");
        }
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + "\nHoras: " + this.horas;
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
        final Asignatura other = (Asignatura) obj;
        if (this.horas != other.horas) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

}

/*MAIN
        Asignatura mates = new Asignatura("Matematicas", 12);
        Asignatura lengua = new Asignatura("Lengua", 8);
        Asignatura lengua2 = new Asignatura("Mates", 8);

        System.out.println(lengua.getNombre());
        System.out.println(lengua.getHoras());
        
        System.out.println(lengua.equals(lengua2));
 */
