package intermediate._06_interfaces;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {

		// We can instanciate interfaces

		// Musician m = new Musician(); ERROR

		// Despite this, we can declare interfaces

		Musician m;

		// Check if an object implements an interface

		Guitarist guitarist = new Guitarist();

		if (guitarist instanceof Musician) {
			System.out.println("Guitarist implements Musician interface");
		}

		// **** Use of Comparable and Comparator interfaces *****

		Person p1 = new Person("Fernando", 33, 170);
		Person p2 = new Person("Sydney", 27, 165);

		// Use of compareTo (Comparable)
		
		System.out.println();
		// > 0 when p1 > p2
		if (p1.compareTo(p2) > 0) {
			System.out.println(p1.getName() + " is older than " + p2.getName());

			// 0 when p1 = p2
		} else if (p1.compareTo(p2) == 0) {
			System.out.println(p1.getName() + "'s age is the same as " + p2.getName() + "'s");

			// < 0 when p1 < p2
		} else {
			System.out.println(p1.getName() + " is younger than " + p2.getName());
		}

		// Use of .sort with a Comparator

		ArrayList<Person> people = new ArrayList<>();

		people.add(p1);
		people.add(p2);
		people.add(new Person("Donald", 79, 180));
		people.add(new Person("Elon", 53, 175));

		Collections.sort(people, new OrderPersonByHeight());

		System.out.println("\n--------- Ordered by age:");
		for (Person person : people) {
			System.out.println(person.getName() + " - Age: " + person.getAge() + ", Height: " + person.getHeight());
		}

		// Now I want it ordered by name

		Collections.sort(people, new OrderPersonByName());

		System.out.println("\n--------- Ordered by name:");
		for (Person person : people) {
			System.out.println(person.getName() + " - Age: " + person.getAge() + ", Height: " + person.getHeight());
		}

		// **** Polimorfism in interfaces *****

		PaymentProcessor processor = new PaymentProcessor();

		System.out.println();

		// using credit card
		processor.setPaymentMethod(new CreditCardPayment());
		processor.pay(100.50);

		// change to paypal
		processor.setPaymentMethod(new PaypalPayment());
		processor.pay(100.50);

		// change to bitcoin
		processor.setPaymentMethod(new BitcoinPayment());
		processor.pay(100.50);

		// This technique is very useful as you can change the payment method at
		// runtime.
		// You do not need to modify the PaymentProcessor logic.

	}
}
