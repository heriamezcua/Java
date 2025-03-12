package _01_basic._ex01_fundamentals1;

import java.math.BigInteger;

/*
 * Program that calcs the sums of the multiples of 5 in the
 * range -50 - +50 and the number of odds and even 
 */
public class Ex15 {

	public static void main(String[] args) {

		int sumMult5 = getMult5Sum();
		int numEven = getEven();
		BigInteger numOdd = getNegProdNum();
		
		System.out.printf("In the range -50 - +50\nSummation of multiples of 5: %d"
				+ "\nAmount of even numbers: %d\nProduct of negative numbers: %d", sumMult5, numEven, numOdd);
	}
	
	   public static int getMult5Sum() {
	        int multSum5 = 0;

	        for (int i = -50; i <= 50; i++) {
	            if (i % 5 == 0) {
	            	multSum5 += i;
	            }
	        }

	        return multSum5;
	    }

	    public static int getEven() {
	        int even = 0;

	        for (int i = -50; i <= 50; i++) {
	            if (i % 2 == 0 && i != 0) {
	                even += 1;
	            }
	        }

	        return even;
	    }

	    public static BigInteger getNegProdNum() {

	        BigInteger negProd = BigInteger.ONE;

	        for (int i = -50; i <= 50; i++) {
	            if (i < 0) {
	            	negProd = negProd.multiply(BigInteger.valueOf(2));
	            }
	        }

	        return negProd;

	    }

}
