/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaobjetos;

/**
 * Clase que nos permite tener una tarjeta regalo y hacer algunas operaciones
 * con ellas.
 *
 * @version 1.0
 * @author Hoxuro
 * @since JDK 19
 */
public class TarjetaRegalo {

    public int numero, saldo;

    /**
     * Metodo que permite crear una tarjeta regalo con el saldo que el usuario
     * introduzca.
     *
     * @param saldo
     * @throws IllegalArgumentException si el saldo es negativo
     */
    public TarjetaRegalo(int saldo) {
        if (saldo <= 0) {
            throw new AssertionError("El saldo no puede ser negativo");
        }
        this.saldo = saldo;
        this.numero = (int) generarRandom();
    }

    private double generarRandom() {
        double numRandom = Math.random() * (99999 - 0) + 0;
        return numRandom;
    }

    @Override
    public String toString() {
        return "Tarjeta numero " + numero + " - Saldo " + saldo + " euros";
    }

    /**
     * Metodo que "gasta" el dinero de la tarjeta que se pone en gasto
     *
     * @param gasto el dinero que se quita de la tarjeta bancaria
     * @return
     * @throws IllegalArgumentException se el saldo es menor que el gasto
     */
    public String gasta(int gasto) {
        String operacion = (gasto > this.saldo)
                ? ("No tiene suficiente saldo para gastar " + gasto + " euros") : "Operacion aceptada";

        this.saldo -= (gasto > this.saldo) ? 0 : gasto;
        return operacion;
    }

    /**
     * Metodo que fusiona el dinero de dos tarjetas
     *
     * @param t la tarjeta que se fusiona con la otra
     * @return
     *
     */
    public TarjetaRegalo fusionaCon(TarjetaRegalo t) {
        TarjetaRegalo nueva = new TarjetaRegalo(this.saldo + t.saldo); //this. viene del objeto sobre el que aplicamos el metodo
        this.saldo = t.saldo = 0;

        return nueva;
    }

}

//        TarjetaRegalo tar1 = new TarjetaRegalo(300);
//        System.out.println(tar1);
//
//        TarjetaRegalo tar2 = new TarjetaRegalo(500);
//        System.out.println(tar2);
//
//        tar2.gasta(50);
//        TarjetaRegalo tar3 = tar1.fusionaCon(tar2);
//
//        System.out.println(tar3);
