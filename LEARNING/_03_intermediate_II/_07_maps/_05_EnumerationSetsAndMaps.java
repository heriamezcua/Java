package _03_intermediate_II._07_maps;

import java.util.EnumMap;
import java.util.EnumSet;

public class _05_EnumerationSetsAndMaps {
	public static void main(String[] args) {
		// Creating EnumSet examples
		EnumSet<Weekday> allDays = EnumSet.allOf(Weekday.class);
		EnumSet<Weekday> noDays = EnumSet.noneOf(Weekday.class);
		EnumSet<Weekday> workdays = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
		EnumSet<Weekday> selectedDays = EnumSet.of(Weekday.MONDAY, Weekday.WEDNESDAY, Weekday.FRIDAY);

		System.out.println("All days: " + allDays);
		System.out.println("No days: " + noDays);
		System.out.println("Workdays: " + workdays);
		System.out.println("Selected days: " + selectedDays);

		// Creating EnumMap example
		EnumMap<Weekday, Employee> personInCharge = new EnumMap<>(Weekday.class);

		personInCharge.put(Weekday.MONDAY, new Employee("Amy Lee"));
		personInCharge.put(Weekday.TUESDAY, new Employee("Harry Hacker"));
		personInCharge.put(Weekday.WEDNESDAY, new Employee("Gary Cooper"));
		personInCharge.put(Weekday.THURSDAY, new Employee("Francesca Cruz"));

		System.out.println("Person in charge: " + personInCharge);
	}

	enum Weekday {
		MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
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
