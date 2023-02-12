/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos2;

import java.util.regex.*;

/**
 * Clase que contiene distintos metodos static para poder validar las
 * identificaciones NIF NIE o CIF.
 *
 * @author Heriberto Amezcua
 */
public class ValidarIdentificacion {

    /**
     * Metodo estatico que comprueba que tipo de identificacion nos ha
     * introducido el usuario pudiendo ser NIF, NIE o CIF.
     *
     * @param identificacion la identificacion introducida por el usuario.
     * @return el tipo de identificacion
     * @throws IllegalArgumentException si el documento de identificacion
     * introducido no es correcto
     */
    public static String tipoIdentificacion(String identificacion) {
        String tipoId = "";
        if (!(identificacion.length() == 9)) {
            throw new IllegalArgumentException("El documento de identificacion introducido no es correcto");
        }

        if (Pattern.matches("[x-zX-Z]", Character.toString(identificacion.charAt(0)))) {
            tipoId += "nie";
        } else if (Pattern.matches("[a-wA-W]", Character.toString(identificacion.charAt(0)))) {
            tipoId += "cif";
        } else {
            tipoId += "nif";
        }

        return tipoId;
    }

    /**
     * Metodo estatico que comprueba si el NIF introducido es valido.
     *
     * @param nif el NIF introducido por el usuario.
     * @return true si el NIF es valido
     * @throws IllegalArgumentException si el numero del NIF no es correcto.
     * @throws IllegalArgumentException si el digito de control no concuerda con
     * el numero.
     */
    public static boolean nifEsValido(String nif) {

        //valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+$", nif.substring(0, 8))) {
            throw new IllegalArgumentException("El numero de NIF introducido no es correcto");
        }

        int numero = Integer.parseInt(nif.substring(0, 8));
        String digitoControl = Character.toString(nif.charAt(8)).toUpperCase();

        //valido que el digito de control introducido concuerde con el numero
        if (!generarDigitoControl(numero).equals(digitoControl)) {
            throw new IllegalArgumentException("El digito de control no concuerda con el numero");
        }

