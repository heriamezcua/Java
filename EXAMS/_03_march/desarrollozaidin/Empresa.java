package _03_march.desarrollozaidin;

import java.util.ArrayList;
import funciones.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.regex.Pattern;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW-B
 */
public class Empresa {

    private String nombre;
    private ArrayList<Empleado> empleados;

    public Empresa(String nombre) {
        if (!ValidarDatos.validarTitulo(nombre)) {
            throw new IllegalArgumentException("El nombre de la empresa no es valido");
        }
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public boolean añadirEmpleado(Empleado e) {
        boolean loAñade = false;
        if (!existeEmpleado(e)) {
            if (e instanceof Programador) {
                empleados.add(new Programador(e.getNombre(), e.getApellido1(), e.getApellido2(), e.getSalario(),
                        e.getAntiguedad(), ((Programador) e).getLenguajeProgramacion(), ((Programador) e).getPlus(),
                        ((Programador) e).getNumProyectosTrabaja()));
                loAñade = true;
            }
            if (e instanceof Comercial) {
                empleados.add(new Comercial(e.getNombre(), e.getApellido1(), e.getApellido2(), e.getSalario(), e.getAntiguedad(), ((Comercial) e).getZonaVenta(), ((Comercial) e).getNumVentas()));
                loAñade = true;
            }
        }

        return loAñade;
    }

    public int añadirEmpleados(ArrayList<Empleado> listaEmp) {
        int numAñadidos = 0;
        for (Empleado e : listaEmp) {
            if (añadirEmpleado(e)) {
                numAñadidos++;
            }
        }

        return numAñadidos;
    }

    public boolean eliminarEmpleado(String nombre, String apellidos) {
        nombre = nombre.trim().replaceAll("\\s+{2,}", " ");
        apellidos = apellidos.trim().replaceAll("\\s+{2,}", " ");
        String apellido1 = apellidos.split(" ")[0];
        String apellido2 = apellidos.split(" ")[1];

        boolean seElimino = false;
        Iterator<Empleado> iterador = this.empleados.iterator();

        while (iterador.hasNext()) {

            Empleado empleado = iterador.next();
            if (empleado.getNombre().equals(nombre)
                    && empleado.getApellido1().equals(apellido1)
                    && empleado.getApellido2().equals(apellido2)) {
                iterador.remove();
                seElimino = true;
            }
        }
        return seElimino;
    }

    public int eliminarEmpleados(String apellidos) {
        int numEliminados = 0;

        Iterator<Empleado> iterador = this.empleados.iterator();

        while (iterador.hasNext()) {

            Empleado empleado = iterador.next();
            if (Pattern.matches(apellidos, (empleado.getApellido1() + " " + empleado.getApellido2()))) {
                iterador.remove();
                numEliminados++;
            }
        }

        return numEliminados;
    }

    public double calcularCosteProgramadores() {
        double costeProgramadores = 0;
        for (Empleado e : empleados) {
            if (e instanceof Programador) {
                costeProgramadores += e.calcularSalario();
            }
        }

        return costeProgramadores;
    }

    public ArrayList<Comercial> mejoresComerciales(int n) {
        ArrayList<Comercial> copiaComerciales = new ArrayList<>();

        for (int indice = 0, contador = 0; indice < empleados.size() && contador != n; indice++) {
            if (empleados.get(indice) instanceof Comercial comercial) {
                copiaComerciales.add(new Comercial(comercial.getNombre(), comercial.getApellido1(), comercial.getApellido2(),
                        comercial.getSalario(), comercial.getAntiguedad(), comercial.getZonaVenta(), comercial.getNumVentas()));
                contador++;
            }
        }

        OrdenarComercialMayorVentas ordenarComercial = new OrdenarComercialMayorVentas();
        Collections.sort(copiaComerciales, ordenarComercial);

        n = (n <= 0) ? this.empleados.size() - 1 : n;
        n = (n >= this.empleados.size()) ? this.empleados.size() - 1 : n;

        return new ArrayList<>(copiaComerciales.subList(0, n));
    }

    public double calcularCosteEmpleados() {
        double costeEmpleados = 0;

        for (Empleado e : empleados) {
            costeEmpleados += e.calcularSalario();
        }

        return costeEmpleados;
    }

    private boolean existeEmpleado(Empleado e) {
        boolean existe = false;
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(e.getNombre())
                    && empleado.getApellido1().equals(e.getApellido1())
                    && empleado.getApellido2().equals(e.getApellido2())) {
                existe = true;
            }
        }

        return existe;
    }

    public ArrayList<Empleado> getCopiaEmpleados() {
        ArrayList<Empleado> copiaEmpleados = new ArrayList<>();

        for (Empleado e : empleados) {
            copiaEmpleados.add(e);
        }

        return copiaEmpleados;
    }

    @Override
    public String toString() {
        return "Nombre= " + nombre + ", empleados= " + empleados.size();
    }

}
