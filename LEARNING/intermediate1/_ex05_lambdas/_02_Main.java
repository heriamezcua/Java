package intermediate1._ex05_lambdas;

import java.util.Arrays;
import java.util.List;

/**
 * Given a list of names, use a lambda expression with stream() to filter and
 * print only the names that start with the letter "A".
 */
public class _02_Main {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Adrian", "Rose", "Donald", "Andrew", "Carl");

		names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
	}
}
