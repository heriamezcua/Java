/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaexcepciones;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaExcepciones {

    public static void main(String[] args) {

        try {
            //como vemos nos puede lanzar excepcion ya que puede o no existir el archivo
            FileReader fr = new FileReader("info.txt");
        } catch (FileNotFoundException ex) {
            System.out.println("No se ha encontrado el archivo");
        }

        try {
            metodoExcepcion(2, 0);
        } catch (MiExcepcion ex) {
            Logger.getLogger(PruebaExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoMarcada ex) {
            Logger.getLogger(PruebaExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static double metodoExcepcion(int a, int b) throws MiExcepcion {

        //PODRÍA HACER ESTO PERFECTAMENTE PERO PARA TENER UN CODIGO MÀS LIMPIO SE HACE EL THROWS
//        try {
//            FileWriter fw = new FileWriter("info.txt");
//        } catch (IOException ex) {
//            Logger.getLogger(PruebaExcepciones.class.getName()).log(Level.SEVERE, null, ex);
//        }
        if (a == 1) {
            throw new NoMarcada();
        }
        if (b == 0) {
            throw new MiExcepcion();

        }

        return a / b;

    }

}
