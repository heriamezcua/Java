package intermediate1._08_innerclasses;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		Square calcSquare = (int x) -> x * x;
		Operation calcSubtract = (int x, int y) -> x - y;

		// Using the ResultTracker inner class
		ResultTracker resultTracker = new ResultTracker();
		resultTracker.trackResult("Square of 5", calcSquare.calculate(5));
		resultTracker.trackResult("Subtraction of 7 from 5", calcSubtract.subtract(5, 7));
		resultTracker.displayResults();
	}

	// Inner class for tracking and printing results of operations
	static class ResultTracker {
		private final List<String> operations = new ArrayList<>();

		public void trackResult(String operationName, int result) {
			operations.add(operationName + " = " + result);
		}

		public void displayResults() {
			System.out.println("\nTracked Results:");
			operations.forEach(System.out::println);
		}
	}

	// A Lambda needs a definition in a functional interface
	@FunctionalInterface
	interface Square {
		int calculate(int x);
	}

	@FunctionalInterface
	interface Operation {
		int subtract(int x, int y);
	}
}
