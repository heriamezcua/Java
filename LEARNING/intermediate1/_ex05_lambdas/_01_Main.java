package intermediate1._ex05_lambdas;

/**
 * Create a functional interface called Operation with a method calculate(int a,
 * int b). Then, use lambda expressions to perform the following operations:
 * addition, subtraction, multiplication, and division.
 */
public class _01_Main {

	public static void main(String[] args) {
		_01_Operation add = (a, b) -> a + b;
		System.out.println("Add:" + add.calculate(3, 4));

		_01_Operation diff = (a, b) -> a - b;
		System.out.println("Diff:" + diff.calculate(3, 4));

		_01_Operation mult = (a, b) -> a * b;
		System.out.println("Mult:" + mult.calculate(3, 4));

		_01_Operation div = (a, b) -> a / b;
		System.out.println("Div:" + div.calculate(3, 3));
	}

}
