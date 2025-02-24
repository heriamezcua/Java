package intermediate2._07_maps;

import java.util.LinkedHashMap;

public class _04_LinkedHashSetsAndMaps {

	public static void main(String[] args) {
		// Creating a LinkedHashMap with insertion order
		LinkedHashMap<String, Employee> staff = new LinkedHashMap<>();

		// Adding employees
		staff.put("144-25-5464", new Employee("Amy Lee"));
		staff.put("567-24-2546", new Employee("Harry Hacker"));
		staff.put("157-62-7935", new Employee("Gary Cooper"));
		staff.put("456-62-5527", new Employee("Francesca Cruz"));

		// Displaying map before access
		System.out.println("Before access: " + staff);

		// Accessing an element
		staff.get("157-62-7935");

		// Displaying map after access
		System.out.println("After access: " + staff);

		// Creating a LinkedHashMap with access order enabled (LRU behavior)
		LinkedHashMap<String, Employee> lruCache = new LinkedHashMap<>(16, 0.75f, true);

		// Adding employees to LRU cache
		lruCache.put("144-25-5464", new Employee("Amy Lee"));
		lruCache.put("567-24-2546", new Employee("Harry Hacker"));
		lruCache.put("157-62-7935", new Employee("Gary Cooper"));
		lruCache.put("456-62-5527", new Employee("Francesca Cruz"));

		// Accessing an element
		lruCache.get("157-62-7935");

		// Displaying map after access
		System.out.println("After access (LRU mode): " + lruCache);
	}

	class Employee {
		String name;

		public Employee(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return name;
		}
	}

}
