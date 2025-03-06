/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebainstanceof;

/**
 *
 * @author amezc
 */
public class Main {

    public static void main(String[] args) {
        Figura f = new Triangulo(3.2, 7.4);

        System.out.println("¿La figura es un circulo?");
        System.out.println(f instanceof Circulo);

        System.out.println("¿La figura es un Triangulo?");
        System.out.println(f instanceof Triangulo);

    }

}
