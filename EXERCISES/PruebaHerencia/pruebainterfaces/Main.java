/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebainterfaces;

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

        Lion l = new Lion();
        Cow c = new Cow();
        Tiger t = new Tiger();
        
        l.cazar();
        c.huir();
        System.out.println(Prey.SALVA);
        t.cazar();
        t.huir();
        System.out.println(Depredator.KILL);
    }

}
