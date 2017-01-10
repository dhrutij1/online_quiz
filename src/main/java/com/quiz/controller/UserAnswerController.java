package com.quiz.controller;

import com.crossover.test.dto.UserAnswerDTO;
import com.crossover.test.service.UserAnswerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * /**
 * This is a rest api class that provide user answer services to client.
 * Any client can access api through end point url.
 *
 * @author dhruti
 */
@Controller
@RequestMapping(value = "/api/answer")
public class UserAnswerController extends BaseController {

	private static Logger log = Logger.getLogger(UserAnswerController.class);

	@Autowired
	private UserAnswerService userAnswerService;

	/**
	 * Save the user answer and return the saved result
	 *
	 * @param userAnswerDTO User Answer details
	 * @param result        Validation
	 * @return Return saved answer details
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public
	@ResponseBody
	UserAnswerDTO saveAnswer(@RequestBody @Valid UserAnswerDTO userAnswerDTO, BindingResult result) {

		if (userAnswerDTO.getChoiceId() != null) {

			log.info(String.format("Saving answer for question %s and user %s",
					userAnswerDTO.getQuestionId(), userAnswerDTO.getUserId()));

			userAnswerService.saveAnswer(userAnswerDTO.getUserId(), userAnswerDTO.getQuestionId(), userAnswerDTO.getChoiceId());
			log.info("Answer is saved successfully for {} " + userAnswerDTO.getQuestionId());
		}

		return userAnswerDTO;
	}
}