        return true;
    }

    /**
     * Metodo estatico que comprueba si el NIE introducido es valido.
     *
     * @param nie el NIE introducido por el usuario
     * @return true si el NIE es valido
     * @throws IllegalArgumentException si el numero del NIE no es correcto.
     * @throws IllegalArgumentException si el digito de control no concuerda con
     * el numero.
     */
    public static boolean nieEsValido(String nie) {

        //valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+$", nie.substring(1, 8))) {
            throw new IllegalArgumentException("El numero de NIE introducido no es correcto");
        }

        String letra = Character.toString(nie.charAt(0)).toUpperCase();
        int numero;

        //Dependiendo del tipo de letra aplicare una u otra forma para calcular el numero equivalente en NIF
        switch (letra) {
            case "Y":
                numero = (int) Math.pow(10, 7) + Integer.parseInt(nie.substring(1, 8));
                break;
            case "Z":
                numero = (int) Math.pow(10, 7) * 2 + Integer.parseInt(nie.substring(1, 8));
                break;
            default:
                numero = Integer.parseInt(nie.substring(1, 8));
        }

        String digitoControl = Character.toString(nie.charAt(8)).toUpperCase();

        //valido que el digito de control introducido concuerde con el numero
        if (!generarDigitoControl(numero).equals(digitoControl)) {
            throw new IllegalArgumentException("El digito de control no concuerda con el numero");
        }

        return true;
    }

    /**
     * Metodo estatico que comprueba si el CIF introducido es valido.
     *
     * @param cif el CIF introducido por el usuario
     * @return true si el CIF es valido
     * @throws IllegalArgumentException si la letra del tipo de organizacion no
     * sea correcta o este obsoleta
     * @throws IllegalArgumentException si el numero de CIF no sea correcto
     * @throws IllegalArgumentException si el codigo provincial introducido no
     * es correcto
     * @throws IllegalArgumentException si digito de control no concuerda con
     * los demas datos
     */
    public static boolean cifEsValido(String cif) {

        //valido que la letra del tipo de organizacion sea correcta
        if (!Pattern.matches("[[a-wA-W]&&[^iIoOtT]]", Character.toString(cif.charAt(0)))) {
            throw new IllegalArgumentException("Letra del tipo de organizacion introducida no es correcta");
        }

        //valido que la letra del tipo de organizacion no sea de las que han quedado obsoletas
        if (!Pattern.matches("[^kKlLmM]", Character.toString(cif.charAt(0)))) {
            throw new IllegalArgumentException("Letra del tipo de organizacion introducida no es correcta");
        }

        //valido que el numero solo se componga de digitos
        if (!Pattern.matches("^\\d+$", cif.substring(1, 8))) {
            throw new IllegalArgumentException("El numero de CIF introducido no es correcto");
        }

        //valido que el codigo provincial exista
        int codigoProvincial = Integer.parseInt(cif.substring(1, 3));
        if ((codigoProvincial >= 65 && codigoProvincial <= 69) || (codigoProvincial >= 86 && codigoProvincial <= 90)) {
            throw new IllegalArgumentException("El codigo provincial introducido no es correcto");
        }

        String digitoControl = Character.toString(cif.charAt(8)).toUpperCase();
        String digitosCentrales = cif.substring(1, 8);
        String tipoOrg = Character.toString(cif.charAt(0)).toUpperCase();

        //compruebo que el digito de control introducido se corresponda con los datos introducidos
        if (!generarDigitoControlCIF(tipoOrg, digitosCentrales).equals(digitoControl)) {
            throw new IllegalArgumentException("El digito de control no concuerda");
        }

        return true;
    }

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
            case 0:
                digitoControl = "T";
                break;
            case 1:
                digitoControl = "R";
                break;
            case 2:
                digitoControl = "W";
                break;
            case 3:
                digitoControl = "A";
                break;
            case 4:
                digitoControl = "G";
                break;
            case 5:
                digitoControl = "M";
                break;
            case 6:
                digitoControl = "Y";
                break;
            case 7:
                digitoControl = "F";
                break;
            case 8:
                digitoControl = "P";
                break;
            case 9:
                digitoControl = "D";
                break;
            case 10:
                digitoControl = "X";
                break;
            case 11:
                digitoControl = "B";
                break;
            case 12:
                digitoControl = "N";
                break;
            case 13:
                digitoControl = "J";
                break;
            case 14:
                digitoControl = "Z";
                break;
            case 15:
                digitoControl = "S";
                break;
            case 16:
                digitoControl = "Q";
                break;
            case 17:
                digitoControl = "V";
                break;
            case 18:
                digitoControl = "H";
                break;
            case 19:
                digitoControl = "L";
                break;
            case 20:
                digitoControl = "C";
                break;
            case 21:
                digitoControl = "K";
                break;
            case 22:
                digitoControl = "E";
                break;
        }

        return digitoControl;
    }

    public static String generarDigitoControlCIF(String tipoOrg, String digitos) {
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
                        : Integer.parseInt(Character.toString(digitoMultiplicado.charAt(0))) + Integer.parseInt(Character.toString(digitoMultiplicado.charAt(1)));
            }
        }

        sumaParcial = sumaPares + sumaImpares;

        //extraigo las unidades de la suma parcial
        int unidadesSumaParcial = sumaParcial % 10;

        //en el source 11 multiples casos a la vez no estan permitidos por lo que tengo que crear una instruccion distinta para cada caso
        //Obtengo el digito de control dependiendo de la letra del tipo de organizacion
        switch (tipoOrg) {
            case "A":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "B":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "C":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "D":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "E":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "F":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "G":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "H":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "J":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "U":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "V":
                digitoControl = "" + (10 - unidadesSumaParcial);
                break;
            case "N":
                digitoControl = letraControl(10 - unidadesSumaParcial);
                break;
            case "P":
                digitoControl = letraControl(10 - unidadesSumaParcial);
                break;
            case "Q":
                digitoControl = letraControl(10 - unidadesSumaParcial);
                break;
            case "R":
                digitoControl = letraControl(10 - unidadesSumaParcial);
                break;
            case "S":
                digitoControl = letraControl(10 - unidadesSumaParcial);
                break;
            case "W":
                digitoControl = letraControl(10 - unidadesSumaParcial);
                break;
        }

        return digitoControl;
    }

    /**
     * Metodo estatico que calcula el digito de control cuando es una letra de
     * un CIF.
     *
     * @param n el numero resultante de restar 10 menos las unidades de la suma
     * parcial del algoritmo para calcular el CIF
     * @return el digito de control cuando es una letra
     */
    public static String letraControl(int n) {
        String letraControl = "";
        switch (n) {
            case 0:
                letraControl = "J";
                break;
            case 1:
                letraControl = "A";
                break;
            case 2:
                letraControl = "B";
                break;
            case 3:
                letraControl = "C";
                break;
            case 4:
                letraControl = "D";
                break;
            case 5:
                letraControl = "E";
                break;
            case 6:
                letraControl = "F";
                break;
            case 7:
                letraControl = "G";
                break;
            case 8:
                letraControl = "H";
                break;
            case 9:
                letraControl = "I";
                break;
            case 10:
                letraControl = "J";
                break;
        }

        return letraControl;
    }

}
