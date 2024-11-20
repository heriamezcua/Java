/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _02_february.exam1.conjunto;

/**
 *
 * @author amezc
 */
public class Conjunto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConjuntoOrdenadoEnteros c = new ConjuntoOrdenadoEnteros(10);
        c.add(12);
        c.add(7);
        c.add(6);
        c.add(7);
        c.add(4);
        c.add(8);
        displayArray(c.getConjunto());
        c.del(1);
        displayArray(c.getConjunto());
        ConjuntoOrdenadoEnteros t = c.subconjunto(2, 4);
        System.out.println(c.search(4));
        displayArray(t.getConjunto());

    }

    /**
     * Prints in screen your array of integer numbers.
     *
     * @param array the array you want to print on screen.
     */
    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

}
