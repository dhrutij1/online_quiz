package com.quiz.mapper;

import com.quiz.dto.UserAnswerDTO;
import org.springframework.stereotype.Component;

/**
 * This is a mapper class that map UserAnswer data transportation object to UserQuestionAnwer persistence object.
 *
 * @author dhruti
 */
@Component
public class UserAnswerMapper {

	public UserAnswerDTO convertToUserAnswerDTO(UserQuestionAnswer uqa) {
		UserAnswerDTO userAnswerDTO = new UserAnswerDTO();

		userAnswerDTO.setChoiceId(uqa.getChoice().getId());
		userAnswerDTO.setQuestionId(uqa.getQuestion().getId());
		userAnswerDTO.setUserId(uqa.getUser().getId());

		return userAnswerDTO;
	}
}