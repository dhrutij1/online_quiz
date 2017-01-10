package com.quiz.mapper;

import com.quiz.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a mapper class that map Question data transportation object to Question persistence object.
 *
 * @author dhruti
 */
@Component
public class QuestionMapper {

	@Autowired
	private UserAnswerMapper userAnswerMapper;

	public QuestionDTO convertToQuestionDTO(Question question) {
		QuestionDTO questionDTO = new QuestionDTO();

		questionDTO.setId(question.getId());
		questionDTO.setPoint(question.getPoint());
		questionDTO.setText(question.getText());
		questionDTO.setOptions(convertToChoiceDTO(question.getChoiceCollection()));

		if (question.getUserQuestionAnswerCollection() != null
				&& question.getUserQuestionAnswerCollection().size() > 0) {

			UserAnswerDTO userAnswerDTO = userAnswerMapper.convertToUserAnswerDTO(question.getUserQuestionAnswerCollection().get(0));
			questionDTO.setUserAnswer(userAnswerDTO);
		}

		return questionDTO;
	}

	public List<QuestionDTO> convertToQuestionDTOs(List<Question> questions) {

		List<QuestionDTO> questionDTOs = new ArrayList<>();

		for (Question question : questions) {

			QuestionDTO questionDTO = new QuestionDTO();
			questionDTO.setId(question.getId());
			questionDTO.setText(question.getText());

			questionDTOs.add(questionDTO);
		}

		return questionDTOs;
	}

	public List<ChoiceDTO> convertToChoiceDTO(List<Choice> options) {
		List<ChoiceDTO> choiceDTOs = new ArrayList<>();

		for (Choice option : options) {
			ChoiceDTO choiceDTO = new ChoiceDTO();

			choiceDTO.setId(option.getId());
			choiceDTO.setText(option.getText());
			choiceDTO.setCorrect(option.isCorrect());

			choiceDTOs.add(choiceDTO);
		}

		return choiceDTOs;
	}
}