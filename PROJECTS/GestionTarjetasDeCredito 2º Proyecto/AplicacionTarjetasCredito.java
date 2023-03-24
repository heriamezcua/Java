/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestiontarjetascredito;

import java.util.Scanner;
import java.util.regex.*;
import java.util.Arrays;

/**
 * Clase que nos permite crear un aplicacion por consola de gestion de tarjetas
 * de credito funcional.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 11.0.17
 */
public class AplicacionTarjetasCredito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TarjetaCredito[] totalTarjetas = new TarjetaCredito[10];
        boolean salirMenu = false;
        String nifManipular;

        do {
            //Muestro menu inicial
            System.out.println(RESALTAR_AZUL + "*** GESTOR DE TARJETAS BANCO JAVA ***" + RESETEAR_COLOR + "\nSeleccione operación:\n"
                    + "1. Crear tarjeta de crédito.\n"
                    + "2. Eliminar tarjeta de crédito.\n"
                    + "3. Gestionar tarjeta de crédito.\n"
                    + "4. Consultar gastos totales.\n"
                    + "5. Salir del programa.");

            //Pido que seleccione operacion
            int seleccion = enterInt("");

            //me meto en esa operacion
            switch (seleccion) {
                //crear tarjeta
                case 1 -> {
                    boolean hayEspacio = false,
                            mismoNIF = false;
                    //compruebo que quede hueco en el array de tarjetas
                    for (TarjetaCredito tarjeta : totalTarjetas) {
                        if (tarjeta == null) {
                            hayEspacio = true;
                        }
                    }
                    //si hay espacio creare la tarjeta sino saldre al menu
                    if (!hayEspacio) {
                        System.out.println(RESALTAR_ROJO + "No hay espacio para otra tarjeta. Volviendo al menú principal..." + RESETEAR_COLOR);
                    } else {
                        int huecoLibre = -1;
                        int posicion = 0;
                        //busco el hueco libre mas cercano a la izquierda que haya para crear ahí la tarjeta
                        while (huecoLibre == -1) {
                            if (totalTarjetas[posicion] == null) {
                                huecoLibre = posicion;

                            }
                            posicion++;
                        }

                        System.out.println("\n" + RESALTAR_AZUL + "*** BIENVENIDO, CREA TU TARJETA DE CRÉDITO ***" + RESETEAR_COLOR);

                        TarjetaCredito nueva = crearTarjeta();

                        //compruebo que el NIF no pertenezca a ninguna tarjeta
                        for (TarjetaCredito tarjeta : totalTarjetas) {
                            if (tarjeta != null && tarjeta.getNif().equalsIgnoreCase(nueva.getNif())) {
                                mismoNIF = true;
                            }
                        }

                        //si el NIF ya se encuentra en alguna tarjeta no insertare la nueva
                        if (mismoNIF) {
                            System.out.println(RESALTAR_ROJO + "¡Ese NIF ya se encuentra registrado!" + RESETEAR_COLOR + "\nVolviendo al menú principal...\n");
                        } else {
                            totalTarjetas[huecoLibre] = nueva;
                            System.out.println(RESALTAR_ROJO + "Tarjeta de Crédito del Banco JAVA creada" + RESETEAR_COLOR + "\nVolviendo al menú principal...\n");
                        }

                    }
                }
                //eliminar tarjeta
                case 2 -> {
                    System.out.println("\n" + RESALTAR_AZUL + "*** ¡SENTIMOS QUE SE VAYA! ELIMINE SU TARJETA DE CRÉDITO ***" + RESETEAR_COLOR);

                    nifManipular = enterString("Introduzca el NIF asociado de la tarjeta a eliminar: ");
                    do {
                        if (!validarDocumento(nifManipular)) {
                            nifManipular = enterString("Error. Introduzca el NIF asociado correctamente: ");
                        }
                    } while (!validarDocumento(nifManipular));

                    //busco la posicion del NIF, si no se encuentra no existe
                    int posicion = buscarTarjeta(nifManipular, totalTarjetas);
                    if (posicion != -1) {
                        eliminarTarjeta(totalTarjetas, posicion);
                        System.out.println(RESALTAR_ROJO + "Tarjeta de crédito eliminada" + RESETEAR_COLOR + "\nVolviendo al menú principal...\n");
                    } else {
                        System.out.println(RESALTAR_ROJO + "No existe tarjeta con ese NIF" + RESETEAR_COLOR + "\nVolviendo al menú principal...\n");
                    }
                }
                //gestiono la tarjeta de credito
                case 3 -> {
                    nifManipular = enterString("Introduzca el NIF asociado de la tarjeta a eliminar: ");
                    do {
                        if (!validarDocumento(nifManipular)) {
                            nifManipular = enterString("Error. Introduzca el NIF asociado correctamente: ");
                        }
                    } while (!validarDocumento(nifManipular));

                    //La tarjeta existira si al buscarla mediante el NIF encuentra posicion
                    int existeTarjeta = buscarTarjeta(nifManipular, totalTarjetas);
                    if (existeTarjeta != -1) {
                        boolean retroceder = false;
                        TarjetaCredito tarjetaSeleccionada = totalTarjetas[existeTarjeta];
                        do {
                            //Muestro menu de gestion
                            System.out.println("\n" + RESALTAR_AZUL + "*** BIENVENIDO AL MENÚ DE GESTIÓN ***" + RESETEAR_COLOR + "\n¿Qué desea realizar?\n"
                                    + "1. Mostrar el número de tarjeta completo.\n"
                                    + "2. Mostrar el nombre del titular de la tarjeta.\n"
                                    + "3. Mostrar la fecha de caducidad.\n"
                                    + "4. Modificar el PIN.\n"
                                    + "5. Realizar un pago.\n"
                                    + "6. Consultar movimientos.\n"
                                    + "7. Consultar gasto total.\n"
                                    + "8. Volver al menú principal.");

                            seleccion = enterInt("");
                            switch (seleccion) {
                                //muestro el numero de tarjeta
                                case 1 ->
                                    System.out.println(RESALTAR_ROJO + "Número de la Tarjeta: " + tarjetaSeleccionada.getNumeroTarjeta() + RESETEAR_COLOR);
                                //muestro el nombre del titular
                                case 2 ->
                                    System.out.println(RESALTAR_ROJO + "Titular de la Tarjeta: " + tarjetaSeleccionada.getTitular() + RESETEAR_COLOR);
                                //muestro la fecha de caducidad
                                case 3 ->
                                    System.out.println(RESALTAR_ROJO + "Fecha de caducidad: " + tarjetaSeleccionada.getMesCaducidad() + "/" + tarjetaSeleccionada.getAñoCaducidad() + RESETEAR_COLOR);
                                //establezco un nuevo PIN
                                case 4 -> {
                                    String nuevoPin = enterString("Establezca su PIN (Mínimo 4 dígitos)");
                                    do {
                                        if (!Pattern.matches("^\\d{4,}", nuevoPin)) {
                                            nuevoPin = enterString("Error, introduzca un PIN válido (Mínimo 4 dígitos):");
                                        }
                                    } while (!Pattern.matches("^\\d{4,}", nuevoPin));

                                    tarjetaSeleccionada.setPin(nuevoPin);
                                    System.out.println(RESALTAR_ROJO + "Nuevo PIN establecido. (¡No lo comparta con nadie!)" + RESETEAR_COLOR);
                                }
                                //realizo un pago
                                case 5 -> {
                                    double cantidadPagar = enterDouble("Introduzca la cantidad del pago: ");
                                    //valido la cantidad
                                    do {
                                        if (cantidadPagar <= 0) {
                                            cantidadPagar = enterDouble("Introduzca una cantidad válida: ");
                                        }
                                    } while (cantidadPagar <= 0);

                                    String conceptoPago = enterStringEndLine("Introduzca el concepto de la operación: ");
                                    //valido el concepto
                                    do {
                                        if (!Pattern.matches(".{0,50}", conceptoPago)) {
                                            conceptoPago = enterStringEndLine("Longitud superada. Introduzca un concepto válido: ");
                                        }
                                    } while (!Pattern.matches(".{0,50}", conceptoPago));

                                    if (cantidadPagar > tarjetaSeleccionada.getLimite()) {
                                        System.out.println(RESALTAR_ROJO + "La cantidad supera su límite de gasto, volviendo al menú de gestión... " + RESETEAR_COLOR);
                                    } else {
                                        tarjetaSeleccionada.pagar(cantidadPagar, conceptoPago);
                                        System.out.println(RESALTAR_ROJO + "Operación realizada correctamente." + RESETEAR_COLOR);

                                    }
                                }
                                case 6 -> {
                                    int mostrarMov = enterInt("¿Cuántos movimientos desea visualizar? (Máximo 50)");
                                    do {
                                        if (mostrarMov <= 0 || mostrarMov > 50) {
                                            mostrarMov = enterInt("Introduzca una cantidad válida:");
                                        }
                                    } while (mostrarMov <= 0 || mostrarMov > 50);
                                    System.out.println(RESALTAR_ROJO + "Visualizando últimos " + mostrarMov + " movimientos:\n" + RESETEAR_COLOR
                                            + tarjetaSeleccionada.movimientos(mostrarMov));
                                }
                                case 7 ->
                                    System.out.println(RESALTAR_ROJO + "Gasto total: " + tarjetaSeleccionada.gastado() + "€" + RESETEAR_COLOR);
                                case 8 -> {
                                    System.out.println(RESALTAR_ROJO + "Volviendo al menú principal...\n" + RESETEAR_COLOR);
                                    retroceder = true;
                                }
                            }

                        } while (!retroceder);
                    } else {
                        System.out.println(RESALTAR_ROJO + "No existe tarjeta con ese NIF" + RESETEAR_COLOR + "\nVolviendo al menú principal...\n");
                    }
                }
                //consulto el gasto total del conjunto de tarjetas
                case 4 ->
                    System.out.println(RESALTAR_ROJO + "Gasto total de todas las tarjetas: " + consultarGastosTotales(totalTarjetas) + "€" + RESETEAR_COLOR + "\n");
                //salir de la aplicacion
                case 5 -> {
                    System.out.println(RESALTAR_ROJO + "¡Gracias por usar nuestro gestor!¡Qué tenga un buen día!" + RESETEAR_COLOR);
                    salirMenu = true;
                }
                default ->
                    System.out.println(RESALTAR_ROJO + "Por favor, seleccione correctamente." + RESETEAR_COLOR + "\n");

            }

        } while (!salirMenu);

    }

    /**
     * Metodo que crea una tarjeta de credito en base a los parametros que le
     * pide al usuario.
     *
     * @return una tarjeta de credito cuyos datos han sido introducidos por el
     * usuario
     */
    private static TarjetaCredito crearTarjeta() {
        String titular, nif, numeroTarjeta, pin;
        int limite;

        //compruebo que me este introduciendo un nombre valido
        titular = enterStringEndLine("Introduzca su nombre completo:");
        do {
            if (!Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{15,80}", titular)) {
                titular = enterStringEndLine("Error. Introduzca un nombre válido:");
            }
        } while (!Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{15,80}", titular));

        //compruebo que me este introduciendo un nif, cif, nie valido
        nif = enterString("Introduzca su NIF/CIF/NIE del Titular:");
        do {
            if (!validarDocumento(nif)) {
                nif = enterString("El NIF/CIF/NIE es incorrecto:");
            }
        } while (!validarDocumento(nif));

        //compruebo que este introduciendo un numero de tarjeta correcto
        numeroTarjeta = enterString("*Introduzca número de tarjeta (16 digitos control incluido):");
        do {
            if (!comprobarNumeroTarjeta(numeroTarjeta)) {
                numeroTarjeta = enterString("Error, introduzca un número de tarjeta válido (16 digitos control incluido):");
            }
        } while (!comprobarNumeroTarjeta(numeroTarjeta));

        //compruebo que l pin sea válido
        pin = enterString("Establezca su PIN (Mínimo 4 dígitos)");
        do {
            if (!Pattern.matches("^\\d{4,}", pin)) {
                pin = enterString("Error, introduzca un PIN válido (Mínimo 4 dígitos):");
            }
        } while (!Pattern.matches("^\\d{4,}", pin));

        limite = enterInt("Establezca su límite de gasto (500 - 5000):");
        do {
            if (limite < 500 || limite > 5000) {
                limite = enterInt("Error, establezca un límite de gasto válido (500 - 5000):");
            }
        } while (limite < 500 || limite > 5000);

        return new TarjetaCredito(titular, nif, pin, limite, numeroTarjeta);

    }

    /**
     * Metodo que nos permite elimitar la tarjeta de credito deseada. Ademas,
     * compactara el array dejando el hueco libre causado al eliminar la tarjeta
     * en final de este.
     *
     * @param totalTarjetas el array de tarjetas donde se encuentra la tarjeta
     * que queremos eliminar.
     * @param posicionEliminar la posicion de la tarjeta a eliminar.
     */
    private static void eliminarTarjeta(TarjetaCredito[] totalTarjetas, int posicionEliminar) {
        //elimino la tarjeta
        totalTarjetas[posicionEliminar] = null;

        //subdivido en arrays de tarjetas las que quiero conservar como punto de ruptura la posicion eliminada
        TarjetaCredito[] mitadUno = Arrays.copyOfRange(totalTarjetas, 0, posicionEliminar);
        TarjetaCredito[] mitadDos = Arrays.copyOfRange(totalTarjetas, posicionEliminar + 1, totalTarjetas.length);

        //compacto el array copiando en orden los subarrays
        System.arraycopy(mitadUno, 0, totalTarjetas, 0, mitadUno.length);
        System.arraycopy(mitadDos, 0, totalTarjetas, posicionEliminar, mitadDos.length);

    }

    /**
     * Metodo estatico que nos permite encontrar la posicion en la que se
     * encuentra una tarjeta de credito en un array buscandola si tiene el mismo
     * NIF
     *
     * @param nif el NIF de la tarjeta que queremos encontrar su posicion.
     * @param totalTarjetas el array de tarjetas donde buscaremos.
     * @return la posicion del array en la que se encuentra la tarjeta.
     */
    private static int buscarTarjeta(String nif, TarjetaCredito[] totalTarjetas) {
        int posicionTarjeta = -1;
        for (int posicion = 0; posicion < totalTarjetas.length; posicion++) {
            if (totalTarjetas[posicion] != null && totalTarjetas[posicion].getNif().equalsIgnoreCase(nif)) {
                posicionTarjeta = posicion;
            }
        }
        return posicionTarjeta;
    }

    /**
     * Metodo que nos permite consultar los gastos totales realizados por las
     * tarjetas de credito de nuestro array de tarjetas.
     *
     * @param totalTarjetas el array de tarjetas del cual queremos consultar la
     * sumatoria de los gastos de cada una.
     * @return la sumatoria de gastos de todas las tarjetas.
     */
    private static double consultarGastosTotales(TarjetaCredito[] totalTarjetas) {
        double gastosTotales = 0;

        for (TarjetaCredito tarjeta : totalTarjetas) {
            if (tarjeta != null) {
                gastosTotales += tarjeta.gastado();
            }
        }

        return gastosTotales;
    }

    /**
     * Metodo para validar un numero de tarjeta de credito introducido por el
     * usuario. Realizara el algoritmo de Luhn.
     *
     * @param numero el numero de tarjeta de credito, digito de control
     * incluido.
     * @return true si el numero de tarjeta es valido.
     */
    private static boolean comprobarNumeroTarjeta(String numero) {
        boolean esValida = true;
        //primero valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+{16}", numero)) {
            esValida = false;
        }

        //realizo el algoritmo de Luhn para verificar el numero de tarjeta el cual
        //se encuentra dividido en los metodos calcSumaPorNueve y obtenerDigitoControl
        //si el digito de control de los primeros 15 digitos concuerda con el introducido por el usuario, la tarjeta es valida
        if (esValida) {
            if (!obtenerDigitoControl(numero.substring(0, numero.length() - 1)).equals(Character.toString(numero.charAt(numero.length() - 1)))) {
                esValida = false;
            }
        }
        return esValida;
    }

    /**
     * Metodo que calcula el digito de control de una tarjeta de credito a
     * partir del numero. Para que quede mas claro, de los 16 digitos de que
     * tiene el numero de la tarjeta de credito en total se obtiene el digito de
     * control (el digito 16) a partir de los primeros 15 digitos.
     *
     * @param numero el numero de la tarjeta de credito sin el digito de
     * control.
     * @return el digito de control de la tarjeta de credito.
     */
    private static String obtenerDigitoControl(String numero) {

        return "" + (calcSumaPorNueve(numero) % 10);
    }

    /**
     * Metodo estatico que calcula una parte del algoritmo de Luhn.
     *
     * @param num el numero de tarjeta de credito.
     * @return la suma parcial multiplicada por nueve del algoritmo de Luhn.
     */
    private static int calcSumaPorNueve(String num) {
        int sumaPares = 0, sumaImpares = 0, sumaParcial;

        //sumo las cifras pares
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((i + 1) % 2 == 0) {
                int numeroPar, parPorDos;
                //extraigo el numero par
                numeroPar = Integer.parseInt(Character.toString(num.charAt(i)));
                //multiplico x2 el numero par
                parPorDos = numeroPar * 2;
                //sumo sus cifras y las aniado a la suma de los numero pares
                sumaPares += (parPorDos % 10 == parPorDos) ? parPorDos : (parPorDos / 10 + parPorDos % 10);

            }
        }

        //sumo las cifras impares
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((i + 1) % 2 != 0) {
                sumaImpares += Integer.parseInt(Character.toString(num.charAt(i)));

            }
        }

        //sumo pares e impares y multiplico por nueve
        sumaParcial = sumaPares + sumaImpares;

        //devuelvo la suma parcial multiplicada por nueve para seguir realizando el algoritmo de Luhn
        return sumaParcial * 9;

    }

    //Las funciones siguientes las meteria en otro paquete o en varias clases ya
    //que se usan tanto en el MAIN como en TarjetaCredito pero como en la guia 
    //del proyecto pone que podemos implementar atributos y metodos PRIVADOS pues
    //no me la juego aunque duplique codigo.
    /**
     * Metodo estatico que comprueba si el NIF, CIE, NIE es valido.
     *
     * @param identificacion la identificacion introducida por el usuario.
     * @return true si es un NIF, CIF, NIE
     */
    private static boolean validarDocumento(String documento) {
        boolean esValido = true;

        //compruebo si cumple con la longitud
        if (documento.length() != 9) {
            esValido = false;
        }

        if (esValido) {
            //dependiendo del tipo de documento compruebo si es valido
            switch (tipoIdentificacion(documento)) {
                case "nif" ->
                    esValido = nifEsValido(documento);
                case "nie" ->
                    esValido = nieEsValido(documento);
                case "cif" ->
                    esValido = cifEsValido(documento);
            }
        }

        return esValido;
    }

    /**
     * Metodo estatico que comprueba que tipo de identificacion que nos ha
     * introducido el usuario pudiendo ser NIF, NIE o CIF.
     *
     * @param identificacion la identificacion introducida por el usuario.
     * @return el tipo de identificacion, si esta mal devolvera nif
     */
    private static String tipoIdentificacion(String identificacion) {
        String tipoId;

        //comprueba que tipo de identificacion es, si es NIF o ninguna dara nif
        if (Pattern.matches("[x-zX-Z]", Character.toString(identificacion.charAt(0)))) {
            tipoId = "nie";
        } else if (Pattern.matches("[a-wA-W]", Character.toString(identificacion.charAt(0)))) {
            tipoId = "cif";
        } else {
            tipoId = "nif";
        }

        return tipoId;
    }

    /**
     * Metodo estatico que comprueba si el NIF introducido es valido.
     *
     * @param nif el NIF introducido por el usuario.
     * @return true si el NIF es valido.
     */
    private static boolean nifEsValido(String nif) {
        boolean esValido = true;

        //valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+$", nif.substring(0, 8))) {
            esValido = false;
        }

        //valido que el digito de control introducido concuerde con el numero
        if (esValido) {
            if (!generarDigitoControl(Integer.parseInt(nif.substring(0, 8))).equals(Character.toString(nif.charAt(8)).toUpperCase())) {
                esValido = false;
            }
        }

        return esValido;
    }

    /**
     * Metodo estatico que comprueba si el NIE introducido es valido.
     *
     * @param nie el NIE introducido por el usuario.
     * @return true si el NIE es valido.
     */
    private static boolean nieEsValido(String nie) {
        boolean esValido = true;

        //valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+$", nie.substring(1, 8))) {
            esValido = false;
        }

        if (esValido) {
            String letra = Character.toString(nie.charAt(0)).toUpperCase();
            int numero;

            //Dependiendo del tipo de letra aplicare una u otra forma para calcular el numero equivalente en NIF
            numero = switch (letra) {
                case "Y" ->
                    (int) Math.pow(10, 7) + Integer.parseInt(nie.substring(1, 8));
                case "Z" ->
                    (int) Math.pow(10, 7) * 2 + Integer.parseInt(nie.substring(1, 8));
                default ->
                    Integer.parseInt(nie.substring(1, 8));
            };

            String digitoControl = Character.toString(nie.charAt(8)).toUpperCase();

            //valido que el digito de control introducido concuerde con el numero
            if (!generarDigitoControl(numero).equals(digitoControl)) {
                esValido = false;
            }
        }

        return esValido;
    }

    /**
     * Metodo estatico que comprueba si el CIF introducido es valido.
     *
     * @param cif el CIF introducido por el usuario.
     * @return true si el CIF es valido.
     */
    private static boolean cifEsValido(String cif) {
        boolean esValido = true;

        //valido que la letra del tipo de organizacion sea correcta
        if (!Pattern.matches("[[a-wA-W]&&[^iIoOtT]]", Character.toString(cif.charAt(0)))) {
            esValido = false;
        }

        //valido que la letra del tipo de organizacion no sea de las que han quedado obsoletas
        if (!Pattern.matches("[^kKlLmM]", Character.toString(cif.charAt(0)))) {
            esValido = false;
        }

        //valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+$", cif.substring(1, 8))) {
            esValido = false;
        }

        if (esValido) {
            //valido que el codigo provincial exista
            int codigoProvincial = Integer.parseInt(cif.substring(1, 3));
            if ((codigoProvincial >= 65 && codigoProvincial <= 69) || (codigoProvincial >= 86 && codigoProvincial <= 90)) {
                esValido = false;
            }

            String digitoControl = Character.toString(cif.charAt(8)).toUpperCase();
            String digitosCentrales = cif.substring(1, 8);
            String tipoOrg = Character.toString(cif.charAt(0)).toUpperCase();

            //compruebo que el digito de control introducido se corresponda con los datos introducidos
            if (!generarDigitoControlCIF(tipoOrg, digitosCentrales).equals(digitoControl)) {
                esValido = false;
            }
        }

        return esValido;
    }

    //Hubiera utilizado el nuevo switch pero mi JDK es antiguo
    /**
     * Metodo estatico que genera el digito de control correspondiente al numero
     * introducido
     *
     * @param n el numero del que queremos obtener el digito de control
     * @return el digito de control
     */
    private static String generarDigitoControl(int n) {
        int resto = n % 23;
        String digitoControl = "";

        switch (resto) {
            case 0 ->
                digitoControl = "T";
            case 1 ->
                digitoControl = "R";
            case 2 ->
                digitoControl = "W";
            case 3 ->
                digitoControl = "A";
            case 4 ->
                digitoControl = "G";
            case 5 ->
                digitoControl = "M";
            case 6 ->
                digitoControl = "Y";
            case 7 ->
                digitoControl = "F";
            case 8 ->
                digitoControl = "P";
            case 9 ->
                digitoControl = "D";
            case 10 ->
                digitoControl = "X";
            case 11 ->
                digitoControl = "B";
            case 12 ->
                digitoControl = "N";
            case 13 ->
                digitoControl = "J";
            case 14 ->
                digitoControl = "Z";
            case 15 ->
                digitoControl = "S";
            case 16 ->
                digitoControl = "Q";
            case 17 ->
                digitoControl = "V";
            case 18 ->
                digitoControl = "H";
            case 19 ->
                digitoControl = "L";
            case 20 ->
                digitoControl = "C";
            case 21 ->
                digitoControl = "K";
            case 22 ->
                digitoControl = "E";
        }

        return digitoControl;
    }

    /**
     * Metodo estatico que genera el digito de control del CIF a partir del tipo
     * de organizacion y de los digitos del documento.
     *
     * @param tipoOrg letra que identifica el tipo de organizacion.
     * @param digitos los digitos centrales del documento.
     * @return el digito de control del CIF
     */
    private static String generarDigitoControlCIF(String tipoOrg, String digitos) {
        int sumaPares = 0, sumaImpares = 0, sumaParcial = 0, digito;
        String digitoControl = "";

        //calculo la suma de los digitos pares
        for (int i = 0; i < digitos.length(); i++) {
            if ((i + 1) % 2 == 0) {
                digito = Integer.parseInt(Character.toString(digitos.charAt(i)));
                sumaPares += digito;
            }
        }

        //calculo la suma de los digitos impares
        for (int i = 0; i < digitos.length(); i++) {
            if ((i + 1) % 2 != 0) {
                digito = Integer.parseInt(Character.toString(digitos.charAt(i)));

                String digitoMultiplicado = "" + (digito * 2);

                sumaImpares += (digitoMultiplicado.length() == 1) ? Integer.parseInt(Character.toString(digitoMultiplicado.charAt(0)))
                        : Integer.parseInt(Character.toString(digitoMultiplicado.charAt(0)))
                        + Integer.parseInt(Character.toString(digitoMultiplicado.charAt(1)));
            }
        }

        sumaParcial = sumaPares + sumaImpares;

        //extraigo las unidades de la suma parcial
        int unidadesSumaParcial = sumaParcial % 10;

        //Obtengo el digito de control dependiendo de la letra del tipo de organizacion
        switch (tipoOrg) {
            case "A", "B", "C", "D", "E", "F", "G", "H", "J", "U", "V" ->
                digitoControl = "" + (10 - unidadesSumaParcial);
            case "N", "P", "Q", "R", "S", "W" ->
                digitoControl = letraControl(10 - unidadesSumaParcial);
        }

        return digitoControl;
    }

    /**
     * Metodo estatico que calcula el digito de control cuando es una letra de
     * un CIF.
     *
     * @param n el numero resultante de restar 10 menos las unidades de la suma
     * parcial del algoritmo de Luhn para calcular el CIF.
     * @return el digito de control del CIF cuando es una letra.
     */
    private static String letraControl(int n) {
        String letraControl = "";
        switch (n) {
            case 0 ->
                letraControl = "J";
            case 1 ->
                letraControl = "A";
            case 2 ->
                letraControl = "B";
            case 3 ->
                letraControl = "C";
            case 4 ->
                letraControl = "D";
            case 5 ->
                letraControl = "E";
            case 6 ->
                letraControl = "F";
            case 7 ->
                letraControl = "G";
            case 8 ->
                letraControl = "H";
            case 9 ->
                letraControl = "I";
            case 10 ->
                letraControl = "J";
        }

        return letraControl;
    }

    /**
     * Metodo estatico que nos facilita la peticion de un dato de tipo String al
     * usuario cuyo delimitador es un espacio en blanco. Comprobando que el dato
     * introducido sea valido.
     *
     * @param message el mensaje que queremos mostrar al usuario antes de pedir
     * los datos
     * @return un valor de tipo String introducido por el usuario
     */
    private static String enterString(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);

        if (!input.hasNext()) {
            do {
                System.out.println("ERROR. Introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNext());
        }

        return input.next();
    }

    /**
     * Metodo estatico que nos facilita la peticion de un dato de tipo String al
     * usuario cuyo delimitador es el salto de linea. Comprobando que el dato
     * introducido sea valido.
     *
     * @param message el mensaje que queremos mostrar al usuario antes de pedir
     * los datos
     * @return el nombre del usuario tipo String
     */
    private static String enterStringEndLine(String message) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter(Pattern.compile("(\\n)|;"));
        System.out.println(message);

        if (!input.hasNext()) {
            do {
                System.out.println("ERROR. Introduzca los datos correctamente");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNext());
        }

        return input.next();
    }

    /**
     * Metodo estatico que nos facilita la peticion de un dato de tipo entero al
     * usuario. Comprobando que el dato introducido sea valido.
     *
     * @param message el mensaje que queremos mostrar al usuario antes de pedir
     * los datos
     * @return un valor de tipo entero introducido por el usuario
     */
    private static int enterInt(String message) {
        Scanner input = new Scanner(System.in);

        if (!message.equals("")) {
            System.out.println(message);
        }

        if (!input.hasNextInt()) {
            do {
                System.out.println("Por favor, seleccione correctamente.");
                input.nextLine();
                System.out.println(message);

            } while (!input.hasNextInt());
        }

        return input.nextInt();
    }

    /**
     * Metodo estatico que nos facilita la peticion de un dato de tipo double al
     * usuario. Comprobando que el dato introducido sea valido.
     *
     * @param x el mensaje que queremos mostrar al usuario antes de pedir los
     * datos.
     * @return un valor de tipo double introducido por el usuario
     */
    private static double enterDouble(String x) {
        Scanner input = new Scanner(System.in);
        String message = x;
        System.out.println(message);

        if (!input.hasNextDouble()) {
            do {
                System.out.println("Error, vuelve a introducir");
                input.nextLine();
            } while (!input.hasNextDouble());
        }

        return input.nextDouble();
    }

    /**
     * Metodo estatico que nos permite imprimir texto en color rojo
     */
    private static final String RESALTAR_ROJO = "\u001B[31m";

    /**
     * Metodo estatico que resetea el texto al color por defecto
     */
    private static final String RESETEAR_COLOR = "\u001B[0m";
    /**
     * Metodo estatico que nos permite imprimir texto en color azul
     */
    private static final String RESALTAR_AZUL = "\u001B[34m";

}
