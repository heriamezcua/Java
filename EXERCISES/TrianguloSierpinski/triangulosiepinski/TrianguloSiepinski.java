/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangulosiepinski;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author amezc
 */
public class TrianguloSiepinski {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MarcoConDibujos miMarco = new MarcoConDibujos();
        miMarco.setVisible(true);
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}

class MarcoConDibujos extends JFrame {

    public MarcoConDibujos() {
        setTitle("Triangulo de Siepinski");
        setSize(1500, 1500);
        LaminaConPuntos miLamina = new LaminaConPuntos();
        add(miLamina);
    }
}

class LaminaConPuntos extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int n= Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad de puntos a realizar"));
        int[] puntoAleatorio = new int[2];
        int[] punto1 = {250, 0};
        int[] punto2 = {750, 0};
        int[] punto3 = {500, 500};

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                int random = funciones.Calcular.calcRandomInt(1, 3);
                switch (random) {
                    case 1:
                        puntoAleatorio[0] = (punto1[0] + punto2[0]) / 2;
                        puntoAleatorio[1] = (punto1[1] + punto2[1]) / 2;
                        break;
                    case 2:
                        puntoAleatorio[0] = (punto2[0] + punto3[0]) / 2;
                        puntoAleatorio[1] = (punto2[1] + punto3[1]) / 2;
                        break;
                    case 3:
                        puntoAleatorio[0] = (punto1[0] + punto3[0]) / 2;
                        puntoAleatorio[1] = (punto1[1] + punto3[1]) / 2;
                        break;
                }

                g.drawLine(puntoAleatorio[0], puntoAleatorio[1], puntoAleatorio[0], puntoAleatorio[1]);
            } else {
                int random = funciones.Calcular.calcRandomInt(1, 3);
                switch (random) {
                    case 1:
                        puntoAleatorio[0] = (punto1[0] + puntoAleatorio[0]) / 2;
                        puntoAleatorio[1] = (punto1[1] + puntoAleatorio[1]) / 2;
                        break;
                    case 2:
                        puntoAleatorio[0] = (punto2[0] + puntoAleatorio[0]) / 2;
                        puntoAleatorio[1] = (punto2[1] + puntoAleatorio[1]) / 2;
                        break;
                    case 3:
                        puntoAleatorio[0] = (punto3[0] + puntoAleatorio[0]) / 2;
                        puntoAleatorio[1] = (punto3[1] + puntoAleatorio[1]) / 2;
                        break;
                }
                g.drawLine(puntoAleatorio[0], puntoAleatorio[1], puntoAleatorio[0], puntoAleatorio[1]);
            }

        }
    }

}
