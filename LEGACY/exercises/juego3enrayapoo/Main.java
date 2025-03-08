/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegotresenraya;

import java.util.Arrays;

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

        TresEnRaya currentGame = new TresEnRaya();
        int player1, player2, x, y, ficha = 2;
        String namePlayer1 = LeerDatosTeclado.enterString("Jugador 1. Introduce tu nombre: ");
        String namePlayer2 = LeerDatosTeclado.enterString("Jugador 2. Introduce tu nombre");
        String currentPlayer = "";

        Tablero.mostrarTablero(currentGame);
        do {

            ficha = (ficha == 1) ? 2 : 1;
            currentPlayer = (ficha == 1) ? namePlayer1 : namePlayer2;
            System.out.println("------------------------------");
            System.out.println(currentPlayer + " te toca");

            do {
                x = LeerDatosTeclado.enterInt("Introduce fila (1 al 3):")-1;
                y = LeerDatosTeclado.enterInt("Introduce columna (1 al 3):")-1;

            } while (!currentGame.colocarFicha(ficha, x, y));

            Tablero.mostrarTablero(currentGame, x, y);

        } while (!currentGame.juegoTerminado() && !currentGame.hayGanador());

        if (currentGame.hayGanador()) {
            System.out.println("Enhorabuena " + currentPlayer + " has ganado!!");
        }

        if (currentGame.juegoTerminado()) {
            System.out.println("Tablas. Todas las casillas estan llenas");
        }

    }

}
