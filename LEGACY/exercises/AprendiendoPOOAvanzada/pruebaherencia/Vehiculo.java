/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaherencia;

/**
 *
 * @author amezc
 */
public abstract class Vehiculo {

    private String color;

    public Vehiculo(String color) {
        this.color = color;
    }

    public Vehiculo() {
        this(null);
    }

    public abstract void arrancar();

    @Override
    public String toString() {
        return "Color=" + color;
    }

}
