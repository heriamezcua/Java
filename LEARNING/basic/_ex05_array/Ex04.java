package basic._ex05_array;

import basic.hah.MyArray;
import basic.hah.ReadKBData;

/*
 * Program where an array of 100 elements is filled with 
 * random numbers in the range you enter
 */
public class Ex04 {

	public static void main(String[] args) {
		
		int iniNum = ReadKBData.enterInt("Enter starting number for random generation range:");
		int finNum = ReadKBData.enterInt("Enter ending number for random generation range:");

        int[] numero = MyArray.fillRandom(100, iniNum, finNum);
        int[] cuadrado = MyArray.fillSquare(numero);
        int[] cubo = MyArray.fillCubes(numero);

        MyArray.display(numero);
        MyArray.display(cuadrado);
        MyArray.display(cubo);
		
	}

}
