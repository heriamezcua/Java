package _03_march.desarrollozaidin;

import funciones.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author DAW-B
 */
public class ProgramaPrincipal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Empresa emp = new Empresa("MacroSoft");
        
        Programador prog = new Programador("Antonio", "Fernández", "Mesa", 1300.5, 4, "java", 150, 1);
        Comercial com = new Comercial("José", "Sánchez", "Castillo", 1783.4, 7, ZonaVenta.NORTE, 6);
        
        emp.añadirEmpleado(prog);
        emp.añadirEmpleado(com);
        
        int eleccionPrincipal = 0;
        do {
            
            menuSeleccion();
            eleccionPrincipal = ValidarDatos.calcNumRango(1, 9, LeerDatosTeclado.enterInt(""), "Seleccione una opción válida:");
            
            switch (eleccionPrincipal) {
                case 1 -> {
                    Programador nuevo = new Programador(ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("nombre del programador")), ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("primer apellido del programador")), ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("segundo apellido del programador")), PedirDatosEmpleado.pedirSalario("programador"), PedirDatosEmpleado.pedirAntiguedad("programador"),
                            PedirDatosEmpleado.pedirLenguaje(), PedirDatosEmpleado.pedirPlus(), PedirDatosEmpleado.pedirNumProy());
                    //si el programador nuevo ya se encuentra no la añado
                    if (emp.añadirEmpleado(nuevo)) {
                        
                        System.out.println("\033[0;31m¡Se ha contratado programador!\u001B[0m");
                    } else {
                        System.out.println("No se ha podido añadir programador");
                    }
                }
                case 2 -> {
                    Comercial nuevo = new Comercial(ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("nombre del programador")), ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("primer apellido del programador")), ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("segundo apellido del programador")), PedirDatosEmpleado.pedirSalario("programador"), PedirDatosEmpleado.pedirAntiguedad("programador"),
                            PedirDatosEmpleado.pedirZonaVenta(), PedirDatosEmpleado.pedirNumVentas());
                    //si el Comercial nuevo ya se encuentra  no la añado
                    if (!emp.añadirEmpleado(nuevo)) {
                        
                        System.out.println("\033[0;31m¡Se ha contratado comercial!\u001B[0m");
                    } else {
                        System.out.println("No se ha podido añadir nuevo comercial");
                    }
                }
                case 3 -> {
                    if (emp.eliminarEmpleado(ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("empleado")), (ValidarDatos.toTitleCase(PedirDatosEmpleado.pedirNombre("apellidos del empleado"))))) {
                        
                        System.out.println("\033[0;31m¡Se ha eliminado el empleado!\u001B[0m");
                        
                    } else {
                        System.out.println("No se ha podido eliminar empleado");
                    }
                }
                case 4 -> {
                    String regex = LeerDatosTeclado.enterString("Introduzca expresión regular:");
                    int nElim = emp.eliminarEmpleados(regex);
                    if (nElim != 0) {
                        System.out.println("\033[0;31m¡Se han eliminado " + nElim + " empleados!\u001B[0m");
                    } else {
                        System.out.println("No se han podido eliminar empleados");
                    }
                }
                case 5 -> {
                    ArrayList<Empleado> empleados = emp.getCopiaEmpleados();
                    for (Empleado e : empleados) {
                        if (e instanceof Comercial comercial) {
                            System.out.println(comercial);
                            System.out.println("");
                        }
                        if (e instanceof Programador programador) {
                            System.out.println(programador);
                            System.out.println("");
                        }
                    }
                }
                case 6 -> {
                    System.out.println(new StringBuilder("\nCoste total de los programadores: ").append(emp.calcularCosteProgramadores()).append("€\n"));
                }
                case 7 -> {
                    System.out.println(new StringBuilder("\nCoste total de los empleados: ").append(emp.calcularCosteEmpleados()).append("€\n"));
                    
                }
                case 8 -> {
                    int n = LeerDatosTeclado.enterInt("Introduzca la cantidad de mejores comerciales que quiere ver:");
                    System.out.println("");
                    for (Empleado e : emp.mejoresComerciales(n)) {
                        if (e instanceof Comercial comercial) {
                            System.out.println(comercial);
                            System.out.println("");
                        }
                        if (e instanceof Programador programador) {
                            System.out.println(programador);
                            System.out.println("");
                        }
                    }
                    System.out.println("");
                    
                }
                
            }
            
        } while (eleccionPrincipal != 9);
    }

    /**
     * Muestra las opciones que el usuario podrá realizar en el menú principal.
     */
    private static void menuSeleccion() {
        System.out.print("""  
                  ¿Qué desea realizar?
                  1. Añadir Programador
                  2. Añadir Comercial
                  3. Eliminar empleado
                  4. Eliminar empleados
                  5. Listar empleados
                  6. Calcular coste total programadores
                  7. Calcular coste total empleados
                  8. Listar los n mejores comerciales
                  9. Salir
                  """);
    }
    
}
