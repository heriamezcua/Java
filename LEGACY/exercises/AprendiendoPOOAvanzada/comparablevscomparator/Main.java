/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comparablevscomparator;

import java.util.ArrayList;
import java.util.Collections;

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
        Persona p1 = new Persona("José", 12);
        Persona p2 = new Persona("Antonio", 13);
        Persona p3 = new Persona("Miguel", 22);
        Persona p4 = new Persona("Rosa", 23);

        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(p1);
        listaPersonas.add(p2);
        listaPersonas.add(p3);
        listaPersonas.add(p4);

        //compruebo que la ordenacion natural es el valor numerico del primer 
        //caracter del nombre
        System.out.println(listaPersonas);

        Collections.sort(listaPersonas);
        System.out.println(listaPersonas);

        OrdenarPersonasEdad ordenarEdad = new OrdenarPersonasEdad();
        Collections.sort(listaPersonas, ordenarEdad);

        //ahora compruebo la ordenacion no natural. En este caso, los que tienen
        //edad par iran primero que los que tienen edad impar
        System.out.println(listaPersonas);
    }

}
