/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaherencia;

import java.time.LocalDate;

/**
 *
 * @author amezc
 */
public class Persona extends Animal {

    //una clase hija puede acceder a los atributos protected de su padre
    protected String nombre;
    private String apellidos;
    private LocalDate fechaNacim;

    public Persona(String nombre, String apellido) {
        super("Omnivora");
        this.nombre = nombre;
        this.apellidos = apellido;
        fechaNacim = LocalDate.now();
    }

    public Persona() {
        this(null, null);
    }

    @Override
    public String toString() {
        return super.toString() + " Nombre=" + nombre + ", Apellidos=" + apellidos + ", Fecha de nacimiento=" + fechaNacim;
    }

}
