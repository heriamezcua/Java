package _02_intermediate_I._02_objects;

public class _03_ImmutableStudent {
	// Attributes (private and final)
	private final String name;
	private final int age;
	private final String[] subjects;

	// Constructor
	public _03_ImmutableStudent(String name, int age, String[] subjects) {
		this.name = name;
		this.age = age;
		// Defensive copy to prevent external modifications
		this.subjects = subjects != null ? subjects.clone() : new String[0];
	}

	// Getters (no setters)
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String[] getSubjects() {
		// Return a copy to ensure immutability
		return subjects.clone();
	}

	// I will explain this later in inheritance section
	@Override
	public String toString() {
		return "ImmutableStudent{" + "name='" + name + '\'' + ", age=" + age + ", subjects="
				+ String.join(", ", subjects) + '}';
	}
}
