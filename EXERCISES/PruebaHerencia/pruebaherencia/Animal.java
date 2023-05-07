/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaherencia;

/**
 * PARA PROBAR EL ASCENSO EN LA CADENA DE HERENCIA CON SUPER()
 * @author amezc
 */
public class Animal {

    private String alimentacion;

    public Animal(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public Animal() {
        this.alimentacion = null;
    }

    @Override
    public String toString() {
        return "Alimentacion=" + alimentacion;
    }

}
