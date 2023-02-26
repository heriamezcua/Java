/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainstanceof;

/**
 *
 * @author amezc
 */
public class Triangulo extends Figura {

    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public double getBase() {
        return this.base;
    }

    public double getAltura() {
        return this.altura;
    }

    public double area() {
        return this.base * this.altura;
    }

    @Override
    public String toString() {
        return "Triangulo{" + "base=" + base + ", altura=" + altura + '}';
    }

    public Figura getNewFigura() {
        return new Triangulo(base, altura);
    }

}
