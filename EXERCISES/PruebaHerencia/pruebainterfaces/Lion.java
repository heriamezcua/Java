/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainterfaces;

/**
 *
 * @author amezc
 */
public class Lion implements Depredator {

    private int age;

    @Override
    public void cazar() {
        System.out.println("Lion is hungry. Lion hunt");
    }

    @Override
    public String toString() {
        return "Age=" + age;
    }

}
