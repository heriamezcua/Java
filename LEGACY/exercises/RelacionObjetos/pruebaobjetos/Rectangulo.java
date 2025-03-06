/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaobjetos;

/**
 *
 * @author amezc
 */
public class Rectangulo {

    private int alto, ancho;
    private double base;
    private static int cantRectangulos;

    public Rectangulo(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;

        cantRectangulos++;
    }

    public void setAlto(int alto) {
        if (alto > 0) {
            this.alto = alto;
        }
    }

    public int getAlto() {
        return this.alto;
    }

    public void setAncho(int ancho) {
        if (ancho > 0) {
            this.ancho = ancho;
        }
    }

    public int getAncho() {
        return this.ancho;
    }

    public static int getNumRectangulos() {
        return Rectangulo.cantRectangulos;
    }

    public void setBase(int alto, int ancho) {
        if (alto > 0 && ancho > 0) {
            this.base = alto * ancho;
        }
    }

    public double getBase() {
        return this.base;
    }

}
