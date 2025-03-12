package _02_intermediate_I._ex01_classesandobjects;

/**
 * 1.4 Ex: The Employee Class
 * 
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J3f_OOPExercises.html#zz-1.4
 */
public class Ex02 {

	/**
	 * Represents an Employee with an ID, first name, last name, and salary.
	 */
	public static class Employee {

		private int id; // Employee ID
		private String firstName; // Employee's first name
		private String lastName; // Employee's last name
		private int salary; // Employee's monthly salary

		/**
		 * Constructs an Employee instance.
		 * 
		 * @param id        The unique identifier of the employee.
		 * @param firstName The first name of the employee.
		 * @param lastName  The last name of the employee.
		 * @param salary    The monthly salary of the employee.
		 */
		public Employee(int id, String firstName, String lastName, int salary) {
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.salary = salary;
		}

		/**
		 * Gets the employee ID.
		 * 
		 * @return The employee ID.
		 */
		public int getId() {
			return id;
		}

		/**
		 * Gets the employee's first name.
		 * 
		 * @return The first name of the employee.
		 */
		public String getFirstName() {
			return firstName;
		}

		/**
		 * Gets the employee's last name.
		 * 
		 * @return The last name of the employee.
		 */
		public String getLastName() {
			return lastName;
		}

		/**
		 * Gets the employee's monthly salary.
		 * 
		 * @return The monthly salary of the employee.
		 */
		public int getSalary() {
			return salary;
		}

		/**
		 * Sets the employee's salary.
		 * 
		 * @param salary The new salary to be set.
		 */
		public void setSalary(int salary) {
			this.salary = salary;
		}

		/**
		 * Gets the full name of the employee.
		 * 
		 * @return The full name of the employee in "firstName lastName" format.
		 */
		public String getName() {
			return this.firstName + " " + this.lastName;
		}

		/**
		 * Calculates the annual salary of the employee.
		 * 
		 * @return The annual salary (monthly salary multiplied by 12).
		 */
		public int getAnnualSalary() {
			return this.salary * 12;
		}

		/**
		 * Increases the employee's salary by a given percentage.
		 * 
		 * @param percent The percentage increase.
		 * @return The new salary after the increase.
		 */
		public int raiseSalary(int percent) {
			this.salary = this.salary + this.salary * percent / 100;
			return this.salary;
		}

		/**
		 * Returns a string representation of the Employee object.
		 * 
		 * @return A string in the format "Employee[id=...,name=...,salary=...]".
		 */
		@Override
		public String toString() {
			return "Employee[id=" + this.id + ",name=" + this.getName() + ",salary=" + this.getSalary() + "]";
		}
	}

	public static void main(String[] args) {
		// Test constructor and toString()
		Employee e1 = new Employee(8, "Peter", "Tan", 2500);
		System.out.println(e1); // toString();

		// Test Setters and Getters
		e1.setSalary(999);
		System.out.println(e1); // toString();
		System.out.println("id is: " + e1.getId());
		System.out.println("firstname is: " + e1.getFirstName());
		System.out.println("lastname is: " + e1.getLastName());
		System.out.println("salary is: " + e1.getSalary());

		System.out.println("name is: " + e1.getName());
		System.out.println("annual salary is: " + e1.getAnnualSalary()); // Test method

		// Test raiseSalary()
		System.out.println(e1.raiseSalary(10));
		System.out.println(e1);
	}
}
