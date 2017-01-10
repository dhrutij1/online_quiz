package com.quiz.controller;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;

/**
 * This is base controller class that contains some common operations for other controller classes
 * and allow them to use by extending it.
 *
 * @author dhruti
 */
public abstract class BaseController {

	private static Logger log = Logger.getLogger(BaseController.class);

	/**
	 * The method check fields validation and return the appropriate validation result to client
	 *
	 * @param result Hold validation results
	 * @throws BadRequestException throws BadRequestException if validation failed
	 */
	public void validate(BindingResult result) throws ValidationException {

		log.info("Validating entity fields...");

		if (result.hasErrors()) {
			log.info("Validation failed for entity fields , FieldErrors :" + result.getFieldErrorCount());
			throw new ValidationException("Validation Error", result);
		}

		log.info("Fields validated successfully");
	}

	/**
	 * Response object not available if not found
	 *
	 * @param entity     Entity
	 * @param objectName Field Name
	 * @param objectId   Field Value
	 */
	public void checkNotFound(BaseEntity entity, String objectName, Object objectId) {
		if (entity == null) {
			log.info(String.format("The %s given with id %s could not be found", objectName, objectId));
			throw new ObjectNotFoundException(
					String.format("The %s given with id %s could not be found", objectName, objectId));
		}
	}
}