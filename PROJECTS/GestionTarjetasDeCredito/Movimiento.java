/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontarjetascredito;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * Clase que permite crear una transaccion bancaria.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 11.0.17
 */
final class Movimiento {

    private double cantidad;
    private String concepto;
    private Date fecha;

    /**
     * Metodo constructor donde El usuario introduce la cantidad a transferir y
     * el concepto a mostrar y si ambos parametros son validos se instanciará un
     * objeto con esos valores para sus atributos.
     *
     * @param cantidad la cantidad de dinero a transferir.
     * @param concepto el mensaje a mostrar para el receptor.
     * @throws IllegalArgumentException si la cantidad a transferir es negativa
     * o nula.
     * @throws IllegalArgumentException si el concepto es demasiado largo.
     */
    public Movimiento(double cantidad, String concepto) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de la transferencia no puede ser negativa o nula.");
        }
        if (!Pattern.matches(".{0,50}", concepto)) {
            throw new IllegalArgumentException("El concepto es demasiado largo.");
        }

        this.cantidad = cantidad;
        this.concepto = concepto;
        this.fecha = new Date();
    }

    /**
     * Metodo constructor copia que instancia una clase movimiento con los
     * mismos atributos que la introducida por parametro.
     *
     * @param m objeto de la clase Movimiento.
     */
    public Movimiento(Movimiento m) {
        this.cantidad = m.cantidad;
        this.concepto = m.concepto;
    }

    /**
     * Metodo getter que te devuelve la cantidad a transferir de ese movimiento.
     *
     * @return la cantidad de dinero a transferir de ese movimiento
     */
    public double getCantidad() {
        return this.cantidad;
    }

    /**
     * Metodo getter que te devuelve el concepto de ese movimiento.
     *
     * @return el concepto de ese movimiento
     */
    public String getConcepto() {
        return this.concepto;
    }

    /**
     * Metodo getter que te devuelve la fecha de transferencia de ese
     * movimiento.
     *
     * @return la fecha de transferencia del movimiento.
     */
    public Date getFecha() {
        return this.fecha;
    }

    /**
     * Metodo setter que valida si el concepto es valido antes de establecerselo
     * al ese movimiento.
     *
     * @param concepto el concepto a mostrar de ese movimiento
     * @throws IllegalArgumentException si el concepto es mayor a 50 caracteres
     */
    public void setConcepto(String concepto) {
        if (!Pattern.matches(".{0,50}", concepto)) {
            throw new IllegalArgumentException("El concepto no puede tener mas de 50 caractres.");
        }
        this.concepto = concepto;
    }

    @Override
    public String toString() {
        return "Cantidad tranferida= " + cantidad + " €, Concepto= " + concepto + ", Fecha de transferencia= " + fecha;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimiento other = (Movimiento) obj;
        if (Double.doubleToLongBits(this.cantidad) != Double.doubleToLongBits(other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.concepto, other.concepto)) {
            return false;
        }
        return Objects.equals(this.fecha, other.fecha);
    }

}

/*PRUEBAS MAIN
        Movimiento m1 = new Movimiento(1500, "Paga extra navidenia");
        Movimiento m2 = new Movimiento(1500, "Paga extra navidenia");

        System.out.println(m1.equals(m2));
        System.out.println(m1.getCantidad());
        System.out.println(m1.getConcepto());
        m2.setConcepto("Hola que ase");
        System.out.println(m1.getFecha());
        System.out.println(m2.getConcepto());
        System.out.println(m1);
 */
