package com.quiz.exception;

/**
 * This class is responsible to throw bad request exception.
 * <p>
 * This class is mostly used to throw validation errors.
 *
 * @author dhruti
 */
public class BadRequestException extends AppException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public BadRequestException() {

	}

	/**
	 * Parameterized constructor
	 *
	 * @param cause Throwable object
	 */
	public BadRequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * Parameterized constructor
	 *
	 * @param message exception message
	 */
	public BadRequestException(String message) {
		super(message);
	}

	/**
	 * Parameterized constructor
	 *
	 * @param message Exception message
	 * @param cause   Throwable object
	 */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
