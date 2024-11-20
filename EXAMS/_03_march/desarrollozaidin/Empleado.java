package _03_march.desarrollozaidin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import funciones.*;
import java.util.Objects;

/**
 *
 * @author DAW-B
 */
public abstract class Empleado implements Comparable<Empleado> {

    private String nombre, apellido1, apellido2;
    private double salario;
    private int antiguedad;

    public Empleado(String nombre, String apellido1, String apellido2, double salario, int antiguedad) {
        if (!ValidarDatos.validarNombrePersona(nombre)) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
        if (!ValidarDatos.validarNombrePersona(apellido1)) {
            throw new IllegalArgumentException("El primer apellido no es válido.");
        }
        if (!ValidarDatos.validarNombrePersona(apellido2)) {
            throw new IllegalArgumentException("El segundo apellido no es válido.");
        }
        if (salario < 1000) {
            throw new IllegalArgumentException("El salario base no puede ser inferior al SMI");
        }
        if (antiguedad < 0) {
            throw new IllegalArgumentException("La antigÜedad en la empresa no puede ser negativa");
        }

        this.nombre = nombre.trim().replaceAll("\\s+{2,}", " ");
        this.apellido1 = apellido1.trim().replaceAll("\\s+{2,}", " ");
        this.apellido2 = apellido2.trim().replaceAll("\\s+{2,}", " ");
        this.salario = salario;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (ValidarDatos.validarNombrePersona(nombre)) {
            this.nombre = nombre.trim().replaceAll("\\s+{2,}", " ");
        }
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        if (ValidarDatos.validarNombrePersona(apellido1)) {
            this.apellido1 = apellido1.trim().replaceAll("\\s+{2,}", " ");
        }
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        if (ValidarDatos.validarNombrePersona(apellido2)) {
            this.apellido2 = apellido2.trim().replaceAll("\\s+{2,}", " ");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 1000) {
            this.salario = salario;
        }
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        if (antiguedad < 0) {
            this.antiguedad = antiguedad;
        }
    }

    public int numeroTrienios() {
        return this.antiguedad / 3;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + ", Apellidos= " + apellido1 + " " + apellido2 + ", Salario= " + this.calcularSalario() + "€" + ", Antiguedad= " + antiguedad + " años";
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
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (this.antiguedad != other.antiguedad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido1, other.apellido1)) {
            return false;
        }
        return Objects.equals(this.apellido2, other.apellido2);
    }

    @Override
    public int compareTo(Empleado o) {
        int result = 0;

        if (this.calcularSalario() > o.calcularSalario()) {
            result = -1;
        } else if (this.calcularSalario() == o.calcularSalario()) {
            result = 0;
        } else {
            result = 1;
        }

        return result;
    }

    public abstract double calcularSalario();

}
