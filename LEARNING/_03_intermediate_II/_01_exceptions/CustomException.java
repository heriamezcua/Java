package _03_intermediate_II._01_exceptions;

// We need to inherit from the most similar exception 
public class CustomException extends Exception {

	public CustomException() {
	}

	public CustomException(String message) {
		super(message);
	}

}
