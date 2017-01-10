package com.quiz.exception;

import com.quiz.constant.ErrorType;

/**
 * This class represent the response for various errors like validations, object not found.
 *
 * @author vasim
 */
public class ErrorResource {

	private String message;
	private ErrorType error;

	public ErrorResource(ErrorType error, String message) {
		this.error = error;
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ErrorType getError() {
		return error;
	}

	public void setError(ErrorType error) {
		this.error = error;
	}
}
