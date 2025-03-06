/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escritura.ficheros;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amezc
 */
public class PruebaEscritura {

    public static void main(String[] args) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\saludo.txt"));
            bw.write("");
            bw.close();

        } catch (IOException ex) {
            Logger.getLogger(PruebaEscritura.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
