package intermediate1._06_interfaces;

public class PaymentProcessor {

	private PaymentMethod PaymentMethod; // remember this is an interface

	// Allows you to change the payment method dynamically
	public void setPaymentMethod(PaymentMethod PaymentMethod) {
		this.PaymentMethod = PaymentMethod;
	}

	public void pay(double amount) {
		if (PaymentMethod == null) {
			System.out.println("A payment method has not been set.");
			return;
		}
		PaymentMethod.processPayment(amount);
	}
}
