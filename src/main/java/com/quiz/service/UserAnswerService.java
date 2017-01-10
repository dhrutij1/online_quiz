package com.quiz.service;

import com.quiz.persistence.UserQuestionAnswer;

/**
 * This interface define service layer operations for useranswer.
 * <p>
 * UserAnswerServiceImpl class implements all operation for this interface.
 *
 * @author dhruti
 */
public interface UserAnswerService {

	/**
	 * Save answer for given user and exam with question option.
	 *
	 * @param userId     Given user id
	 * @param questionId Given question id
	 * @param choiceId   Given options id
	 * @return UserQuestionAnswer object
	 */
	public UserQuestionAnswer saveAnswer(Long userId, Long questionId, Long choiceId);

	/**
	 * Get the user score for given exam
	 *
	 * @param userId Given user id
	 * @param examId Given exam id
	 * @return Total user score
	 */
	public Long getScoreByUser(Long userId, Long examId);
}
