/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author amezc
 */
public class Usuario {

    private String nombre, apellido;
    private int edad;

    public Usuario(String nombre, String apellido, int edad) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre está vacío");
        }
        if (apellido.isBlank()) {
            throw new IllegalArgumentException("El nombre está vacío");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("El nombre está vacío");
        }

        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Usuario() {
        this("usuario", "usuario", 0);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

}
