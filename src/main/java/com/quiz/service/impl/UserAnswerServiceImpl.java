package com.quiz.service.impl;

import com.quiz.persistence.UserQuestionAnswer;
import com.quiz.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAnswerServiceImpl implements UserAnswerService {

	@Autowired
	private UserAnswerRepository userAnswerRepository;

	@Transactional
	public UserQuestionAnswer saveAnswer(Long userId, Long questionId, Long choiceId) {

		UserQuestionAnswer userAnswer = userAnswerRepository.findByUserAndQuestion(userId, questionId);

		if (userAnswer == null) {
			userAnswer = new UserQuestionAnswer();
			userAnswer.setChoice(new Choice(choiceId));
			userAnswer.setQuestion(new Question(questionId));
			userAnswer.setUser(new User(userId));

		} else {
			userAnswer.setChoice(new Choice(choiceId));
		}

		return userAnswerRepository.saveOrUpdate(userAnswer);
	}

	@Transactional
	public Long getScoreByUser(Long userId, Long examId) {
		return userAnswerRepository.findScoreByUser(userId, examId);
	}
}
