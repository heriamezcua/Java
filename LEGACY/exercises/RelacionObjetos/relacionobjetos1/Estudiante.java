/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos1;

import java.util.Arrays;
import static java.util.Arrays.copyOf;

/**
 * Metodo que nos permite crear un estudiante y hacer operaciones con el.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 */
public class Estudiante {

    private String nombre, apellido1, apellido2;
    private Asignatura[] listaAsignaturas;

    /**
     * Metodo constructor que nos permite crear un estudiante introduciendo su
     * nombre y dos apellidos.
     *
     * @param nombre el nombre del estudiante.
     * @param apellido1 el primer apellido del estudiante.
     * @param apellido2 el segundo apellido del estudiante.
     */
    public Estudiante(String nombre, String apellido1, String apellido2) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }

    /**
     * Metodo constructor copia que crea un estudiante a con los mismos valores
     * de otro.
     *
     * @param e el estudiante del que vamos a copiar los valores
     */
    public Estudiante(Estudiante e) {
        this.nombre = e.nombre;
        this.apellido1 = e.apellido1;
        this.apellido2 = e.apellido2;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido1() {
        return this.apellido1;
    }

    public String getApellido2() {
        return this.apellido2;
    }

    public void setListaAsignaturas(Asignatura[] listaAsignaturas) {
        this.listaAsignaturas = listaAsignaturas;
    }

    /**
     * Metodo que te devuelve un string con la lista de asignaturas en las que
     * estÃ¡ matriculado un alumno.
     *
     * @return
     */
    public Asignatura[] getListaAsignaturas() {

        return this.listaAsignaturas;
    }

    public boolean aniadeAsignatura(Asignatura a) {
        int horasMatriculadas = 0;
        Asignatura[] nuevaListaAsignaturas = copyOf(this.listaAsignaturas, this.listaAsignaturas.length + 1);

        for (int i = 0; i < this.listaAsignaturas.length; i++) {
            horasMatriculadas += this.listaAsignaturas[i].getHoras();
        }

        if (horasMatriculadas <= 30) {
            nuevaListaAsignaturas[nuevaListaAsignaturas.length - 1] = a;
        }
        return (horasMatriculadas <= 30);
    }
    
    
}
