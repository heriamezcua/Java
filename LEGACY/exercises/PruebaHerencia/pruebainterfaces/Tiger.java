/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainterfaces;

/**
 *
 * @author amezc
 */
public class Tiger implements Depredator, Prey {

    public int age;

    @Override
    public void cazar() {
        System.out.println("Tiger is hungry. Tiger hunt");
    }

    @Override
    public void huir() {
        System.out.println("A hunter is near. Tiger is runnig from the guns");
    }

}
