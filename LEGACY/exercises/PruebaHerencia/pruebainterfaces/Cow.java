/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainterfaces;

/**
 *
 * @author amezc
 */
public class Cow implements Prey {

    private int age;

    @Override
    public void huir() {
        System.out.println("Cow is being hunted. Cow is running for its life");
    }

    @Override
    public String toString() {
        return "Age=" + age;
    }
}
