/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegotresenraya;

/**
 *
 * @author amezc
 */
public class Tablero {

    public static final String RESALTAR_ROJO = "\u001B[31m";
    public static final String RESETEAR_COLOR = "\u001B[0m";
    
    /**
     * Method that print in screen the current state of the game in a 'fancy'
     * way.
     *
     * @param partida the current game
     */
    public static void mostrarTablero(TresEnRaya partida) {
        String fichaAPintar = "";

        for (int filaTablero = 0; filaTablero < partida.getTablero().length; filaTablero++) {
            System.out.print((" ---").repeat(partida.getTablero().length) + "\n");
            for (int columnaTablero = 0; columnaTablero < partida.getTablero()[filaTablero].length; columnaTablero++) {
                fichaAPintar = sacarFicha(partida, filaTablero, columnaTablero);
                construirCasilla(partida, filaTablero, columnaTablero, fichaAPintar);
            }
        }
        System.out.print((" ---").repeat(partida.getTablero().length) + "\n");

    }

    /**
     * Method that print in screen the current state of the game in a 'fancy'
     * way and the last token is highlight in red.
     *
     * @param partida the current game
     */
    public static void mostrarTablero(TresEnRaya partida, int fila, int columna) {
        String fichaAPintar = "";

        for (int filaTablero = 0; filaTablero < partida.getTablero().length; filaTablero++) {
            System.out.print((" ---").repeat(partida.getTablero().length) + "\n");
            for (int columnaTablero = 0; columnaTablero < partida.getTablero()[filaTablero].length; columnaTablero++) {
                fichaAPintar = sacarFicha(partida, filaTablero, columnaTablero);

                //lo unico que diferencia a las dos funciones mostrarTablero es esta linea de codigo que "resalta" la ficha de color rojo
                fichaAPintar = (fila == filaTablero && columna == columnaTablero) ? RESALTAR_ROJO + fichaAPintar + RESETEAR_COLOR : fichaAPintar;
                construirCasilla(partida, filaTablero, columnaTablero, fichaAPintar);
            }
        }
        System.out.print((" ---").repeat(partida.getTablero().length) + "\n");
    }

    /**
     * Method that calculates if we need and x or y token.
     *
     * @param partida our current game.
     * @param filaTablero the row of the token we want to print
     * @param columnaTablero the column of the token we want to print
     * @return the token we need to print
     */
    public static String sacarFicha(TresEnRaya partida, int filaTablero, int columnaTablero) {
        String fichaAPintar = "";

        switch (partida.getTablero()[filaTablero][columnaTablero]) {
            case TresEnRaya.FICHA_CIRCULO:
                fichaAPintar = "O";
                break;
            case TresEnRaya.FICHA_EQUIS:
                fichaAPintar = "X";
                break;
            default:
                fichaAPintar = " ";
                break;
        }

        return fichaAPintar;
    }

    /**
     * Method that create a board square.
     *
     * @param partida our current tic-tac-toe game.
     * @param filaTablero the row of the board that we want to build
     * @param columnaTablero the column of the board that we want to build
     * @param fichaAPintar the token we want to print
     */
    public static void construirCasilla(TresEnRaya partida, int filaTablero, int columnaTablero, String fichaAPintar) {

        if (columnaTablero + 1 == partida.getTablero()[filaTablero].length) {
            System.out.print(" " + fichaAPintar + " |\n");

        } else if (columnaTablero == 0) {
            System.out.print("| " + fichaAPintar + " |");

        } else {
            System.out.print(" " + fichaAPintar + " |");

        }

    }
}
