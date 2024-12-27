package intermediate2._02_assertions;

public class Assertions {

	public static void main(String[] args) {
		// knowing what we know about Exceptions we would do
		if (3 < 0) {
			throw new IllegalArgumentException("x < 0"); // people dont do this, people use assertions
		}

		// example with assertions
		assert 3 >= 0 : "x < 0";

	}
}
