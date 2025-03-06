/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosmatrices1;

/**
 *
 * @author amezc
 */
public class Ejercicio08 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[][] tablero = rellenarTablero(9, 9);
        System.out.println(printTablero(tablero));
    }

    public static String[][] rellenarTablero(int filas, int columnas) {
        String[][] tablero = new String[filas][columnas];
        int colPos = funciones.Calcular.calcRandomInt(1, 8);
        int filaPos = funciones.Calcular.calcRandomInt(1, 8);

        ponerCasillas(tablero);
        ponerNumeros(tablero);
        targetPosition(tablero, colPos, filaPos);
        ponerAlfil(tablero, colPos, filaPos);

        return tablero;
    }

    public static String[][] targetPosition(String[][] tuTablero, int tuColPos, int tuFilaPos) {
        String[][] tablero = tuTablero;
        int filaPos= tuFilaPos;
        int colPos= tuColPos;

        for (int fila = 1; fila < tablero.length; fila++) {
            for (int columna = 1; columna < tablero.length; columna++) {
                if((fila+columna)==(filaPos+colPos)){
                    tablero[fila][columna]= " ";
                }else if(columna-fila== colPos-filaPos){
                    tablero[fila][columna]= " ";
                }
            }
        }
        
        return tablero;

    }

    public static String[][] ponerCasillas(String[][] tuTablero) {
        String[][] tablero = tuTablero;

        for (int fila = 1; fila < tablero.length; fila++) {
            for (int columna = 1; columna < tablero.length; columna++) {
                tablero[fila][columna] = "#";
            }
        }

        return tablero;
    }

    public static String[][] ponerNumeros(String[][] tuTablero) {
        String[][] tablero = tuTablero;

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero.length; columna++) {
                if (fila == 0) {
                    switch (columna) {
                        case 0:
                            tablero[fila][columna] = " ";
                            break;
                        case 1:
                            tablero[fila][columna] = "a ";
                            break;
                        case 2:
                            tablero[fila][columna] = "b";
                            break;
                        case 3:
                            tablero[fila][columna] = "c ";
                            break;
                        case 4:
                            tablero[fila][columna] = "d";
                            break;
                        case 5:
                            tablero[fila][columna] = "e ";
                            break;
                        case 6:
                            tablero[fila][columna] = "f";
                            break;
                        case 7:
                            tablero[fila][columna] = "g";
                            break;
                        case 8:
                            tablero[fila][columna] = "h";
                            break;
                        default:
                            throw new AssertionError();
                    }
                } else if (columna == 0) {
                    switch (fila) {
                        case 0:
                            tablero[fila][columna] = " ";
                            break;
                        case 1:
                            tablero[fila][columna] = "8";
                            break;
                        case 2:
                            tablero[fila][columna] = "7";
                            break;
                        case 3:
                            tablero[fila][columna] = "6";
                            break;
                        case 4:
                            tablero[fila][columna] = "5";
                            break;
                        case 5:
                            tablero[fila][columna] = "4";
                            break;
                        case 6:
                            tablero[fila][columna] = "3";
                            break;
                        case 7:
                            tablero[fila][columna] = "2";
                            break;
                        case 8:
                            tablero[fila][columna] = "1";
                            break;
                        default:
                            throw new AssertionError();
                    }
                }
            }
        }

        return tablero;
    }

    public static String[][] ponerAlfil(String[][] tuTablero, int tuColPos, int tuFilaPos) {
        String[][] tablero = tuTablero;
        int filaPos = tuFilaPos;
        int colPos = tuColPos;

        for (int fila = 1; fila < tablero.length; fila++) {
            for (int columna = 1; columna < tablero.length; columna++) {
                if (fila == filaPos && columna == colPos) {
                    tablero[fila][columna] = "\u265D";
                }
            }
        }

        return tablero;

    }

    public static String printTablero(String[][] tuTablero) {
        String[][] tablero = tuTablero;
        String outputMessage = "";

        for (int fila = 0; fila < tablero.length; fila++) {
            for (int columna = 0; columna < tablero[fila].length; columna++) {
                if (columna + 1 == tablero[fila].length) {
                    outputMessage += tablero[fila][columna] + " " + "\n";
                } else {
                    outputMessage += tablero[fila][columna] + " ";
                }
            }
        }

        return outputMessage;
    }

}
