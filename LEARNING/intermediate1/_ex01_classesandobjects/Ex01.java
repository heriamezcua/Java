package intermediate1._ex01_classesandobjects;

/**
 * 1.3 Ex: The Rectangle Class
 * 
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J3f_OOPExercises.html#zz-1.3
 */
public class Ex01 {

	/**
	 * The {@code Rectangle} class represents a rectangle shape with length and
	 * width. It provides methods to calculate area, perimeter, and manipulate its
	 * dimensions.
	 */
	public static class Rectangle {

		/** The length of the rectangle. */
		private float length;

		/** The width of the rectangle. */
		private float width;

		/**
		 * Constructs a default {@code Rectangle} with length and width initialized to
		 * 1.0.
		 */
		public Rectangle() {
			this.length = 1.0f;
			this.width = 1.0f;
		}

		/**
		 * Constructs a {@code Rectangle} with the specified length and width.
		 *
		 * @param length The length of the rectangle.
		 * @param width  The width of the rectangle.
		 */
		public Rectangle(float length, float width) {
			this.length = length;
			this.width = width;
		}

		/**
		 * Returns the length of the rectangle.
		 *
		 * @return The length of the rectangle.
		 */
		public float getLength() {
			return length;
		}

		/**
		 * Sets the length of the rectangle.
		 *
		 * @param length The new length of the rectangle.
		 */
		public void setLength(float length) {
			this.length = length;
		}

		/**
		 * Returns the width of the rectangle.
		 *
		 * @return The width of the rectangle.
		 */
		public float getWidth() {
			return width;
		}

		/**
		 * Sets the width of the rectangle.
		 *
		 * @param width The new width of the rectangle.
		 */
		public void setWidth(float width) {
			this.width = width;
		}

		/**
		 * Computes and returns the area of the rectangle.
		 *
		 * @return The area of the rectangle.
		 */
		public double getArea() {
			return this.width * this.length;
		}

		/**
		 * Computes and returns the perimeter of the rectangle.
		 *
		 * @return The perimeter of the rectangle.
		 */
		public double getPerimeter() {
			return 2 * (this.width + this.length);
		}

		/**
		 * Returns a string representation of the rectangle.
		 *
		 * @return A string representation of the rectangle in the format
		 *         "Rectangle[length=x,width=y]".
		 */
		@Override
		public String toString() {
			return "Rectangle[length=" + this.length + ",width=" + this.width + "]";
		}
	}

	public static void main(String[] args) {
		// Test constructors and toString()
		// You need to append a 'f' or 'F' to a float literal
		Rectangle r1 = new Rectangle(1.2f, 3.4f);
		System.out.println(r1); // toString()
		Rectangle r2 = new Rectangle(); // default constructor
		System.out.println(r2);

		// Test setters and getters
		r1.setLength(5.6f);
		r1.setWidth(7.8f);
		System.out.println(r1); // toString()
		System.out.println("length is: " + r1.getLength());
		System.out.println("width is: " + r1.getWidth());

		// Test getArea() and getPerimeter()
		System.out.printf("area is: %.2f%n", r1.getArea());
		System.out.printf("perimeter is: %.2f%n", r1.getPerimeter());
	}

}
