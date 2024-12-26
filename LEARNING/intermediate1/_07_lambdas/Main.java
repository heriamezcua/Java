package intermediate1._07_lambdas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {

		// Lambda declaration
		Square calcSquare = (int x) -> x * x;

		int number = 5;
		int result = calcSquare.calculate(number);

		System.out.println("The square of " + number + " is " + result);

		// Other Lambda declaration
		Operation calcSubtract = (int x, int y) -> x - y;

		int num1 = 5;
		int num2 = 7;
		int result2 = calcSubtract.subtract(num1, num2);

		System.out.println(num1 + " less " + num2 + " = " + result2);

		// ***** METHOD REFERENCES

//		String::length is a reference to the length method of the String class. 
//		This is equivalent to using a lambda like (str) -> str.length().

//		Function<String, Integer> stringLengthFunction = (str) -> str.length();
		Function<String, Integer> stringLengthFunction = String::length;

		// Use the reference to the method
		String text = "Hello word";
		int length = stringLengthFunction.apply(text);

		// Imprimir el resultado
		System.out.println("The length of the string \"" + text + "\" is: " + length);

		// EXCEPTION if the referenced method is null
//		String text2 = null;
//		int length2 = stringLengthFunction.apply(text2);

		//
		// ***** CONSTRUCTOR REFERENCES

		CreatePerson defaultReference = Person::new;
		Person person1 = defaultReference.create();
		System.out.println(person1);

		CreatePersonWithName paramReference = Person::new;
		Person person2 = paramReference.create("Fernando");
		System.out.println(person2);

		// another use
		System.out.println("----- ------ ------");
		List<String> names = List.of("Alice", "Bob", "Charlie");

		List<Person> people = names.stream().map(Person::new).toList();

		people.forEach(System.out::println);

		// **** Also we can use Array constructors
		Person[] people2 = names.stream().map(Person::new).toArray(Person[]::new);

		System.out.println("-- -- -- -- -- --");
		for (Person person : people2) {
			System.out.println(person);
		}

		// ***** EFFECTIVELY FINAL
		int start = 10;
		ActionListener listener = event -> System.out.println(start);
		// start--; ERROR: No puedes cambiar 'start' después de capturarlo.

		// this inside lambdas
		Person person3 = new Person("Juan");
		System.out.println("--- --- ---");
		person3.init();

		// ****** USE OF RUNNABLE
		//
		// Runnable implementation with an anonymous class
		Runnable task1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Task 1 execution with an anonymous class");
			}
		};
		task1.run();

		// Runnable implementation with a lambda
		Runnable task2 = () -> System.out.println("Task 2 execution using a lambda");
		task2.run();

		// Doing multiple operations inside a lambda
		Runnable task3 = () -> {
			System.out.println("Task 3 initialization.");
			for (int i = 1; i <= 3; i++) {
				System.out.println("Operation in task 3: " + i);
			}
			System.out.println("Task 3 final.");
		};
		task3.run();

		// Combination: Passing Runnable to a custom method
		taskExec(() -> System.out.println("Task 4 execution from a custom method."));

		System.out.println("--- -- --- ---- --- ");
		repeat(6, i -> System.out.println("Countdown: " + (5 - i)));

	}

	// A Lambda needs a definition in a functional interface
	@FunctionalInterface
	interface Square {
		int calculate(int x);
	}

	// ****** CONSTRUCTOR REFERENCES
	// Functional interface para el constructor sin parámetros
	@FunctionalInterface
	interface CreatePerson {
		Person create();
	}

	// Functional interface para el constructor con un parámetro
	@FunctionalInterface
	interface CreatePersonWithName {
		Person create(String nombre);
	}

	// ****** Use of RUNNABLE
	public static void taskExec(Runnable task) {
		System.out.println("Executing custom task:");
		task.run();
		System.out.println("Ending of the custom task");
	}

	// IntConsumer
	public static void repeat(int n, IntConsumer action) {
		for (int i = 0; i < n; i++) {
			action.accept(i); // Pass the actual counter (i) to the lambda
		}
	}
}