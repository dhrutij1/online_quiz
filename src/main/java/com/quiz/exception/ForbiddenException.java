package com.quiz.exception;

/**
 * This class throw forbidden exception and related message.
 *
 * @author dhruti
 */
public class ForbiddenException extends AppException {

	/**
	 *
	 */
	private static final long serialVersionUID = 8759210716433846418L;

	public ForbiddenException() {

	}

	public ForbiddenException(String message) {
		super(message);
	}
}
