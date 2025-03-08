/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaserializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializarPrimitivos {

    public static void main(String[] args) {

        int[] array = {1, 7, 4, 3, 8};

        //creo uno para guardar el array entero
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\arraySerializar"));
            os.writeObject(array);
            os.flush();
            os.close();
        } catch (IOException ex) {
            Logger.getLogger(SerializarPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        //creo otro para guardar los valores uno a uno
        try {
            ObjectOutputStream os2 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\arraySerializar2"));
            for (int i = 0; i < array.length; i++) {
                os2.writeInt(array[i]);
            }
            os2.flush();
            os2.close();
        } catch (IOException ex) {
            Logger.getLogger(SerializarPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        //leo el array
        try {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\arraySerializar"));
            try {
                int[] leerArray = (int[]) oi.readObject();
                for (int i = 0; i < leerArray.length; i++) {
                    System.out.println(leerArray[i]);
                }
                oi.close();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SerializarPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(SerializarPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

        //leo los valores uno a uno
        try {
            ObjectInputStream oi2 = new ObjectInputStream(new FileInputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\arraySerializar2"));

            for (int i = 0; i < 5; i++) {
                System.out.println(oi2.readInt());
            }
        } catch (IOException ex) {
            Logger.getLogger(SerializarPrimitivos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
