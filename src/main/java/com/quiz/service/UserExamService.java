package com.quiz.service;

import com.quiz.persistence.UserExam;

/**
 * This interface define service layer operations for user exam.
 * <p>
 * UserExamServiceImpl class implements all operation for this interface.
 *
 * @author vasim
 */
public interface UserExamService {

	/**
	 * Get the exam for given user
	 *
	 * @param examId Given exam id
	 * @param userId Given user id
	 * @return UserExam object
	 */
	public UserExam getByExamAndUser(Long examId, Long userId);

	/**
	 * Save the exam for given user
	 *
	 * @param examId Given exam id
	 * @param userId Given user id
	 */
	public void saveUserExam(Long examId, Long userId);

	/**
	 * Save the total score and percentage for given exam and user
	 *
	 * @param score      User score
	 * @param percentage User percentage
	 * @param userId     Given user id
	 * @param examId     Given exam id
	 * @return UserExam object
	 */
	public UserExam saveUserScore(Long score, Long percentage, Long userId, Long examId);
}