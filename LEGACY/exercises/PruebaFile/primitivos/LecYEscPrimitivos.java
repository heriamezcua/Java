/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primitivos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
public class LecYEscPrimitivos {

    public static void main(String[] args) {
        //Escritura de datos primitivos, no se entenderá nada de lo que escriba
        int[] notas = {5, 4, 3, 5, 5, 5, 7, 8, 12};
        try {
            DataOutputStream ds = new DataOutputStream(new FileOutputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\escribirPrimitivos"));
            for (int i = 0; i < notas.length; i++) {
                try {
                    ds.writeInt(notas[i]);
                } catch (IOException ex) {
                    Logger.getLogger(LecYEscPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ds.flush();
                ds.close();
            } catch (IOException ex) {
                Logger.getLogger(LecYEscPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecYEscPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Lectura de datos primitivos
        DataInputStream dis;
        try {
            dis = new DataInputStream(new FileInputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\escribirPrimitivos"));
            int i = 0;
            while (i < 9) {
                try {
                    System.out.println(dis.readInt());
                } catch (IOException ex) {
                    Logger.getLogger(LecYEscPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
                }
                i++;
            }
            try {
                dis.close();
            } catch (IOException ex) {
                Logger.getLogger(LecYEscPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LecYEscPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
