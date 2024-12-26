package intermediate1._03_inheritance;

import java.util.Objects;

public abstract class Animal {

	// Attributes
	private String species;
	private int age;
	private double weight;
	private boolean isWild;

	// Constructor
	public Animal(String species, int age, double weight, boolean isWild) {
		this.species = species;
		this.age = age;
		this.weight = weight;
		this.isWild = isWild;
	}

	// Default constructor
	public Animal() {
		this.species = "Unknown";
		this.age = 0;
		this.weight = 0.0;
		this.isWild = false;
	}

	// Getters and Setters
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 0) {
			this.age = age;
		} else {
			System.out.println("Age cannot be negative.");
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		if (weight >= 0) {
			this.weight = weight;
		} else {
			System.out.println("Weight cannot be negative.");
		}
	}

	public boolean isWild() {
		return isWild;
	}

	public void setWild(boolean isWild) {
		this.isWild = isWild;
	}

	// Behavior methods
	public void eat() {
		System.out.println(species + " is eating.");
	}

	public void sleep() {
		System.out.println(species + " is sleeping.");
	}

	public void move() {
		System.out.println(species + " is moving.");
	}

	// FINAL methods (can't be inherited)
	public final void displayBasicInfo() {
		System.out.println("Species: " + species + ", Age: " + age + ", Weight: " + weight + "kg, Wild: " + isWild);
	}

	// Abstract method MUST be implemented by subclasses (no final no static)
	public abstract void makeSound();

	// we override tostring thanks to inheritance
	@Override
	public String toString() {
		return "Animal{" + "species='" + species + '\'' + ", age=" + age + ", weight=" + weight + ", isWild=" + isWild
				+ '}';
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		Animal animal = (Animal) obj;
		return age == animal.age && Double.compare(animal.weight, weight) == 0 && isWild == animal.isWild
				&& Objects.equals(species, animal.species);
	}

	@Override
	public int hashCode() {
		return Objects.hash(species, age, weight, isWild);
	}
}
