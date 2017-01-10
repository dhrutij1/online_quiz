package com.quiz.exception;

import org.springframework.validation.Errors;

/**
 * This class is responsible to throw validation exception.
 * <p>
 * This class is mostly used to throw validation errors.
 *
 * @author dhruti
 */
public class ValidationException extends AppException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Errors errors;

	public ValidationException() {

	}

	public ValidationException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Returns fields errors
	 *
	 * @return Errors
	 */
	public Errors getErrors() {
		return errors;
	}
}
