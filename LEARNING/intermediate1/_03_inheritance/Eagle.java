package intermediate1._03_inheritance;

import java.util.Arrays;
import java.util.Objects;

public class Eagle extends Animal {

	// Additional attributes specific to Eagle
	private double wingspan; // Wingspan in meters
	private boolean canHunt;
	private String[] prey;

	private Habitat habitat; // New attribute using the Habitat enum

	// Constructor
	public Eagle(String species, int age, double weight, boolean isWild, double wingspan, boolean canHunt,
			String[] prey, Habitat habitat) {
		super(species, age, weight, isWild); // Call the parent class constructor

		this.wingspan = wingspan;
		this.canHunt = canHunt;
		this.prey = prey;
		this.prey = prey;
		this.habitat = habitat;
	}

	// Default constructor
	public Eagle() {
		super("Eagle", 0, 0.0, true); // Default values for an eagle

		this.wingspan = 2.0; // Default wingspan in meters
		this.canHunt = true; // Eagles are hunters by default
		this.prey = new String[] { "fish", "small mammals" }; // Default prey
		this.habitat = Habitat.MOUNTAINS;
	}

	// Getters and Setters
	public double getWingspan() {
		return wingspan;
	}

	public void setWingspan(double wingspan) {
		if (wingspan > 0) {
			this.wingspan = wingspan;
		} else {
			System.out.println("Wingspan must be positive.");
		}
	}

	public boolean isCanHunt() {
		return canHunt;
	}

	public void setCanHunt(boolean canHunt) {
		this.canHunt = canHunt;
	}

	public String[] getPrey() {
		return prey;
	}

	public void setPrey(String[] prey) {
		this.prey = prey;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	// Additional behavior
	public void fly() {
		System.out.println(getSpecies() + " is soaring through the skies with a wingspan of " + wingspan + " meters.");
	}

	public void hunt() {
		if (canHunt) {
			System.out.println(getSpecies() + " is hunting for prey.");
		} else {
			System.out.println(getSpecies() + " is not hunting currently.");
		}
	}

	// Varargs method to add prey
	public void addPrey(String... newPrey) {
		if (newPrey != null && newPrey.length > 0) {
			// Combine existing prey with new prey
			String[] updatedPrey = new String[prey.length + newPrey.length];
			System.arraycopy(prey, 0, updatedPrey, 0, prey.length);
			System.arraycopy(newPrey, 0, updatedPrey, prey.length, newPrey.length);
			prey = updatedPrey;
			System.out.println("Added new prey: " + Arrays.toString(newPrey));
		} else {
			System.out.println("No prey was provided.");
		}
	}

	@Override
	public void makeSound() {
		System.out.println("The eagle screeches!");
	}

	// Override toString to include additional attributes
	@Override
	public String toString() {
		return super.toString().replace("Animal", "Eagle") + ", wingspan=" + wingspan + ", canHunt=" + canHunt
				+ ", prey=" + Arrays.toString(prey) + ", habitat=" + habitat + " (" + habitat.getDescription() + ")}";
	}

	@Override
	public boolean equals(Object obj) {
		// First call equals for your superclass, if that test fails then they can never
		// be equal
		if (!super.equals(obj))
			return false;

		if (this == obj) {
			return true; // Check if comparing to itself
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}

		// now we know otherObject is a non-null Employee
		// Cast the object and compare attributes
		Eagle eagle = (Eagle) obj;
		return Double.compare(eagle.wingspan, wingspan) == 0 && canHunt == eagle.canHunt
				&& Arrays.equals(prey, eagle.prey);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), wingspan, canHunt, Arrays.hashCode(prey)); // Combine hash codes of parent
																							// and new fields
	}

}
