package intermediate1._03_inheritance;

import java.util.Objects;

// we can't extend from FinalAnimal class
public final class FinalAnimal extends Animal {
	private String habitat; // Habitat where the animal lives
	private boolean endangered; // Whether the animal is endangered

	// Constructor
	public FinalAnimal(String species, int age, double weight, boolean isWild, String habitat, boolean endangered) {
		super(species, age, weight, isWild); // Call the parent class constructor
		this.habitat = habitat;
		this.endangered = endangered;
	}

	// Default constructor
	public FinalAnimal() {
		super("Unknown", 0, 0.0, false);
		this.habitat = "Unknown";
		this.endangered = false;
	}

	// Getters and Setters
	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	public boolean isEndangered() {
		return endangered;
	}

	public void setEndangered(boolean endangered) {
		this.endangered = endangered;
	}

	// Override toString
	@Override
	public String toString() {
		return super.toString().replace("Animal", "FinalAnimal") + ", habitat=" + habitat + ", endangered=" + endangered
				+ "}";
	}

	// Override equals
	@Override
	public boolean equals(Object obj) {
		if (!super.equals(obj))
			return false;
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		FinalAnimal that = (FinalAnimal) obj;
		return endangered == that.endangered && Objects.equals(habitat, that.habitat);
	}

	// Override hashCode
	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), habitat, endangered);
	}

	@Override
	public void makeSound() {
		System.out.println("Final animal can't have childs :'C");
	}
}
