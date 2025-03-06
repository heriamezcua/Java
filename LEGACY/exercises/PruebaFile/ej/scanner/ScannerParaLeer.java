/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej.scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerParaLeer {

    public static void main(String[] args) {
        File fileNum = new File("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\numeros.txt");

        try {
            fileNum.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(ScannerParaLeer.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileNum));

            Scanner sc = new Scanner(br);

            int suma = 0;
            while (sc.hasNextLine()) {
                String sigLinea = sc.nextLine();
                System.out.println(sigLinea);
                suma += Integer.parseInt(sigLinea);
            }
            System.out.println("---");
            System.out.println(suma);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ScannerParaLeer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
