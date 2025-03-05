package intermediate1._02_objects;

public class _01_Main {
	public static void main(String[] args) {
		// Normal object
		_02_Student st1 = new _02_Student("John", "Jones", 18);
		String name = st1.getName();
		String surname = st1.getSurname();
		int age = st1.getAge();

		_02_Student st2 = new _02_Student("Ana");
		String name2 = st2.getName();
		String surname2 = st2.getSurname();
		int age2 = st2.getAge();

		System.out.printf("Name: %s, Surname: %s, Age: %d years\n", name, surname, age);
		System.out.printf("Name: %s, Surname: %s, Age: %d years\n", name2, surname2, age2);

		// Immutable objects
		String[] subjects = { "Math", "Science", "History" };
		_03_ImmutableStudent immutableSt = new _03_ImmutableStudent("Alice", 20, subjects);

		System.out.println(immutableSt);

		// Attempt to modify the subjects array outside the class
		subjects[0] = "Art";

		// The original student's subjects remain unchanged
		System.out.println("After external modification: " + immutableSt);

		// Attempt to modify the subjects array through getter
		String[] studentSubjects = immutableSt.getSubjects();
		studentSubjects[1] = "Music";

		// The original subjects are still immutable
		System.out.println("After modifying getter's array: " + immutableSt);
	}
}
