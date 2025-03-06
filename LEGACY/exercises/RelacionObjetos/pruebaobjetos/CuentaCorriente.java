/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaobjetos;

/**
 * Esta clase representa una cuenta corriente. Es una version inicial
 *
 * @author DAW-B
 * @since JDK1.0
 * @see C
 */
public class CuentaCorriente {

    private long numero;
    private double saldo;

    public CuentaCorriente() {
        this.numero = generarRandom();
        this.saldo = 0;
    }

    /**
     * Construye el objeto cuenta corriente a traves de su saldo. Se construirá
     * un objeto
     *
     * @param saldo
     */
    public CuentaCorriente(double saldo) {
        this.numero = generarRandom();
        this.saldo = saldo;
    }

    private long generarRandom() {
        long numInicial = 1L;
        long numFinal = 9999999999L;
        return (long) (Math.random() * (numFinal - numInicial) + numInicial);
    }

    private String imprimirNumero(long numero) {
        int cifras = (numero + "").length();
        String cero = "0";

        return (cero.repeat(10 - cifras) + numero);
    }

    @Override
    public String toString() {
        return "Numero de cta: " + imprimirNumero(numero) + " Saldo: " + saldo + " euros";
    }

    public String ingresar(double dinero) {
        if (dinero <= 0) {
            throw new AssertionError("No se puede ingresar dinero negativo");
        }

        this.saldo += dinero;

        return "Se han ingresado " + dinero + " euros";
    }

    public String gastar(double dinero) {
        if (dinero <= 0) {
            throw new AssertionError("No se puede gastar dinero negativo");
        }

        this.saldo -= dinero;

        return "Se ha gastado " + dinero + " euros";
    }

    public void transferencia(CuentaCorriente cuenta, double dinero) {
        if (dinero <= 0) {
            throw new AssertionError("El saldo no puede ser nulo o negativo");
        }

        cuenta.saldo += dinero;
        this.saldo -= dinero;
    }

}
