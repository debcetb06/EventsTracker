package com.debasis.repoeventstracker.exception;

public class SystemException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -434601218641200687L;

	public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
