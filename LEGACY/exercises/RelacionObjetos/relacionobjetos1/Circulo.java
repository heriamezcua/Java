/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos1;

import java.util.Objects;

/**
 *
 * @author amezc
 */
public class Circulo {

    private Punto centro;
    private double radio;

    /**
     * Default circle method that allows the user to create a circle with its
     * parameters at 0.
     */
    public Circulo() {

        this(0, 0, 0);
    }

    /**
     * Circle method that allows the user to create a circle introducing its
     * parameters
     *
     * @param origen_x
     * @param origen_y
     * @param radio
     */
    public Circulo(double origen_x, double origen_y, double radio) {
        if (radio < 0) {
            throw new IllegalArgumentException("El radio debe ser mayor o igual que 0");
        }
        this.centro = new Punto(origen_x, origen_y);
        this.radio = radio;
    }

    /**
     * Circle method that allows the user to create a circle introducing its
     * center as a point
     *
     * @param p
     * @param radio
     */
    public Circulo(Punto p, double radio) {
        if (radio < 0) {
            throw new IllegalArgumentException("El radio debe ser mayor o igual que 0");
        }
        this.centro = new Punto(p);
        this.radio = radio;
    }

    /**
     * Circle copy method where you can make the same circle from another
     *
     * @param c
     */
    public Circulo(Circulo c) {
        this.centro = c.centro;
        this.radio = c.radio;
    }

    public Punto getCentro() {
        return this.centro;
    }

    public double getRadio() {
        return this.radio;
    }

    public void setCentro(double x, double y) {
        this.centro = new Punto(x, y);
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * Method that calculates the area of a circle.
     *
     * @return
     */
    public double getArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }

    /**
     * Method that calculates the circumference of a circle.
     *
     * @return
     */
    public double getCircunferencia() {
        return Math.PI * this.radio * 2;
    }

    @Override
    public String toString() {
        return "Centro: " + this.centro + ", Radio: " + this.radio;
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
        final Circulo other = (Circulo) obj;
        if (Double.doubleToLongBits(this.radio) != Double.doubleToLongBits(other.radio)) {
            return false;
        }
        return Objects.equals(this.centro, other.centro);
    }

}


/*MAIN

        Circulo miCirculo = new Circulo(3, 4, 2.5);
        Circulo miCirculo2 = new Circulo(2, 4, 2.5);

        System.out.print("Circunferencia: ");
        System.out.printf("%1.2f", miCirculo.getCircunferencia());
        System.out.println(" u");
        System.out.println(miCirculo.equals(miCirculo2));
*/
