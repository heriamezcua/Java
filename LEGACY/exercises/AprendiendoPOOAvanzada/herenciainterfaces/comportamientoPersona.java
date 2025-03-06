/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package herenciainterfaces;

/**
 *
 * @author amezc
 */
public interface comportamientoPersona extends ojos, boca {

    //metodos heredados de la interfaz ojos
    @Override
    public default void abrir() {
        System.out.println("Abre los ojos");
    }

    @Override
    public default void guiñar() {
        System.out.println("Guiña los ojos");
    }

    @Override
    public default void pestañear() {
        System.out.println("Pestañea");
    }

    //metodos heredados de la interfaz boca
    @Override
    public default void comer() {
        System.out.println("Come");
    }

    @Override
    public default void morder() {
        System.out.println("Muerde");
    }

    @Override
    public default void sonreir() {
        System.out.println("Sonríe");
    }

}
