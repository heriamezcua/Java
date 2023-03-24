/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestiontarjetascredito;

import java.util.Calendar;
import java.util.regex.*;
import java.util.Arrays;
import java.util.Objects;

/**
 * Esta clase permite crear una tarjeta de credito con la cual podremos realizar
 * disitas operaciones.
 *
 * @author Heriberto Amezcua
 * @version 1.0
 * @since JDK 11.0.17
 */
public class TarjetaCredito {

    private String titular, nif, numeroTarjeta, pin, mesCaducidad, añoCaducidad, cvv;
    private int limite;
    private Movimiento[] movimientos = new Movimiento[50];

    public String getCvv() {
        return cvv;
    }

    /**
     * Metodo constructor que nos permite crear una "tarjeta de credito" dandole
     * un estado a sus valores si son validos.
     *
     * @param nombre el nombre del titular de la tarjeta de credito
     * @param nif el nif del titular de la tarjeta de credito
     * @param pin el pin de acceso de la tarjeta de credito
     * @param limite el limite que el titular puede gastar ese mes
     * @param numeroTarjeta el numero de esa tarjeta de credito
     */
    public TarjetaCredito(String nombre, String nif, String pin, int limite, String numeroTarjeta) {
        //valido el nombre del titular
        if (!Pattern.matches("[ A-Za-záéíóúÁÉÍÓÚñÑ]{15,80}", nombre)) {
            throw new IllegalArgumentException("El nombre del titular no cumple con los requisitos.");
        }

        if (!validarDocumento(nif)) {
            throw new IllegalArgumentException("El NIF/CIF/NIE introducido no es válido.");
        }

        //compruebo si el pin introducido es valido
        if (!Pattern.matches("^\\d{4,}", pin)) {
            throw new IllegalArgumentException("El pin introducido no es válido.");
        }

        //compruebo si el limite se encuentra dentro del rango permitido
        if (limite < 500 || limite > 5000) {
            throw new IllegalArgumentException("El límite de gasto establecido no es válido.");
        }

        //compruebo que el numero de tarjeta sea correcto
        if (!comprobarNumeroTarjeta(numeroTarjeta)) {
            throw new IllegalArgumentException("El número de tarjeta introducido no es válido.");
        }

        //una vez validados los datos introducidos, los establezco en la tarjeta
        this.titular = nombre;
        this.nif = nif.toUpperCase();
        this.pin = pin;
        this.limite = limite;
        this.numeroTarjeta = numeroTarjeta;

        Calendar fechaActual = Calendar.getInstance();
        if ((fechaActual.get(Calendar.MONTH) + 1) < 10) {
            this.mesCaducidad = "0" + (fechaActual.get(Calendar.MONTH) + 1);
        } else {
            this.mesCaducidad = "" + (fechaActual.get(Calendar.MONTH) + 1);
        }

        this.añoCaducidad = "" + ((fechaActual.get(Calendar.YEAR) + 5));
        this.cvv = "" + calcRandomInt(100, 999);
    }

    /**
     * Metodo constructor copia que copia el estado de los atributos de una
     * tarjeta de credito en otra
     *
     * @param t la tarjeta de credito a copiar
     */
    public TarjetaCredito(TarjetaCredito t) {
        this(t.titular, t.nif, t.pin, t.limite, t.numeroTarjeta);
    }

    //defino metodos getter
    /**
     * Metodo getter que devuelve el nombre del titular de la tarjeta
     *
     * @return el nombre del titular de la tarjeta
     */
    public String getTitular() {
        return this.titular;
    }

    /**
     * Metodo getter que devuelve el nif del titular de la tarjeta
     *
     * @return el nif del titular de la tarjeta
     */
    public String getNif() {
        return this.nif;
    }

    /**
     * Metodo getter que devuelve el pin de la tarjeta
     *
     * @return el pin de la tarjeta
     */
    public String getPin() {
        return this.pin;
    }

    /**
     * Metodo getter que devuelve el limite de gasto de la tarjeta
     *
     * @return el limite de gasto de la tarjeta
     */
    public int getLimite() {
        return this.limite;
    }

    /**
     * Metodo getter que devuelve el mes de caducidad de la tarjeta
     *
     * @return el mes de caducidad de la tarjeta
     */
    public String getMesCaducidad() {
        return this.mesCaducidad;
    }

    /**
     * Metodo getter que devuelve el anio de caducidad de la tarjeta
     *
     * @return el anio de caducidad de la tarjeta
     */
    public String getAñoCaducidad() {
        return this.añoCaducidad;
    }

    /**
     * Metodo getter que devuelve el numero de la tarjeta
     *
     * @return el numero de la tarjeta
     */
    public String getNumeroTarjeta() {
        return this.numeroTarjeta;
    }

    /**
     * Metodo getter que devuelve el cvv de la tarjeta
     *
     * @return el cvv de la tarjeta
     */
    public String getCVV() {
        return this.cvv;
    }

    //defino metodos setter
    /**
     * Metodo setter para establecer el pin de una tarjeta de credito. Antes de
     * hacerlo se valida.
     *
     * @param pin el pin a establecer
     */
    public void setPin(String pin) {
        if (pin.length() >= 4 && Pattern.matches("^\\d+$", pin)) {
            this.pin = pin;
        }
    }

    /**
     * Metodo setter para establecer el limite de una tarjeta de credito. Antes
     * de hacerlo se valida.
     *
     * @param limite el limite a establecer
     */
    public void setLimite(int limite) {
        if (limite >= 500 && limite <= 5000) {
            this.limite = limite;
        }
    }

