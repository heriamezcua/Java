/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package binarios;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amezc
 */
public class LecYEscBinarios {

    public static void main(String[] args) {

        //Escritura de ficheros en binario
        byte[] data = "Cadena de texto a guardar".getBytes();

        try {
            BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\escBinario.dat"));
            try {
                bf.write(data);
                bf.flush();
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(LecYEscBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecYEscBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Lectura de ficheros en binario
        try {
            BufferedInputStream bif = new BufferedInputStream(new FileInputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\escBinario.dat"));
            byte[] byteArray = new byte[50];
            int tam;
            try {
                while ((tam = bif.read(byteArray)) != -1) {
                    System.out.println(new String(byteArray, 0, tam));
                }
                bif.close();
            } catch (IOException ex) {
                Logger.getLogger(LecYEscBinarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecYEscBinarios.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
