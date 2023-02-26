/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comparablevscomparator;

import java.util.regex.Pattern;

/**
 *
 * @author amezc
 */
public class Persona implements Comparable<Persona> {

    private String nombre;
    private int edad;

    public Persona(String nombre, int edad) {
        if (!Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{1,}", nombre)) {
            throw new IllegalArgumentException("El nombre es incorrecto.");
        }
        this.nombre = nombre;

        if (edad < 0) {
            throw new IllegalArgumentException("La edad es incorrecta.");
        }
        this.edad = edad;

    }

    public Persona() {
        this("Persona", 0);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + ", edad=" + edad + "\n";
    }

    //el metodo compareTo, se podría decir que es el orden NATURAL del objeto
    //en este caso ordena las personas a partir del valor numerico del nombre de las personas
    @Override
    public int compareTo(Persona o) {
        if (Character.getNumericValue(o.nombre.charAt(0)) < Character.getNumericValue(this.nombre.charAt(0))) {
            return 1;
        } else if (Character.getNumericValue(o.nombre.charAt(0)) < Character.getNumericValue(this.nombre.charAt(0))) {
            return 0;
        } else {
            return -1;
        }
    }

}
