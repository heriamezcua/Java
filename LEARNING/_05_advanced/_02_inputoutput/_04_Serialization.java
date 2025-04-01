package _05_advanced._02_inputoutput;

import java.io.*;
import java.awt.geom.Point2D;

public class _04_Serialization {

	// Serializable class with custom serialization methods
	static class Employee implements Serializable {
		private static final long serialVersionUID = 1L;
		private String name;
		private int age;
		private transient Point2D.Double location;

		public Employee(String name, int age, double x, double y) {
			this.name = name;
			this.age = age;
			this.location = new Point2D.Double(x, y);
		}

		// Custom serialization method
		private void writeObject(ObjectOutputStream out) throws IOException {
			out.defaultWriteObject(); // Serialize default fields
			out.writeDouble(location.getX());
			out.writeDouble(location.getY());
		}

		// Custom deserialization method
		private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
			in.defaultReadObject(); // Deserialize default fields
			double x = in.readDouble();
			double y = in.readDouble();
			location = new Point2D.Double(x, y);
		}

		@Override
		public String toString() {
			return "Employee{name='" + name + "', age=" + age + ", location=(" + location.getX() + ", "
					+ location.getY() + ")}";
		}
	}

	public static void main(String[] args) {
		String filename = "employee.dat";
		Employee emp = new Employee("John Doe", 30, 100.5, 200.5);

		// Serialize object
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
			out.writeObject(emp);
			System.out.println("Object serialized: " + emp);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Deserialize object
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
			Employee deserializedEmp = (Employee) in.readObject();
			System.out.println("Object deserialized: " + deserializedEmp);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}