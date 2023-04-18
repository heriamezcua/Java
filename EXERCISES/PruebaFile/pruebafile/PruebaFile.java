/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebafile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaFile {

    public static void main(String[] args) {
        File fileDatos = new File("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\datos.txt");

        if (fileDatos.exists()) {
            try {
                BufferedReader bf = new BufferedReader(new FileReader(fileDatos));
                try {
                    String cadena = "";
                    while ((cadena = bf.readLine()) != null) {
                        System.out.println(cadena);
                    }

                } catch (IOException ex) {
                    Logger.getLogger(PruebaFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(PruebaFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
