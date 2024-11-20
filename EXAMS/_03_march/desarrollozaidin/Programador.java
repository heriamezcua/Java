package _03_march.desarrollozaidin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import funciones.*;

/**
 *
 * @author DAW-B
 */
public class Programador extends Empleado {

    private String lenguajeProgramacion;
    private int plus, numProyectosTrabaja;

    public Programador(String nombre, String apellido1, String apellido2, double salarioBase, int antiguedad,
            String lenguajeProgramacion, int plus, int numProyectosTrabaja) {
        super(nombre, apellido1, apellido2, salarioBase, antiguedad);

        if (!ValidarDatos.validarTitulo(lenguajeProgramacion)) {
            throw new IllegalArgumentException("El lenguaje de programación no puede estár vacío.");
        }

        boolean esValido = false;
        for (Lenguajes lenguaje : Lenguajes.values()) {
            if (lenguaje.lenguaje.equals(ValidarDatos.toTitleCase(lenguajeProgramacion))) {
                esValido = true;
            }
        }
        if (!esValido) {
            throw new IllegalArgumentException("La empresa no trabaja con ese lenguaje de programación");
        }
        if (plus < 0) {
            throw new IllegalArgumentException("No puede haber pluses negativos.");
        }
        if (numProyectosTrabaja < 0) {
            throw new IllegalArgumentException("El numero de proyectos no puede ser negativo.");
        }

        this.lenguajeProgramacion = lenguajeProgramacion;
        this.plus = plus;
        this.numProyectosTrabaja = numProyectosTrabaja;
    }

    public String getLenguajeProgramacion() {
        return lenguajeProgramacion;
    }

    public void setLenguajeProgramacion(String lenguajeProgramacion) {
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    public int getPlus() {
        return plus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }

    public int getNumProyectosTrabaja() {
        return numProyectosTrabaja;
    }

    public void setNumProyectosTrabaja(int numProyectosTrabaja) {
        this.numProyectosTrabaja = numProyectosTrabaja;
    }

    @Override
    public String toString() {
        return super.toString() + "\nLenguaje de programación= " + lenguajeProgramacion + ", plus= " + plus + ", Proyectos en los que trabaja= " + numProyectosTrabaja;
    }

    @Override
    public double calcularSalario() {
        double salarioFinal = this.getSalario();
        salarioFinal += this.numeroTrienios() * 100;
        salarioFinal += plus;

        return salarioFinal;
    }

}
