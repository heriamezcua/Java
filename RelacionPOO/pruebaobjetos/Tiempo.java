/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebaobjetos;

/**
 *
 * @author Hoxuro
 */
public class Tiempo {

    private int horas, minutos, segundos;

    public Tiempo(int horas, int minutos, int segundos) {
        validarDatos(horas, minutos, segundos);

        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    private void validarDatos(int horas1, int minutos1, int segundos1) {
        if (!validarHoras(horas1)) {
            throw new AssertionError("Rango de horas erroneo");
        }
        if (!validarMinutos(minutos1)) {
            throw new AssertionError("Rango de horas erroneo");
        }
        if (!validarSegundos(segundos1)) {
            throw new AssertionError("Rango de horas erroneo");
        }
    }

    private boolean validarHoras(int horas) {
        return horas >= 0;
    }

    private boolean validarMinutos(int minutos) {
        return minutos >= 0 && minutos <= 59;
    }

    private boolean validarSegundos(int horas) {
        return segundos >= 0 && segundos <= 59;
    }

    public void suma(int horas, int minutos, int segundos) {
        validarDatos(horas, minutos, segundos);
        int segundosTotales = segundosTotales(this.horas, this.minutos, this.segundos);
        segundosTotales += segundosTotales(horas, minutos, segundos);

        int[] desglose = desglosarSegundos(segundosTotales);
        this.horas = desglose[0];
        this.minutos = desglose[1];
        this.segundos = desglose[2];
    }

    public void resta(int horas, int minutos, int segundos) {
        validarDatos(horas, minutos, segundos);
    }

    @Override
    public String toString() {
        return horas + "h " + minutos + "m " + segundos + "s";
    }

    private int segundosTotales(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }

    private int[] desglosarSegundos(int segundos) {
        int[] tiempoDesglosado = new int[3];

        tiempoDesglosado[0] = segundos / 3600;
        segundos = segundos % 3600;
        tiempoDesglosado[1] = segundos / 60;
        tiempoDesglosado[2] = segundos % 60;

        return tiempoDesglosado;
    }

}
