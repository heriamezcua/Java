package _02_intermediate_I._04_records;

public record Point(double x, double y) {

	// we can't define non static attributes

	public static Point ORIGIN = new Point(0, 0);

	// canonical constructor
//    public Point(double x, double y) {
//        if (Double.isNaN(x) || Double.isNaN(y)) {
//            throw new IllegalArgumentException("Coordinates x and y must be valid numbers.");
//        }
//    }
//    
	// compacted canonical constructor
	public Point {
		if (Double.isNaN(x) || Double.isNaN(y)) {
			throw new IllegalArgumentException("Coordinates x and y must be valid numbers.");
		}
	}

	public double distanceFromOrigin() {
		return Math.hypot(x, y);
	}
}
