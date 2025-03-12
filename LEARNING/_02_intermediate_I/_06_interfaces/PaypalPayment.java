package _02_intermediate_I._06_interfaces;

public class PaypalPayment implements PaymentMethod{
	
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing payment of $" + amount + " by Paypal.");
	}
	
}
