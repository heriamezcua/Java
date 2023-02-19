/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conjunto;

import java.util.Arrays;

/**
 * Clase que nos permite crear un conjunto y realizar distintas operaciones con
 * el siguiendo las normas correspondientes a los conjuntos.
 *
 * @author Hoxuro
 * @since JDK 19
 */
public class ConjuntoOrdenadoEnteros {

    private int[] conjunto;
    private int elementos;

    /**
     * Crea un ConjuntoOrdenadoEnteros cuya capacidad la introduce el usuario y
     * el numero de elementos es cero.
     *
     * @param capacidad la capacidad que queremos que tenga el conjunto
     */
    public ConjuntoOrdenadoEnteros(int capacidad) {
        this.conjunto = new int[capacidad];
        this.elementos = 0;
    }

    /**
     * Contruye por defecto un ConjuntoOrdenadoEnteros cuya capacidad es 100 y
     * sus elementos son 0.
     */
    public ConjuntoOrdenadoEnteros() {
        this(100);
    }

    /**
     * copia exactamente igual un objeto ConjuntoOrdenadoEnteros en otro.
     *
     * @param c el objeto conjunto a copiar
     */
    public ConjuntoOrdenadoEnteros(ConjuntoOrdenadoEnteros c) {
        this(c.conjunto.length);
        c.elementos = this.elementos;
    }

    /**
     * Aniade el valor introducido por el usuario al conjunto. Además ordena el
     * conjunto de forma que los ceros se situen al final. Si el valor existe
     * ya, no se aniadira nada.
     *
     * @param valor el elemento que queremos introducir en el conjunto
     */
    public void add(int valor) {
        order(this.conjunto);
        int indice = Arrays.binarySearch(this.conjunto, valor);

        for (int elem = 0; elem < this.conjunto.length - 1; elem++) {
            if (this.conjunto[elem] == 0) {
                int sigElem = elem + 1;
                this.conjunto[elem] = this.conjunto[sigElem];
                this.conjunto[sigElem] = 0;
            }
        }

        if (indice < 0) {
            boolean colocado = false;
            int elem = 0;
            while (!colocado && elem != this.conjunto.length) {

                if (this.conjunto[elem] > valor || this.conjunto[elem] == 0) {

                    int[] mitad1 = new int[elem];
                    int[] mitad2 = new int[this.conjunto.length - elem - 1];
                    System.arraycopy(this.conjunto, 0, mitad1, 0, elem);
                    System.arraycopy(this.conjunto, elem, mitad2, 0, mitad2.length);

                    this.conjunto[elem] = valor;

                    System.arraycopy(mitad1, 0, this.conjunto, 0, mitad1.length);
                    System.arraycopy(mitad2, 0, this.conjunto, elem + 1, mitad2.length);
                    colocado = true;
                }
                elem++;
            }

        }
        order(this.conjunto);
        cerosFinal(this.conjunto);
    }

    /**
     * Devuelve la posicion del elemento cuyo valor coincide con el introducido
     * por el usuario.
     *
     * @param valor el valor del elemento cuya posicion queremos saber
     * @return el indice del array del elemento cuyo valor coincide con el
     * introducido
     */
    public int search(int valor) {
        int[] copia = new int[this.conjunto.length];
        System.arraycopy(this.conjunto, 0, copia, 0, copia.length);
        order(copia);
        int indice = Arrays.binarySearch(copia, valor);
        if (indice < 0) {
            indice = -1;
        }

        return indice;
    }

    /**
     * Elimina la el elemento del array cuya posicion introduce el usuario.
     *
     * @param posicion la posicion donde esta el elemento que queremos eliminar
     * @return el elemento eliminado
     * @throws IllegalArgumentException si la posicion no es correcta
     */
    public int del(int posicion) {
        if (posicion > this.conjunto.length) {
            throw new IllegalArgumentException("Posicion incorrecta");
        }
        int aux = this.conjunto[posicion];
        this.conjunto[posicion] = 0;

        int[] mitad1 = new int[posicion];
        int[] mitad2 = new int[this.conjunto.length - posicion];
        System.arraycopy(this.conjunto, 0, mitad1, 0, posicion);
        System.arraycopy(this.conjunto, posicion + 1, mitad2, 0, mitad2.length - 1);

        System.arraycopy(mitad1, 0, this.conjunto, 0, mitad1.length);
        System.arraycopy(mitad2, 0, this.conjunto, posicion, mitad2.length - 1);

        return aux;
    }

    /**
     * Devuelve un subconjunto que esta incluido en el conjunto del objeto cuyas
     * posiciones son indicadas por el usuario.
     *
     * @param indiceInicial el indice donde se empezara a copiar el subconjunto
     * @param indiceFinal el indice donde se terminara de copiar el subconjunto
     * (excluido)
     * @return un subconjunto incluido en el conjunto
     */
    public ConjuntoOrdenadoEnteros subconjunto(int indiceInicial, int indiceFinal) {
        ConjuntoOrdenadoEnteros c = new ConjuntoOrdenadoEnteros(this.conjunto.length);
        c.elementos = this.elementos;
        int longitud = indiceFinal - indiceInicial + 1;
        System.arraycopy(this.conjunto, indiceInicial, c.conjunto, 0, indiceFinal);

        return c;
    }

    /**
     * devuelve el conjunto de numeros enteros del objeto.
     *
     * @return un array de tipo entero
     */
    public int[] getConjunto() {
        return conjunto;
    }

    /**
     * devuelve el numero de elementos que caben en el conjunto.
     *
     * @return el numero de elementos que caben en el conjunto
     */
    public int getElementos() {
        return elementos;
    }

    /**
     * Pone todos los ceros del array al final.
     *
     * @param array el array al que quieres poner los ceros al final
     */
    public static void cerosFinal(int[] array) {

        int iteraciones = array.length;
        while (iteraciones != 0) {
            for (int elem = 0; elem < array.length; elem++) {
                if (array[elem] == 0) {
                    int sigElem = elem + 1;

                    if (sigElem != array.length) {
                        array[elem] = array[sigElem];
                        array[sigElem] = 0;
                    }
                }
            }
            iteraciones--;
        }

    }

    /**
     * Sorts the entered array in ascending order.
     *
     * @param array the array that we want to sort
     */
    private static void order(int[] array) {

        //for each element of the array
        for (int elem = 0; elem < array.length; elem++) {
            //I get the value of the following element
            int nextElem = elem + 1;

            //as long as the next element is less than the length of the array
            while (nextElem < array.length) {
                //if the next element is less than the current element
                if (array[nextElem] < array[elem]) {
                    //exchange positions
                    int container = array[elem];
                    array[elem] = array[nextElem];
                    array[nextElem] = container;
                }

                nextElem++;
            }
        }

    }

}
