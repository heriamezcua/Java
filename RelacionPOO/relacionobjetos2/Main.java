/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionobjetos2;

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
        Cancion c1 = new Cancion("Titi me pregunto", "Bad Bunny");
        Cancion c2 = new Cancion("Aguacero", "Bad Bunny");
        Cancion c3 = new Cancion("Me porto bonito", "Bad Bunny");
        Cancion c4 = new Cancion("Ojitos lindos", "Bad Bunny");
        Cancion c5 = new Cancion("Party", "Bad Bunny");

        System.out.println("Cancion 1: " + c1);

        System.out.println(c1.getTitulo());
        System.out.println(c1.getAutor());

        Album unVeranoSinTi = new Album();

        unVeranoSinTi.agrega(c1);
        unVeranoSinTi.agrega(c2);
        unVeranoSinTi.agrega(c3);
        unVeranoSinTi.agrega(c4);
        unVeranoSinTi.agrega(c5);

        for (int i = 1; i <= unVeranoSinTi.numeroCanciones(); i++) {
            System.out.println("Cancion " + i + " " + unVeranoSinTi.dameCancion(i));
        }

        System.out.println("Total canciones: " +unVeranoSinTi.numeroCanciones());

    }

}
