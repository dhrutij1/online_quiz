package com.quiz.repository;

import com.quiz.persistence.Question;

import java.util.List;

/**
 * This interface is responsible to perform the database operations for questions.
 *
 * @author vasim
 */
public interface QuestionRepository extends GenericRepository<Question, Long> {

	/**
	 * Return question for given exam and question number
	 *
	 * @param examId Given exam id
	 * @param userId Given user  id
	 * @param offset Given question number
	 * @return Question Object
	 */
	public Question findByExam(Long examId, Long userId, int offset);

	/**
	 * Return all questions for given exam
	 *
	 * @param examId Given exam id
	 * @return List Object
	 */
	public List<Question> findByExam(Long examId);

	/**
	 * Returns count of questions for given exam
	 *
	 * @param examId Given exam id
	 * @return Questions count
	 */
	public Long findCountByExam(Long examId);

	/**
	 * Returns all questions that are not answered by a given user
	 *
	 * @param examId Given exam id
	 * @param userId Given user id
	 * @return List object
	 */
	public List<Question> findUnAnsweredQuestions(Long examId, Long userId);

	/**
	 * Return total score for a given exam
	 *
	 * @param examId Given exam id
	 * @return Score count
	 */
	public Long findTotalScoreByExam(Long examId);
}