/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos1;

/**
 *
 * @author Heriberto Amezcua
 */
public class Punto {

    private double x, y;

    /**
     * Metodo que permite posicionar un punto en un espacio bidimensional en las
     * coordenadas x e y.
     *
     */
    public Punto() {
        this(0, 0);
    }

    /**
     * Metodo que permite posicionar un punto en un espacio bidimensional en las
     * coordenadas x e y.
     *
     * @param x
     * @param y
     */
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Metodo que permite copiar un punto.
     *
     * @param p
     */
    public Punto(Punto p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Metodo que devuelve la coordena x de un punto.
     *
     * @return
     */
    public double getX() {
        return this.x;
    }

    /**
     * Metodo que devuelve la coordena y de un punto.
     *
     * @return
     */
    public double getY() {
        return this.y;
    }

    /**
     * Metodo que pone la coordena x a un punto.
     *
     * @param x coordenada x de un punto
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Metodo que pone la coordena y a un punto.
     *
     * @param y coordenada y de un punto
     */
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(x=" + x + ", y=" + y + ")";
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
        final Punto other = (Punto) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        return Double.doubleToLongBits(this.y) == Double.doubleToLongBits(other.y);
    }

}

/* MAIN
        Punto p1= new Punto(2,3);
        Punto p2= new Punto(2,3);

        System.out.println(p2.equals(p1));
        p1.setX(12.43);
        p2.setY(-23.4);
        
        System.out.println(p1.getY());
        
        System.out.println("Punto 1: "+p1);
        System.out.println("Punto 2: "+p2);
 */
