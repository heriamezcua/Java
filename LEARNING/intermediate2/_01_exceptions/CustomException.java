package intermediate2._01_exceptions;

// We need to inherit from the most similar exception 
public class CustomException extends Exception {

	public CustomException() {
	}

	public CustomException(String message) {
		super(message);
	}

}
