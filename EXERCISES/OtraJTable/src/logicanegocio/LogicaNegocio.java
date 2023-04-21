/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import beans.Alumno;
import java.util.ArrayList;

/**
 *
 * @author amezc
 */
public class LogicaNegocio {

    public ArrayList<Alumno> listaAlumnos;

    public LogicaNegocio() {
        listaAlumnos = new ArrayList<>();
        listaAlumnos.add(new Alumno("Pablo", "DAM2"));
        listaAlumnos.add(new Alumno("Tomás", "DAM1"));
        listaAlumnos.add(new Alumno("José", "DAM2"));
    }

    public ArrayList<Alumno> getListaAlumnos() {
        return listaAlumnos;
    }

}
