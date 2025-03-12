package _02_intermediate_I._ex03_nestedclassfinalclassimmutableobject;

/**
 * Final Class - Preventing Inheritance Create a SecurityManager final class,
 * ensuring it cannot be inherited. It should have a method to encrypt a message
 * (for simplicity, reverse the string).
 */
public class Ex02 {

	/**
	 * A security manager that provides basic encryption by reversing strings. This
	 * class is final to prevent inheritance.
	 */
	public static final class SecurityManager {

		/**
		 * Encrypts a message by reversing the string.
		 *
		 * @param message the message to encrypt
		 * @return the reversed string as the encrypted message
		 */
		public String encrypt(String message) {
			return new StringBuilder(message).reverse().toString();
		}

		public static void main(String[] args) {
			SecurityManager securityManager = new SecurityManager();
			String message = "Hello, World!";
			String encryptedMessage = securityManager.encrypt(message);
			System.out.println("Original: " + message);
			System.out.println("Encrypted: " + encryptedMessage);
		}
	}

	// The following code will cause a compilation error
	// because is final
	// class HackManager extends SecurityManager {
	// }

}
