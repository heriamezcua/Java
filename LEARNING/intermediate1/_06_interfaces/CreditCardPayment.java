package intermediate1._06_interfaces;

public class CreditCardPayment implements PaymentMethod {
	
	@Override
	public void processPayment(double amount) {
		System.out.println("Processing payment of $" + amount + " by credit card.");
	}
	
}
