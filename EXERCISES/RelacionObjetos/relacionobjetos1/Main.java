/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionobjetos1;

/**
 *
 * @author amezc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Asignatura mates = new Asignatura("Mates", 15);
        Asignatura lengua = new Asignatura("Lengua", 10);
        Asignatura[] misAsignaturas = new Asignatura[10];
        misAsignaturas[0] = mates;
        misAsignaturas[1] = lengua;

        Estudiante heri = new Estudiante("Heriberto", "Amezcua", "Hernandez");
        heri.setListaAsignaturas(misAsignaturas);
        
        Asignatura ingles = new Asignatura("Ingles", 4);
        heri.aniadeAsignatura(ingles);

        for (int i = 0; i < heri.getListaAsignaturas().length; i++) {
            System.out.println("Asignatura "+(i+1)+"\n"+heri.getListaAsignaturas()[i]);
        }
        
        
    }

}
