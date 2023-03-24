/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funciones;

import desarrollozaidin.ZonaVenta;

/**
 *
 * @author DAW-B
 */
public class PedirDatosEmpleado {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\033[0;31m";
    private static final String BLUE = "\u001B[34m";

    /**
     * Pide el nombre de una persona hasta que sea valido. Será valido si
     * introduce unicamente caracteres alfanumericos, ñ o tildes.
     *
     * @param pedido el nombre de lo que queremos pedir (director, actor,
     * bombero...)
     * @return el nombre de esa persona
     */
    public static String pedirNombre(String pedido) {
        System.out.println(new StringBuilder("Introduzca el ").append(pedido).append(":"));
        StringBuilder nombre = new StringBuilder();
        do {
            nombre.setLength(0);
            nombre.append(LeerDatosTeclado.enterStringNextLine(""));
            if (!ValidarDatos.validarNombrePersona(nombre.toString())) {
                System.err.println("Introduzca carácteres válidos");
            }
        } while (!ValidarDatos.validarNombrePersona(nombre.toString()));

        return nombre.toString().trim().replaceAll("\\s+{2,}", " ");
    }

    public static int pedirSalario(String pedido) {
        System.out.println(new StringBuilder("Introduzca el salario del ").append(pedido).append(":"));
        int salario = LeerDatosTeclado.enterInt("");
        do {

            if (!ValidarDatos.validarSalario(salario)) {
                System.err.println("Introduzca un salario mayor al SMI");
            }
        } while (!ValidarDatos.validarSalario(salario));

        return salario;
    }

    public static int pedirAntiguedad(String pedido) {
        System.out.println(new StringBuilder("Introduzca la antiguedad del ").append(pedido).append(":"));
        int antiguedad = LeerDatosTeclado.enterInt("");
        do {

            if (!ValidarDatos.validarAntiguedad(antiguedad)) {
                System.err.println("la antigüedad no puede ser negativa");
            }
        } while (!ValidarDatos.validarAntiguedad(antiguedad));

        return antiguedad;
    }

    public static String pedirLenguaje() {
        System.out.println("Introduzca el lenguaje que usa el programador:");
        StringBuilder lenguaje = new StringBuilder();
        do {
            lenguaje.setLength(0);
            lenguaje.append(LeerDatosTeclado.enterString(""));
            if (!ValidarDatos.validarLenguaje(lenguaje.toString())) {
                System.err.println("Introduzca un lenguaje que use la empresa");
            }
        } while (!ValidarDatos.validarLenguaje(lenguaje.toString()));

        return lenguaje.toString();

    }

    public static int pedirPlus() {
        System.out.println("Introduzca el plus del programador:");
        int plus = LeerDatosTeclado.enterInt("");
        do {

            if (!ValidarDatos.validarPlus(plus)) {
                System.err.println("el plus no puede ser negativa");
            }
        } while (!ValidarDatos.validarPlus(plus));

        return plus;
    }

    public static int pedirNumProy() {
        System.out.println("Introduzca el numero de proyectos donde esta el programador:");
        int numP = LeerDatosTeclado.enterInt("");
        do {

            //seria la misma expresion para validar plus y pro
            if (!ValidarDatos.validarNProyect(numP)) {
                System.err.println("el plus no puede ser negativa");
            }
        } while (!ValidarDatos.validarNProyect(numP));

        return numP;
    }

    public static ZonaVenta pedirZonaVenta() {
        System.out.println("Introduzca para seleccionar z<ona de venta:\n"
                + "1. CENTRO\n"
                + "2. NORTE\n"
                + "3. COSTA");

        int eleccion = ValidarDatos.calcNumRango(1, 3, LeerDatosTeclado.enterInt(""), "Seleccione una opcion valida");

        eleccion--;
        return ZonaVenta.values()[eleccion];
    }

    public static int pedirNumVentas() {
        System.out.println("Introduzca el numero de ventas del comercial:");
        int numV = LeerDatosTeclado.enterInt("");
        do {

            //seria la misma expresion para validar numero de ventas q la de n proyectos
            if (!ValidarDatos.validarNProyect(numV)) {
                System.err.println("el numero de ventas no puede ser negativo");
            }
        } while (!ValidarDatos.validarNProyect(numV));

        return numV;
    }

}
