package _01_basic._ex01_fundamentals1;

import _01_basic.hah.ReadKBData;

/*
 * Program that calcs the km realized by a taxi and it's cost
 */
public class Ex18 {

	public static void main(String[] args) {
		int km = ReadKBData.enterInt("Enter the number of kilometers traveled: ");
		do {
		    if (km <= 0) {
		        System.err.println("Kilometers cannot be negative");
		        km = ReadKBData.enterInt("Enter the number of kilometers traveled: ");
		    }
		} while (km <= 0);

		int cost = calcCost(km);

		System.out.printf("%d Km traveled\nCost: %d€", km, cost);
	}

	   public static int calcCost(int km) {
		   int cost = 500;

		   if (km > 300) {
		       if (km <= 1000) {
		           cost += (km - 300) * 2;
		       } else {
		           cost += 700 * 2;
		           cost += (km - 1000);
		       }
		   }

		   return cost;
	    }
	
}
