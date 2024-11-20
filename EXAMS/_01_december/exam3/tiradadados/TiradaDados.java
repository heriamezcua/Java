/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package _01_december.exam3.tiradadados;

/**
 *
 * @author DAW-B
 */
public class TiradaDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] array = {2, 3, 3, 3, 1};
        System.out.println(contarCaras(array));
    }

    public static int contarCaras(int[] valoresTiradas) {
        int[] cantRepeticiones = new int[6];
        int[] posiblesSalidas = {0, 0, 0, 0};
        int salida = 0;
        boolean parar = false;

        if (valoresTiradas.length > 5) {
            salida = -1;
            parar = true;
        }

        for (int elemento : valoresTiradas) {
            if (elemento < 1 || elemento > 6) {
                salida = -1;
                parar = true;
            }
        }

        for (int elemento : valoresTiradas) {
            switch (elemento) {
                case 1:
                    cantRepeticiones[0] += 1;
                    break;
                case 2:
                    cantRepeticiones[1] += 1;
                    break;
                case 3:
                    cantRepeticiones[2] += 1;
                    break;
                case 4:
                    cantRepeticiones[3] += 1;
                    break;
                case 5:
                    cantRepeticiones[4] += 1;
                    break;
                case 6:
                    cantRepeticiones[5] += 1;
                    break;
            }
        }

        for (int elemento : cantRepeticiones) {
            switch (elemento) {
                case 2:
                    posiblesSalidas[0] += 1;
                    break;
                case 3:
                    posiblesSalidas[1] += 1;
                    break;
                case 4:
                    posiblesSalidas[2] += 1;
                    break;
                case 5:
                    posiblesSalidas[3] += 1;
                    break;
            }
        }

        for (int elemento = 3; elemento >= 0; elemento--) {
            if (elemento == 3 && posiblesSalidas[elemento] != 0 && !parar) {
                salida = 6;
                parar = true;
            }
            if (elemento == 2 && posiblesSalidas[elemento] != 0 && !parar) {
                salida = 5;
                parar = true;
            }
            if (elemento == 1 && posiblesSalidas[elemento] != 0 && posiblesSalidas[elemento - 1] != 0 && !parar) {
                salida = 4;
                parar = true;
            }
            if (elemento == 1 && posiblesSalidas[elemento] != 0 && !parar) {
                salida = 3;
                parar = true;
            }
            if (elemento == 0 && posiblesSalidas[elemento] == 2 && !parar) {
                salida = 2;
                parar = true;
            }
            if (elemento == 0 && posiblesSalidas[elemento] != 0 && !parar) {
                salida = 1;
            }
        }

        return salida;
    }
}
