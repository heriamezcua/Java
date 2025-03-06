/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package relacionobjetos2;

/**
 *
 * @author amezc
 */
public class Nif {

    private int numero;
    private String letra;

    /**
     * Metodo constructor por defecto que crea el NIF de una persona
     * inicializado su atributo numero a 0 y su atributo letra a espacio.
     */
    public Nif() {
        this.numero = 0;
        this.letra = " ";
    }

    /**
     * Metodo constructor que crea el NIF de una persona, introduciendo el
     * numero por parámetro y a partir de este con un algoritmo establecer la
     * letra del NIF.
     *
     * @param numero el numero del NIFF
     * @throws IllegalArgumentException si el rango del numero menor o igual que
     * cero o mayor 99999999
     */
    public Nif(int numero) {
        if (numero <= 0 && numero > 99999999) {
            throw new IllegalArgumentException("Rango de numero incorrecto");
        }

        this.numero = numero;
        this.letra = generarLetra(this.numero);
    }

    /**
     * Metodo privado que genera una letra dependiendo del resultado del resto
     * del numero del NIF con 23.
     *
     * @param n el numero de NIF
     * @return la letra del NIF tipo String
     */
    private String generarLetra(int n) {
        int resto = n % 23;
        String letra = "";

        switch (resto) {
            case 0:
                letra = "T";
                break;
            case 1:
                letra = "R";
                break;
            case 2:
                letra = "W";
                break;
            case 3:
                letra = "A";
                break;
            case 4:
                letra = "G";
                break;
            case 5:
                letra = "M";
                break;
            case 6:
                letra = "Y";
                break;
            case 7:
                letra = "F";
                break;
            case 8:
                letra = "P";
                break;
            case 9:
                letra = "D";
                break;
            case 10:
                letra = "X";
                break;
            case 11:
                letra = "B";
                break;
            case 12:
                letra = "N";
                break;
            case 13:
                letra = "J";
                break;
            case 14:
                letra = "Z";
                break;
            case 15:
                letra = "S";
                break;
            case 16:
                letra = "Q";
                break;
            case 17:
                letra = "V";
                break;
            case 18:
                letra = "H";
                break;
            case 19:
                letra = "L";
                break;
            case 20:
                letra = "C";
                break;
            case 21:
                letra = "K";
                break;
            case 22:
                letra = "E";
                break;
        }

        return letra;

    }

    /**
     * Metodo que devuelve el numero del NIF.
     *
     * @return el numero de NIF
     */
    public int getNumeroNIF() {
        return this.numero;
    }

    /**
     * Metodo que devuelve la letra del NIF.
     *
     * @return la letra del NIF
     */
    public String getLetraNIF() {
        return this.letra;
    }

    /**
     * Metodo que establece el numero de NIF introducido por parámetro.F
     *
     * @param n el numero que queremos que sea el del NIF
     * @throws IllegalArgumentException si el rango del numero menor o igual que
     * cero o mayor 99999999
     */
    public void setNumeroNIF(int n) {
        if (n < 0 || n > 99999999) {
            throw new IllegalArgumentException("Rango de numero incorrecto");
        }
        this.numero = n;
    }

    /**
     * Metodo que establece la letra del NIF, habría que validar la letra ya
     * pero como voy justo de tiempo lo dejo para otro momento.
     *
     * @param l la letra que el usuario quiere que tenga el NIF
     */
    public void setLetraNIF(String l) {
        this.letra = l;
    }

    @Override
    public String toString() {
        return "Numero=" + numero + ", Letra=" + letra;
    }

}


/*MAIN

        Nif nif1 = new Nif();
        Nif nif2 = new Nif(12345678);

        System.out.println("NIF de Juan: " + nif1);
        System.out.println("NIF de Jose: " + nif2);
        nif1.setLetraNIF("H");
        nif1.setNumeroNIF(69);
        System.out.println(nif1.getLetraNIF());
        System.out.println("NIF de Juan: " + nif1);
        System.out.println(nif2.getNumeroNIF());
 */
