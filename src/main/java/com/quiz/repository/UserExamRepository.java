package com.quiz.repository;

import com.quiz.persistence.UserExam;

/**
 * This interface is responsible to perform the database operations for user and it's exam
 *
 * @author dhruti
 */
public interface UserExamRepository extends GenericRepository<UserExam, Long> {

	/**
	 * Returns the exam details for given user
	 *
	 * @param examId Given exam id
	 * @param userId Given user id
	 * @return UserExam Object
	 */
	public UserExam findByExamAndUser(Long examId, Long userId);
}