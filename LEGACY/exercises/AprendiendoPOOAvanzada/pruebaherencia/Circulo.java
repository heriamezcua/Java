/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaherencia;

/**
 *
 * @author amezc
 */
public class Circulo extends Figura {

    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }
    
    

    public double getRadio() {
        return this.radio;
    }

    public double area() {
        return Math.pow(Math.PI * this.radio, 2);
    }

    @Override
    public String toString() {
        return "Circulo{" + "radio=" + radio + '}';
    }

}
