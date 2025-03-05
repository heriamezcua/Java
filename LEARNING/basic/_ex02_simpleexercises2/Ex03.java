package basic._ex02_simpleexercises2;

/*
 * Program that prints the perfect numbers from 1 to 100.
 * A perfect number is a positive integer that is equal to the 
 * sum of its proper divisors
 */
public class Ex03 {

	public static void main(String[] args) {
		System.out.println("Perfect numbers from 1 to 100:");
		int divisors = 0;

		for (int i = 1; i < 100; i++) {
			divisors = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					divisors += j;
				}

				if (divisors == i && j == (i - 1)) {
					System.out.println(i + " ");
				}
			}
		}

	}

}
