package _02_intermediate_I._ex05_lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * You have a list of Person objects with name and age. Use a lambda expression
 * to sort the list first by age (ascending) and then by name in case of a tie.
 */
public class _03_Main {
	public static void main(String[] args) {
		List<_03_Person> people = Arrays.asList(new _03_Person("Carlos", 30), new _03_Person("Ana", 25),
				new _03_Person("Beatriz", 25), new _03_Person("Daniel", 35));

		people.sort(Comparator.comparingInt((_03_Person p) -> p.age).thenComparing(p -> p.name));

		people.forEach(System.out::println);
	}
}
