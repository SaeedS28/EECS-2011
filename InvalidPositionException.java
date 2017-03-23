package a2;

public class InvalidPositionException extends RuntimeException {
	
	private static final long serialVersionUID = 1L; //Housekeeping attribute.

	/**
	 * Creates an instance of the exception and assigns it a custom message.
	 * @param message
	 */
	public InvalidPositionException(String message){
		super(message);
	}

}
