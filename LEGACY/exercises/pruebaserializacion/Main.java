/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebaserializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        int cargarPartida = ReadKBData.enterInt("1.Cargar partida  2.No hacerlo");
        if (cargarPartida == 1) {
            try {
                ObjectInputStream os = new ObjectInputStream(new FileInputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\tresEnRaya\\tresEnRaya.dat"));
                try {
                    TresEnRaya currentGame = (TresEnRaya) os.readObject();
                    int x, y, ficha = 2;
                    String player1 = enterString("Jugador 1. Introduce tu nombre: ");
                    String player2 = enterString("Jugador 2. Introduce tu nombre");
                    String currentPlayer = "";

                    Tablero.mostrarTablero(currentGame);
                    do {

                        ficha = (ficha == 1) ? 2 : 1;
                        currentPlayer = (ficha == 1) ? player1 : player2;
                        System.out.println("------------------------------");
                        System.out.println(currentPlayer + " te toca");

                        do {
                            x = enterInt("Introduce fila (1 al 3):") - 1;
                            y = enterInt("Introduce columna (1 al 3):") - 1;

                        } while (!currentGame.colocarFicha(ficha, x, y));

                        int guardar = ReadKBData.enterInt("Guardar la partida: 1.Si  2.No");
                        if (guardar == 1) {
                            try {
                                ObjectOutputStream os3 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\tresEnRaya\\tresEnRaya.dat"));
                                os3.writeObject(currentGame);
                                os3.flush();
                                os3.close();
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        Tablero.mostrarTablero(currentGame, x, y);

                    } while (!currentGame.juegoTerminado() && !currentGame.hayGanador());

                    if (currentGame.hayGanador()) {
                        System.out.println("¡¡Enhorabuena " + currentPlayer + " has ganado!!");
                    }

                    if (currentGame.juegoTerminado()) {
                        System.out.println("Tablas. Todas las casillas estan llenas");
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            TresEnRaya currentGame = new TresEnRaya();
            int x, y, ficha = 2;
            String player1 = enterString("Jugador 1. Introduce tu nombre: ");
            String player2 = enterString("Jugador 2. Introduce tu nombre");
            String currentPlayer = "";

            Tablero.mostrarTablero(currentGame);
            do {

                ficha = (ficha == 1) ? 2 : 1;
                currentPlayer = (ficha == 1) ? player1 : player2;
                System.out.println("------------------------------");
                System.out.println(currentPlayer + " te toca");

                do {
                    x = enterInt("Introduce fila (1 al 3):") - 1;
                    y = enterInt("Introduce columna (1 al 3):") - 1;

                } while (!currentGame.colocarFicha(ficha, x, y));

                int guardar = ReadKBData.enterInt("Guardar la partida: 1.Si  2.No");
                if (guardar == 1) {
                    try {
                        ObjectOutputStream os3 = new ObjectOutputStream(new FileOutputStream("C:\\Users\\amezc\\OneDrive\\Documentos\\javaFicheros\\tresEnRaya\\tresEnRaya.dat"));
                        os3.writeObject(currentGame);
                        os3.flush();
                        os3.close();
                        System.exit(0);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                Tablero.mostrarTablero(currentGame, x, y);

            } while (!currentGame.juegoTerminado() && !currentGame.hayGanador());

            if (currentGame.hayGanador()) {
                System.out.println("¡¡Enhorabuena " + currentPlayer + " has ganado!!");
            }

            if (currentGame.juegoTerminado()) {
                System.out.println("Tablas. Todas las casillas estan llenas");
            }
        }

    }

    /**
     * Method that asks the user to enter an integer type number and also
     * validates it.
     *
     * @param message the message that we want to display on the screen before
     * requesting the number.
     * @return a valid integer.
     */
    private static int enterInt(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNextInt()) {
            do {
                System.out.println("Por favor, introduzca correctamente!");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }

    /**
     * Method that asks the user to enter an String type data and also validates
     * it.
     *
     * @param message the message that we want to display on the screen before
     * requesting the String.
     * @return a valid String.
     */
    private static String enterString(String message) {
        Scanner input = new Scanner(System.in);

        //remember that you can change the delimiter
        System.out.println(message);

        if (!input.hasNext()) {
            do {
                System.out.println("Por favor, introduzca correctamente!");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNext());
        }

        return input.next();
    }

}
