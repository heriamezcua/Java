package _03_march.desarrollozaidin;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW-B
 */
public class Comercial extends Empleado {

    ZonaVenta zonaVenta;
    int numVentas;

    public Comercial(String nombre, String apellido1, String apellido2, double salario, int antiguedad,
            ZonaVenta zonaVenta, int numVentas) {
        super(nombre, apellido1, apellido2, salario, antiguedad);

        this.zonaVenta = zonaVenta;
        if (numVentas < 0) {
            throw new IllegalArgumentException("El numero de ventas no puede ser negativo.");
        }
        this.numVentas = numVentas;
    }

    public ZonaVenta getZonaVenta() {
        return zonaVenta;
    }

    public void setZonaVenta(ZonaVenta zonaVenta) {
        for (ZonaVenta z : ZonaVenta.values()) {
            if (z.equals(zonaVenta)) {
                this.zonaVenta = z;
            }
        }
        this.zonaVenta = zonaVenta;
    }

    public int getNumVentas() {
        return numVentas;
    }

    public void setNumVentas(int numVentas) {
        if (numVentas >= 0) {
            this.numVentas = numVentas;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\nZona de venta= " + zonaVenta + ", Número de ventas= " + numVentas;
    }

    @Override
    public double calcularSalario() {
        double salarioFinal = this.getSalario();
        salarioFinal += this.numeroTrienios() * 100;

        if (numVentas >= 10) {
            salarioFinal += salarioFinal * 0.15;
        } else if (numVentas > 5) {
            salarioFinal += salarioFinal * 0.1;
        }

        return salarioFinal;
    }

}
