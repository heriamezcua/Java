package intermediate._06_interfaces;

import java.util.Comparator;

public class OrderPersonByHeight implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {

		// Returns a positive integer if the height of o1 is greater than that of o2
		return p1.getHeight() - p2.getHeight();
	}

}
