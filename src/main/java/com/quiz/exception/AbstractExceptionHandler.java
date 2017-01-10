package com.quiz.exception;

import com.quiz.constant.ErrorType;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * This class handle all exceptions thrown by any controller method at the same place.
 * <p>
 * It allows to apply exception handling at one place instead of applying in every controller method.
 * <p>
 * It handle below exceptions and provide appropriate response for exception to client.
 * <p>
 * 1. BadRequestException
 * <p>
 * 2.ObjectNotFoundException
 * <p>
 * 3. Exception
 *
 * @author dhruti
 */
@ControllerAdvice
public class AbstractExceptionHandler {

	private static Logger log = Logger.getLogger(AbstractExceptionHandler.class);

	/**
	 * This method handle exception for field validation and throw the exception to api.
	 *
	 * @param ve ValidationException
	 * @return Error messgae with HttpStatus code 400
	 * @throws IOException
	 */
	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResource handleValidationException(ValidationException ve) throws IOException {
		FieldError error = ve.getErrors().getFieldError();
		return new ErrorResource(ErrorType.BAD_REQUEST, error.getDefaultMessage());
	}

	/**
	 * This method handle exception for object not found and throw the exception to api.
	 *
	 * @param ve ObjectNotFoundException
	 * @return Error messgae with HttpStatus code 404
	 * @throws IOException
	 */
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ErrorResource handleObjectNotFoundException(ObjectNotFoundException ex) throws IOException {
		return new ErrorResource(ErrorType.NOT_FOUND, ex.getMessage());
	}

	/**
	 * This method handle exception for bad request and throw the exception to api.
	 *
	 * @param ve BadRequestException
	 * @return Error messgae with HttpStatus code 400
	 * @throws IOException
	 */
	@ExceptionHandler(BadRequestException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ErrorResource handleBadRequestException(BadRequestException bre) {
		return new ErrorResource(ErrorType.BAD_REQUEST, bre.getMessage());
	}

	/**
	 * This method handle exception for forbidden and throw the exception to api.
	 *
	 * @param ve ForbiddenException
	 * @return Error messgae with HttpStatus code 403
	 * @throws IOException
	 */
	@ExceptionHandler(ForbiddenException.class)
	@ResponseStatus(value = HttpStatus.FORBIDDEN)
	@ResponseBody
	public ErrorResource handleForbiddenException(ForbiddenException fe) {
		return new ErrorResource(ErrorType.FORBIDDEN, fe.getMessage());
	}

	/**
	 * Returns error response for exception.
	 *
	 * @param ex Exception object
	 * @return Exception message and error type
	 * @throws IOException
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorResource handleInternalServerException(Exception ex) throws IOException {
		return new ErrorResource(ErrorType.INTERNAL_SERVER_ERROR, ex.getMessage());
	}
}


