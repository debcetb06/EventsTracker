package com.debasis.repoeventstracker.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -434601218641200687L;

	public ResourceNotFoundException() {
        super();
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
