/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tresenraya.funciones;

/**
 *
 * @author amezc
 */
public class Calcular {
    
    public static int calcRandomInt(int tuNumIni, int tuNumFin){
        int numIni= tuNumIni-1;
        int numFin= tuNumFin+1;
        double random= Math.random()*(numFin-numIni)+numIni;
        return (int)random;
    }
}
