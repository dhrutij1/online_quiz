package com.quiz.exception;

/**
 * This class is responsible to throw ObjectNotFoundException.
 * <p>
 * It is used to throw runtime exception when object which has been getting is unavailable.
 *
 * @author vasim
 */
public class ObjectNotFoundException extends AppException {

	/**
	 *
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public ObjectNotFoundException() {

	}

	/**
	 * Parameterized construction
	 *
	 * @param message Exception message
	 */
	public ObjectNotFoundException(String message) {
		super(message);
	}

	/**
	 * Parameterized constructor
	 *
	 * @param message Exception message
	 * @param cause   Throwable object
	 */
	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}