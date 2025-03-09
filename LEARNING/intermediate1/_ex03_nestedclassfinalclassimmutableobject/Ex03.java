package intermediate1._ex03_nestedclassfinalclassimmutableobject;

/**
 * Immutable Object - Creating an Immutable Person Class Create an immutable
 * Person class where once an instance is created, its fields cannot be
 * modified.
 */
public class Ex03 {
	/**
	 * Represents an immutable Person with a name and age. Once created, its fields
	 * cannot be modified.
	 */
	public static final class Person {
		private final String name;
		private final int age;

		/**
		 * Constructs a Person object with the specified name and age.
		 *
		 * @param name the name of the person
		 * @param age  the age of the person
		 */
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		/**
		 * Gets the name of the person.
		 *
		 * @return the person's name
		 */
		public String getName() {
			return name;
		}

		/**
		 * Gets the age of the person.
		 *
		 * @return the person's age
		 */
		public int getAge() {
			return age;
		}

		/**
		 * Returns a string representation of the Person object.
		 *
		 * @return a formatted string with the person's details
		 */
		@Override
		public String toString() {
			return "Person{name='" + name + "', age=" + age + "}";
		}

		public static void main(String[] args) {
			// Creating an immutable Person instance
			Person p = new Person("Alice", 30);
			System.out.println(p.getName()); // Alice
			System.out.println(p.getAge()); // 30

			// The following line would cause a compilation error because fields are final
			// p.name = "Bob"; // ERROR: Cannot assign a value to final variable 'name'
		}
	}
}
