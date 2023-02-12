/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaobjetos;

/**
 *
 * @author Hoxuro
 */
public class Persona {

    //DeclaraciÃ³n de atributos
    private String nombre;
    private byte edad;
    private double estatura;

    //DeclaraciÃ³n de constructores
    public Persona(String nombre, byte edad, double estatura) {
        if (!validarNombre(nombre)) {
            throw new IllegalArgumentException("Nombre fuera de rango");
        }
        if (!validarNumPositivo(edad)) {
            throw new IllegalArgumentException("Edad fuera de rango");
        }
        if (!validarNumPositivo(estatura)) {
            throw new IllegalArgumentException("Estatura fuera de rango");
        }
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    private boolean validarNombre(String nombre) {
        return !nombre.isEmpty() && !nombre.isBlank();
    }

    private boolean validarNumPositivo(double number) {
        return number > 0;
    }

    public Persona() {
        this("Juan", (byte) 1, 0.5);
    }

    public Persona(Persona p) {
        this(p.nombre, p.edad, p.estatura);
    }

    //DeclaraciÃ³n de mÃ©todos get/set para los atributos
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(byte edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            throw new IllegalArgumentException("Edad fuera de rango");
        }

    }

    public void setEstatura(double estatura) {
        if (estatura > 0) {
            this.estatura = estatura;
        } else {
            throw new IllegalArgumentException("Altura fuera de rango");
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public byte getEdad() {
        return this.edad;
    }

    public double getEstatura() {
        return this.estatura;
    }
}
