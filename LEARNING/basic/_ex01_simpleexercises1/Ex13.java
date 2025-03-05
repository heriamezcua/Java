package basic._ex01_simpleexercises1;

import basic.utilis.ReadKBData;

/*
 * Program that counts the number of bills you have with an entered amount
 */
public class Ex13 {

	public static void main(String[] args) {

		// entering a positive euro amount
		int eur = ReadKBData.enterInt("Enter an euros amount: ");
		do {
			if (eur <= 0) {
				System.err.println("Amount must be positive!");
				eur = ReadKBData.enterInt("Enter an euros amount: ");
			}
		} while (eur <= 0);

		// calc every exact bill
		int amountBill200 = getBill200(eur);
		eur -= amountBill200 * 200;
		int amountBill100 = getBill100(eur);
		eur -= amountBill100 * 100;
		int amountBill50 = getBill50(eur);
		eur -= amountBill50 * 50;
		int amountBill20 = getBill20(eur);
		eur -= amountBill20 * 20;
		int amountBill10 = getBill10(eur);
		eur -= amountBill10 * 10;
		int amountBill5 = getBill5(eur);
		eur -= amountBill5 * 5;
		
		// printing the result
	    printBills(amountBill200, 200);
	    printBills(amountBill100, 100);
	    printBills(amountBill50, 50);
	    printBills(amountBill20, 20);
	    printBills(amountBill10, 10);
	    printBills(amountBill5, 5);
		
	    // Print coins
	    if (eur == 1) {
	        System.out.println("1 euro left");
	    } else if (eur > 1) {
	        System.out.println(eur + " euros left");
	    }

	}

	public static int getBill200(int eur) {
		int amountBill200 = 0;

		while (eur >= 200) {
			amountBill200 += 1;
			eur -= 200;
		}

		return amountBill200;
	}
	
	public static int getBill100(int eur) {
		int amountBill100 = 0;

		while (eur >= 50) {
			amountBill100 += 1;
			eur -= 100;
		}

		return amountBill100;
	}

	public static int getBill50(int eur) {
		int amountBill50 = 0;

		while (eur >= 50) {
			amountBill50 += 1;
			eur -= 50;
		}

		return amountBill50;
	}

	public static int getBill20(int eur) {
		int amountBill20 = 0;

		while (eur >= 20) {
			amountBill20 += 1;
			eur -= 20;
		}

		return amountBill20;
	}

	public static int getBill10(int eur) {
		int amountBill10 = 0;

		while (eur >= 10) {
			amountBill10 += 1;
			eur -= 10;
		}

		return amountBill10;
	}

	public static int getBill5(int eur) {
		int amountBill5 = 0;

		while (eur >= 5) {
			amountBill5 += 1;
			eur -= 5;
		}

		return amountBill5;
	}

	public static void printBills(int amount, int value) {
		if (amount == 1) {
			System.out.println("1 bill of " + value);
		} else if (amount > 1) {
			System.out.println(amount + " bills of " + value);
		}
	}
}
