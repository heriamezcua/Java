package basic._03_functions;

public class Functions {

	public static void main(String[] args) {

	}

	// normal functions
	public static int plus2(int n) {
		return n + 2;
	}

	// void functions
	public static void printHello() {
		System.out.println("Hello world!");
	}

	// recursive functions
	public static int recursiveAddition(int n) {
		int addition = 0;

		if (n == 1) {
			return n;
		} else {
			addition += n + recursiveAddition(n - 1);
		}

		return addition;
	}

}
