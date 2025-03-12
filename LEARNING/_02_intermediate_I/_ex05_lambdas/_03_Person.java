package _02_intermediate_I._ex05_lambdas;

public class _03_Person {
	String name;
	int age;

	public _03_Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " - " + age;
	}

}
