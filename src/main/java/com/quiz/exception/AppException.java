package com.quiz.exception;

/**
 * This is a base exception class of the application that inherit RuntimeException class.
 * <p>
 * This class will be inherited by other exception classes to throws exception.
 *
 * @author dhruti
 */
public class AppException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public AppException() {
	}

	/**
	 * Parameterized constructor
	 *
	 * @param message Exception message
	 */

	public AppException(String message) {
		super(message);
	}

	/**
	 * Parameterized constructor
	 *
	 * @param cause Throwable object
	 */
	public AppException(Throwable cause) {
		super(cause);
	}

	/**
	 * Parameterized constructor
	 *
	 * @param message Exception message
	 * @param cause   Throwable object
	 */
	public AppException(String message, Throwable cause) {
		super(message, cause);
	}