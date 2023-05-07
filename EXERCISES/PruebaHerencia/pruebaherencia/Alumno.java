/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaherencia;

/**
 *
 * @author amezc
 */
public class Alumno extends Persona {

    private String grupo;
    private double notamedia;

    public Alumno(String nombre, String apellido, String grupo, double notaMed) {
        super(nombre, apellido);
        this.grupo = grupo;
        this.notamedia = notaMed;
    }

    public Alumno() {
        this(null, null, null, 0);
    }

    @Override
    public String toString() {
        return super.toString() + " Grupo=" + grupo + ", Nota media=" + notamedia;
    }

}

/*
        //como vemos en la clase Alumno, no hay atributo nombre sino que lo hereda de Persona.
        Persona p = new Persona();
        Alumno a = new Alumno("José", "Martínez", "A", 8.7);

        System.out.println(p);
        System.out.println(a);
 */
