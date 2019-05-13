package com.debasis.repoeventstracker.exception;

/**
 * <p>class ResourceNotFoundException will be  thrown if there are no details avaiable for the request
 * @author Debasis Panda
 *
 */
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
