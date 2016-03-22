/**
 * 
 */
package com.gehc.apps.demo.dablog.model.user;

/**
 * Exception raised when user is unknown or not authenticated.
 * 
 * @author Frédéric Delorme
 *
 */
public class UnknownUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7492386855094193003L;

	/**
	 * 
	 */
	public UnknownUserException() {
		super();
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public UnknownUserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public UnknownUserException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public UnknownUserException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public UnknownUserException(Throwable cause) {
		super(cause);
	}

}
