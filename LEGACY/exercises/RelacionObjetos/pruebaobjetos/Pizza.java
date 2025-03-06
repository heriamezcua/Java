/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaobjetos;

/**
 *
 * @author amezc
 */
public class Pizza {

    private String tamanio, tipo, estado;
    private static int pizzasPedidas, pizzasServidas;

//    private enum Tamanios {
//        MEDIANA, FAMILIAR
//    }
//
//    private enum Tipos {
//        MARGARITA, CUATRO_QUESOS, FUNGHI
//    }
//
//    private enum Estados {
//        PEDIDA, SERVIDA
//    }
    public Pizza(String tamanio, String tipo, String estado) {
        if (!validarTamanio(tamanio)) {
            throw new IllegalArgumentException("tamanio incorrecto");
        }
        if (!validarTipo(tipo)) {
            throw new IllegalArgumentException("tipo incorrecto");
        }
        if (!validarEstado(estado)) {
            throw new IllegalArgumentException("estado incorrecto");
        }
        if (estado.toLowerCase().equals("pedida")) {
            Pizza.pizzasPedidas++;
        } else if (estado.toLowerCase().equals("servida")) {
            Pizza.pizzasServidas++;
        } else {
            throw new IllegalArgumentException("estado de pizza incorrecto");
        }

        this.tamanio = tamanio;
        this.tipo = tipo;
        this.estado = estado;
    }

    public boolean validarTamanio(String tamanio) {
        tamanio = tamanio.toUpperCase();
        return (tamanio.equals("MEDIANA") || tamanio.equals("FAMILIAR"));
    }

    public boolean validarTipo(String tipo) {
        tipo = tipo.toUpperCase();
        return (tipo.equals("MARGARITA") || tipo.equals("CUATRO QUESOS")
                || tipo.equals("FUNGHI"));
    }

    public boolean validarEstado(String estado) {
        estado = estado.toUpperCase();
        return (estado.equals("PEDIDA") || estado.equals("SERVIDA"));
    }

    public String sirve(Pizza p) {
        p.estado = "servido";
        return "Esa pizza se ha servido";
    }

    public static int getTotalPedidas() {
        return Pizza.pizzasPedidas;
    }

    public static int getTotalServidas() {
        return Pizza.pizzasServidas;
    }

}
