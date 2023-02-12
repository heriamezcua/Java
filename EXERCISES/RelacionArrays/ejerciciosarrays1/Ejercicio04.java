/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosarrays1;

/**
 *
 * @author amezc
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int iniNum = funciones.LeerDatosTeclado.enterInt("Introduce numero inicio rango generacion aleatorio:");
        int finNum = funciones.LeerDatosTeclado.enterInt("Introduce numero final rango generacion aleatorio:");
        int[] numero = funciones.FuncionesArray.crearArrayRandom(100, iniNum, finNum);
        int[] cuadrado = funciones.FuncionesArray.fillCuadrados(numero);
        int[] cubo = funciones.FuncionesArray.fillCubos(numero);

        funciones.FuncionesArray.mostrarArrayPantalla(numero);
        funciones.FuncionesArray.mostrarArrayPantalla(cuadrado);
        funciones.FuncionesArray.mostrarArrayPantalla(cubo);
    }

}