    /**
     * Metodo que permite realizar pagos con la tarjeta siempre y cuando sea una
     * cantidad valida.
     *
     * @param cantidad la cantidad a pagar
     * @param concepto el concepto a mostrar
     * @return true si la cantidad a gastar es valida
     * @throws IllegalArgumentException si la cantidad a gastar no es valida
     */
    public boolean pagar(double cantidad, String concepto) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad a gastar no válida");
        }
        if (!Pattern.matches(".{0,50}", concepto)) {
            throw new IllegalArgumentException("Concepto erróneo");
        }
        if (cantidad <= this.limite) {
            introducirMovimiento(cantidad, concepto);
        }

        return (cantidad <= this.limite);
    }

    /**
     * Metodo que permite ver la cantidad total gastada por la tarjeta de
     * credito.
     *
     * @return la cantidad total gastada de los ultimos 50 movimientos
     */
    public double gastado() {
        double gastado = 0;

        for (Movimiento movimiento : this.movimientos) {
            if (movimiento != null) {
                gastado += movimiento.getCantidad();
            }
        }

        return gastado;
    }

    /**
     * Metodo que muestra los ultimos movimientos realizados que el usuario pida
     * ver. Si hay menos movimientos de los que pide el usuario solo se
     * mostraran estos.
     *
     * @param numero el numero de ultimos movimientos a mostrar
     * @return string con la informacion de los ultimos, numero, movimientos
     * @throws IllegalArgumentException si el numero de movimientos es menor o
     * igual que 0 o mayor a los movimientos totales de la tarjeta.
     */
    public String movimientos(int numero) {
        if (numero > this.movimientos.length || numero <= 0) {
            throw new IllegalArgumentException("Número de movimientos solicitados incorrecto");
        }

        String messageMovimientos = "";

        for (int i = 0; i < numero; i++) {
            if (this.movimientos[i] != null) {
                messageMovimientos += this.movimientos[i] + "\n";
            }
        }

        return messageMovimientos;
    }

    /**
     * Metodo que muestra el numero de movimientos realizados por esa tarjeta de
     * credito.
     *
     * @return el numero de movimientos realizados
     */
    public int numeroMovimientos() {
        int cantMovimientos = 0;

        for (Movimiento movimiento : this.movimientos) {
            if (movimiento != null) {
                cantMovimientos++;
            }
        }

        return cantMovimientos;
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
    public static String obtenerDigitoControl(String numero) {

        return "" + (calcSumaPorNueve(numero) % 10);
    }

    @Override
    public String toString() {
        return "Titular= " + titular + ", NIF= " + nif + ", Caducidad= " + mesCaducidad + "/" + añoCaducidad + ", Número de Tarjeta= " + numeroTarjeta + ", Límite= " + limite + ", Total gastado= " + this.gastado();
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
        final TarjetaCredito other = (TarjetaCredito) obj;
        return Objects.equals(this.numeroTarjeta, other.numeroTarjeta);
    }

    /**
     * Metodo meditante el cual podemos introducir un nuevo movimiento en el
     * array de movimientos de nuestra tarjeta de credito. Funciona de forma que
     * los movimientos son desplazados un lugar a la derecha y el ultimo de
     * ellos es desechado, dejando el primer elemento vacio y situando en el al
     * nuevo movimiento.
     *
     * @param cantidad la cantidad gastada por el nuevo movimiento.
     * @param concepto el concepto del nuevo movimiento.
     */
    private void introducirMovimiento(double cantidad, String concepto) {
        //creo el nuevo movimiento a introducir
        Movimiento nuevo = new Movimiento(cantidad, concepto);
        //copio todos los movimientos excepto el ultimo el cual se perdera
        Movimiento[] conservar = Arrays.copyOfRange(this.movimientos, 0, this.movimientos.length - 1);

        //introduzco en los movimientos de la tarjeta el nuevo en primera posicion
        //seguido de los ultimos 49
        for (int elem = 0; elem < this.movimientos.length; elem++) {
            if (elem == 0) {
                this.movimientos[elem] = nuevo;
            } else {
                this.movimientos[elem] = conservar[elem - 1];
            }
        }

    }

    /**
     * Metodo estatico que genera un numero entero aleatorio de 3 cifras en un
     * rango determinado.
     *
     * @param tuNumIni numero a partir del cual se empezara a generar el
     * aleatorio. (incluido)
     * @param tuNumFin numero donde terminara la generacion del aleatorio
     * (incluido)
     * @return un numero entero aleatorio de tres cifras.
     */
    private static int calcRandomInt(int tuNumIni, int tuNumFin) {
        int numIni = tuNumIni;
        int numFin = tuNumFin + 1;
        double random = Math.random() * (numFin - numIni) + numIni;
        return (int) random;
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

}

/*MAIN
//        String numeroTarjeta = "1234567890123452";
//        String numero = "123456789012345";
//        String numeroTarjeta2 = "79927398721";
//        TarjetaCredito t1 = new TarjetaCredito("Heriberto Amezcua", "z1234567r", "1234", 1234, "1234567890123452");
//        TarjetaCredito t2 = new TarjetaCredito(t1);
//        Movimiento m = new Movimiento(1000, "Paga extra");
//        System.out.println(m);
//
//        t1.pagar(1000, "Armas para Iran");
//        t1.pagar(1000, "Armas para Irak");
//        t1.pagar(1000, "Armas para Oman");
//        t1.pagar(1000, "Armas para Armenia");
//        t1.pagar(1000, "Armas para Espana");
//        t1.pagar(1000, "Armas para Alemania");
//        t1.pagar(1000, "Armas para Francai");
//        t1.pagar(1000, "Armas para ROMA");
//        System.out.println(TarjetaCredito.obtenerDigitoControl(numero));
//
//        System.out.println(t1.toString());
//
//        System.out.println(t1);
//        System.out.println(t2);
 */
