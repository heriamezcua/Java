/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relacionejerciciossencillos1;

/**
 *
 * @author amezc
 */
public class Ejercicio13 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int euros = readEuros();
        int cantBill200 = getBill200(euros);
        euros -= cantBill200 * 200;
        int cantBill100 = getBill100(euros);
        euros -= cantBill100 * 100;
        int cantBill50 = getBill50(euros);
        euros -= cantBill50 * 50;
        int cantBill20 = getBill20(euros);
        euros -= cantBill20 * 20;
        int cantBill10 = getBill10(euros);
        euros -= cantBill10 * 10;
        int cantBill5 = getBill5(euros);
        euros -= cantBill5 * 5;

        if (cantBill200 == 1) {
            System.out.println("1 billete de 200");
        } else {
            System.out.println(cantBill200 + " billetes de 200");
        }

        if (cantBill100 == 1) {
            System.out.println("1 billete de 100");
        } else {
            System.out.println(cantBill100 + " billetes de 100");
        }

        if (cantBill50 == 1) {
            System.out.println("1 billete de 50");
        } else {
            System.out.println(cantBill50 + " billetes de 50");
        }

        if (cantBill20 == 1) {
            System.out.println("1 billete de 20");
        } else {
            System.out.println(cantBill20 + " billetes de 20");
        }

        if (cantBill10 == 1) {
            System.out.println("1 billete de 10");
        } else {
            System.out.println(cantBill10 + " billetes de 10");
        }

        if (cantBill5 == 1) {
            System.out.println("1 billete de 5");
        } else {
            System.out.println(cantBill5 + " billetes de 5");
        }

        if (euros == 1) {
            System.out.println("Sobra 1 euro");
        } else {
            System.out.println("Sobran " + euros + " euros");
        }
    }

    public static int readEuros() {

        int euros = funciones.LeerDatosTeclado.enterInt("Introduce cantidad de euros: ");

        if (euros <= 0) {
            throw new IllegalArgumentException("euros no pueden ser menor que 0");
        }

        return euros;
    }

    public static int getBill200(int x) {
        int euros = x;
        int cantBill200 = 0;

        while (euros >= 200) {
            cantBill200 += 1;
            euros -= 200;
        }

        return cantBill200;
    }

    public static int getBill100(int x) {
        int euros = x;
        int cantBill100 = 0;

        while (euros >= 100) {
            cantBill100 += 1;
            euros -= 100;
        }

        return cantBill100;
    }

    public static int getBill50(int x) {
        int euros = x;
        int cantBill50 = 0;

        while (euros >= 50) {
            cantBill50 += 1;
            euros -= 50;
        }

        return cantBill50;
    }

    public static int getBill20(int x) {
        int euros = x;
        int cantBill20 = 0;

        while (euros >= 20) {
            cantBill20 += 1;
            euros -= 20;
        }

        return cantBill20;
    }

    public static int getBill10(int x) {
        int euros = x;
        int cantBill10 = 0;

        while (euros >= 10) {
            cantBill10 += 1;
            euros -= 10;
        }

        return cantBill10;
    }

    public static int getBill5(int x) {
        int euros = x;
        int cantBill5 = 0;

        while (euros >= 5) {
            cantBill5 += 1;
            euros -= 5;
        }

        return cantBill5;
    }

}