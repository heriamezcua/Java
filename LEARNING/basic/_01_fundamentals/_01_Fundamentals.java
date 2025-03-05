package basic._01_fundamentals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class _01_Fundamentals {

	public static void main(String[] args) {

		// Primitive data types (most common)
		int num1 = 12;
		float num2 = 22.2f;
		double num3 = 2.32;
		boolean isBoolean = true;
		char character = 'o';

		// integer numbers (all are primitives)
		byte numByte = 1;
		short numShort = 1;
		int numInt = 1;
		long numLong = 1L;

		// real numbers
		float numFloat = 22.2f; // to avoid conflict must use f
		double numDouble = 2.32;

		// ** rules to noun variables **
		// variables —> numAlumnos
		// Constants —> TAMANO_MAX
		// Class —> MiClase
		// functions/methods —> calcularSuma()

		// CONSTANTS
		final double PI_CONSTANT = 3.14;

		// LITERALS

		boolean litBool = true; // or false
		char litChar = 'a';
		char litChar2 = '\u039A';
		float litFloat = 22.2f;
		double litDouble = 2.32;

		// CASTING
		int numero = (int) Math.random() * 10; // casting from double to int

		// OPERATORS
		// // ARITMETIC : + - * / %

		// // UNARY : ++expr --expr expr++ expr-- +expr -expr ~ !

		// // SHIFT : << >> >>>

		// // ASSIGNMENT : = += -= *= /= %= &= ^= |= <<= >>= >>>=

		// // CONDITIONALS : == != < > <= >=

		// TERNARY OPERATOR
		String esPar = (3 % 2 == 0) ? "PAR" : "IMPAR";

		// // LOGIC && || !

		// // BITWISE & | ^ ~ << >> >>>

		// ASSOCIATION RULE
		// a = b = c = 1
		// (a = (b = (c = 1)))

		// CONSOLE DATA INTRODUCTION
		Scanner input = new Scanner(System.in);

		input.next(); // string

		input.nextInt(); // int

		input.nextDouble(); // double

		input.nextBoolean(); // boolean

		input.hasNext(); // Check if you still have an input

		// CONSOLE DATA OUTPUT

		System.out.print(""); // normal output without formatting

		System.out.println(); // output with line break at end

		System.out.printf("%8.2f", 2.33); // print x with a field width of 8 characters and a precision of 2

		System.out.printf("Hello, %s. Next year, you'll be %d", "HERI", 22); // Multiple parameters can be set.

		// BIG NUMBERS
		BigInteger muyGrande = new BigInteger("12312312312");
		BigDecimal otroGrande = new BigDecimal("12312312312.22");

		// .valueOf()

		// REDONDEO DE BIGS
		// divide(BigDecimal divisor, int scale, RoundingMode roundingMode) 2 decimales
		// de redondeo
		BigDecimal result = otroGrande.divide(otroGrande, 2, RoundingMode.HALF_UP);

		// FLOW STRUCTURES

		// IF - ELSE
		if (true) {

		}

		if (true) {

		} else {

		}

		if (litBool) {

		} else if (litBool) {

		} else {

		}

		// SWITCH
		switch (1) {
		case 1: {
			// instructions
			break;
		}
		default:
			// in case of not matching
		}

		// FOR
		for (int i = 0; i < 10; i++) {

		}

		// WHILE
		while (true) {

		}

		// DO WHILE
//		do {
//			
//		} while (true);
		
	}

}
