package _02_intermediate_I._06_interfaces;

public class Person implements Comparable<Person> {

	private String name;
	private int age;
	private int height;

	public Person() {
		this.name = "Unknown";
		this.age = 0;
		this.height = 0;
	}

	public Person(String name, int age, int height) {
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Person{name='" + name + '\'' + ", age=" + age + '\'' + ", age=" + age + '}';
	}

	// compareTo from Comparable<T> interface
	
	@Override
	public int compareTo(Person other) {

		// Comparison by age from lower to higher
		return Integer.compare(this.age, other.age);
	}
}
