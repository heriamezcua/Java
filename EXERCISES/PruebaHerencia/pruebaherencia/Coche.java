/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaherencia;

/**
 *
 * @author amezc
 */
public class Coche extends Vehiculo {

    private String marca;

    public Coche(String marca, String color) {
        super(color);
        this.marca = marca;
    }

    public Coche() {
        this("Mercedes", "Rojo");
    }

    @Override
    public void arrancar() {
        System.out.println("Arranca un coche");
    }

    @Override
    public String toString() {
        return super.toString() + " Marca=" + marca;
    }

}
