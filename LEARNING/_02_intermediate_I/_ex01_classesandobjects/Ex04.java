package _02_intermediate_I._ex01_classesandobjects;

/**
 * 2.5 Ex: The Customer and Account classes
 * 
 * https://www3.ntu.edu.sg/home/ehchua/programming/java/J3f_OOPExercises.html#zz-2.5
 */
public class Ex04 {

	/**
	 * The {@code Customer} class represents a customer with a unique ID, name, and
	 * discount percentage. It provides methods to get and set these attributes.
	 */
	public static class Customer {

		private int id;
		private String name;
		private int discount;

		/**
		 * Constructs a {@code Customer} object with the specified ID, name, and
		 * discount.
		 *
		 * @param id       The unique identifier for the customer.
		 * @param name     The name of the customer.
		 * @param discount The discount percentage assigned to the customer.
		 */
		public Customer(int id, String name, int discount) {
			this.id = id;
			this.name = name;
			this.discount = discount;
		}

		/**
		 * Gets the customer ID.
		 *
		 * @return The unique identifier of the customer.
		 */
		public int getId() {
			return id;
		}

		/**
		 * Sets the customer ID.
		 *
		 * @param id The new unique identifier for the customer.
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * Gets the customer's name.
		 *
		 * @return The name of the customer.
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the customer's name.
		 *
		 * @param name The new name of the customer.
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Gets the discount percentage for the customer.
		 *
		 * @return The discount percentage.
		 */
		public int getDiscount() {
			return discount;
		}

		/**
		 * Sets the discount percentage for the customer.
		 *
		 * @param discount The new discount percentage.
		 */
		public void setDiscount(int discount) {
			this.discount = discount;
		}

		/**
		 * Returns a string representation of the customer in the format:
		 * {@code Name(ID)(Discount%)}
		 *
		 * @return A formatted string containing the customer's name, ID, and discount
		 *         percentage.
		 */
		@Override
		public String toString() {
			return this.getName() + "(" + this.getId() + ")(" + this.getDiscount() + "%)";
		}
	}

	/**
	 * The {@code Invoice} class represents an invoice with a unique ID, an
	 * associated customer, and an amount. It provides methods to access and modify
	 * these attributes, as well as to calculate the amount after applying the
	 * customer's discount.
	 */
	public static class Invoice {
		private int id;
		private Customer customer;
		private double amount;

		/**
		 * Constructs an {@code Invoice} object with the specified ID, customer, and
		 * amount.
		 *
		 * @param id       The unique identifier for the invoice.
		 * @param customer The customer associated with this invoice.
		 * @param amount   The total amount of the invoice before applying any discount.
		 */
		public Invoice(int id, Customer customer, double amount) {
			this.id = id;
			this.customer = customer;
			this.amount = amount;
		}

		/**
		 * Gets the invoice ID.
		 *
		 * @return The unique identifier of the invoice.
		 */
		public int getId() {
			return id;
		}

		/**
		 * Sets the invoice ID.
		 *
		 * @param id The new unique identifier for the invoice.
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * Gets the customer associated with this invoice.
		 *
		 * @return The {@code Customer} object linked to the invoice.
		 */
		public Customer getCustomer() {
			return customer;
		}

		/**
		 * Sets the customer associated with this invoice.
		 *
		 * @param customer The new {@code Customer} for the invoice.
		 */
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		/**
		 * Gets the total amount of the invoice before applying any discount.
		 *
		 * @return The original invoice amount.
		 */
		public double getAmount() {
			return amount;
		}

		/**
		 * Sets the total amount of the invoice.
		 *
		 * @param amount The new amount for the invoice.
		 */
		public void setAmount(double amount) {
			this.amount = amount;
		}

		/**
		 * Gets the ID of the customer associated with this invoice.
		 *
		 * @return The unique identifier of the customer.
		 */
		public int getCustomerId() {
			return this.customer.getId();
		}

		/**
		 * Gets the discount percentage applied to the customer associated with this
		 * invoice.
		 *
		 * @return The customer's discount percentage.
		 */
		public int getCustomerDiscount() {
			return this.customer.getDiscount();
		}

		/**
		 * Gets the name of the customer associated with this invoice.
		 *
		 * @return The customer's name.
		 */
		public String getCustomerName() {
			return this.customer.getName();
		}

		/**
		 * Calculates the total amount after applying the customer's discount.
		 *
		 * @return The final amount after the discount has been applied.
		 */
		public double getAmountAfterDiscount() {
			return this.amount - this.amount * this.customer.getDiscount() / 100;
		}

		/**
		 * Returns a string representation of the invoice in the format:
		 * {@code Invoice[id=ID,customer=CUSTOMER,amount=AMOUNT]}.
		 *
		 * @return A formatted string containing the invoice details.
		 */
		@Override
		public String toString() {
			return "Invoice[id=" + this.id + ",customer=" + this.customer + ",amount=" + this.amount + "]";
		}
	}

	public static void main(String[] args) {
		// Test Customer class
		Customer c1 = new Customer(88, "Tan Ah Teck", 10);
		System.out.println(c1); // Customer's toString()

		c1.setDiscount(8);
		System.out.println(c1);
		System.out.println("id is: " + c1.getId());
		System.out.println("name is: " + c1.getName());
		System.out.println("discount is: " + c1.getDiscount());

		// Test Invoice class
		Invoice inv1 = new Invoice(101, c1, 888.8);
		System.out.println(inv1);

		inv1.setAmount(999.9);
		System.out.println(inv1);
		System.out.println("id is: " + inv1.getId());
		System.out.println("customer is: " + inv1.getCustomer()); // Customer's toString()
		System.out.println("amount is: " + inv1.getAmount());
		System.out.println("customer's id is: " + inv1.getCustomerId());
		System.out.println("customer's name is: " + inv1.getCustomerName());
		System.out.println("customer's discount is: " + inv1.getCustomerDiscount());
		System.out.printf("amount after discount is: %.2f%n", inv1.getAmountAfterDiscount());
	}

}
