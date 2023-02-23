/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaherencia;

/**
 *
 * @author amezc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Figura f = new Triangulo(1, 1);
        Triangulo t = new Triangulo(2, 2);
        Circulo c = new Circulo(2);
        
//        f.getBase();
        t.getColor();
        c.area();

        //POLIMORFISMO INVOCAR A DIFERENTES VERSIONES DE UN MISMO METODO
        System.out.println((Figura)c);
        System.out.println(t.area());
        System.out.println(f.area());
        
        //Tipos de retorno covariantes
        Triangulo tri= (Triangulo)t.getNewFigura();
    }

}
