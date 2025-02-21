package intermediate2._06_collectioninterface;

import java.util.Comparator;
import java.util.TreeSet;

public class _05_TreeSet {

	// ***
	// *** If you don't need the elements to be sorted, it's better to use a HashSet
	// ***

	// Custom class implementing Comparable
	static class Persona implements Comparable<Persona> {
		private String nombre;

		public Persona(String nombre) {
			this.nombre = nombre;
		}

		public String getNombre() {
			return nombre;
		}

		@Override
		public int compareTo(Persona otra) {
			return this.nombre.compareTo(otra.nombre);
		}

		@Override
		public String toString() {
			return nombre;
		}
	}

	public static void main(String[] args) {
		// Creating a TreeSet to store strings in natural order (alphabetically)
		TreeSet<String> sorter = new TreeSet<>();

		// Adding elements in a random order
		sorter.add("Bob");
		sorter.add("Amy");
		sorter.add("Carl");
		sorter.add("David");
		sorter.add("Alice");

		// Displaying elements (will be sorted automatically)
		System.out.println("TreeSet elements in sorted order:");
		for (String name : sorter) {
			System.out.println(name);
		}

		// Using a custom comparator to sort in reverse order
		TreeSet<String> reverseSorter = new TreeSet<>(Comparator.reverseOrder());
		reverseSorter.addAll(sorter);

		System.out.println("\nTreeSet elements in reverse order:");
		for (String name : reverseSorter) {
			System.out.println(name);
		}

		// Using TreeSet with a custom class implementing Comparable
		TreeSet<Persona> personas = new TreeSet<>();
		personas.add(new Persona("Carlos"));
		personas.add(new Persona("Ana"));
		personas.add(new Persona("Bruno"));

		System.out.println("\nTreeSet with Persona objects:");
		for (Persona persona : personas) {
			System.out.println(persona);
		}

		// Using TreeSet with a custom comparator
		TreeSet<Persona> personasByLength = new TreeSet<>(Comparator.comparingInt(p -> p.getNombre().length()));
		personasByLength.addAll(personas);

		System.out.println("\nTreeSet with Persona objects sorted by name length:");
		for (Persona persona : personasByLength) {
			System.out.println(persona);
		}
	}
}
