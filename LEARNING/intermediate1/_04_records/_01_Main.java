package intermediate1._04_records;

public class _01_Main {

	public static void main(String[] args) {

		// new instance from a record
		Point p1 = new Point(3, 4);

		// static atribute ORIGIN
		Point origin = Point.ORIGIN;

		System.out.println("Point p1: " + p1);
		System.out.println("Origin: " + origin);

		// method
		System.out.println("Distance of p1 from origin: " + p1.distanceFromOrigin());
		System.out.println("Distance of origin from origin: " + origin.distanceFromOrigin());

	}

}
