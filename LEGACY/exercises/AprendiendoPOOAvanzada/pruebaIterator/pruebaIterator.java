/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ArrayList<Integer> listaEnteros = new ArrayList<>();
        listaEnteros.add(1);
        listaEnteros.add(-12);
        listaEnteros.add(1);
        listaEnteros.add(1);
        listaEnteros.add(1);

        for (int nombre : listaEnteros) {
            System.out.println(nombre);
        }

        Iterator<Integer> it = listaEnteros.iterator();

        while (it.hasNext()) {

            int numero = it.next();
            if (numero == 1) {
                it.remove();
            }
        }

        for (int nombre : listaEnteros) {
            System.out.println(nombre);
        }
    }
