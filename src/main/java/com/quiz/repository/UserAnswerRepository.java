package com.quiz.repository;

import com.quiz.persistence.UserQuestionAnswer;

/**
 * This interface is responsible to perform the database operations for user answer.
 *
 * @author dhruti
 */
public interface UserAnswerRepository extends GenericRepository<UserQuestionAnswer, Long> {

	/**
	 * Returns answer for given user and question
	 *
	 * @param userId     Given user id
	 * @param questionId Given question id
	 * @return
	 */
	public UserQuestionAnswer findByUserAndQuestion(Long userId, Long questionId);

	/**
	 * Returns User score for given exam
	 *
	 * @param userId Given user id
	 * @param examId Given exam id
	 * @return total score
	 */
	public Long findScoreByUser(Long userId, Long examId);
}