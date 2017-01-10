package com.quiz.service;

import com.quiz.persistence.Question;

import java.util.List;

/**
 * This interface define service layer operations for question.
 * <p>
 * QuestionServiceImpl class implements all operation for this interface.
 *
 * @author dhruti
 */
public interface QuestionService {

	/**
	 * Get the question for given exam and number
	 *
	 * @param examId Given exam id
	 * @param userId Given user id
	 * @param offset Given question number
	 * @return Question object
	 */
	public Question getByExam(Long examId, Long userId, int offset);

	/**
	 * Get all questions for given exam
	 *
	 * @param examId Given exam id
	 * @return List of Question object
	 */
	public List<Question> getByExam(Long examId);

	/**
	 * Get the question count for a given exam
	 *
	 * @param examId Given exam id
	 * @return Total questions count
	 */
	public Long getCountByExam(Long examId);

	/**
	 * Get the question for given id
	 *
	 * @param id Given question id
	 * @return Question object
	 */
	public Question getById(Long id);

	/**
	 * Get all questions that are not answered by user for given exam
	 *
	 * @param examId Given exam id
	 * @param userId Given user id
	 * @return List object
	 */
	public List<Question> getUnAnsweredQuestions(Long examId, Long userId);

	/**
	 * Get total score for a given exam
	 *
	 * @param examId Given exam id
	 * @return Total score for exam
	 */
	public Long getTotalScoreByExam(Long examId);
}
