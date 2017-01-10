package com.quiz.service;

import com.quiz.persistence.Exam;

/**
 * This interface define service layer operations for exam.
 * <p>
 * ExamServiceImpl class implements all operation for this interface.
 *
 * @author dhruti
 */
public interface ExamService {

	/**
	 * Get the exam for given id
	 *
	 * @param id Given id
	 * @return Exam Details
	 */
	public Exam getById(Long id);
}