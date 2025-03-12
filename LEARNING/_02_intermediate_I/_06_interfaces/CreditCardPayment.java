package _02_intermediate_I._06_interfaces;

public class CreditCardPayment implements PaymentMethod {
	
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing payment of $" + amount + " by credit card.");
	}
	
}
