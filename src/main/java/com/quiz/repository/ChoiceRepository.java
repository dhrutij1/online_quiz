package com.quiz.repository;

import com.quiz.persistence.Choice;

import java.util.List;

/**
 * This interface is responsible to perform the database operations for question options.
 *
 * @author dhruti
 */
public interface ChoiceRepository extends GenericRepository<Choice, Long> {

	/**
	 * Returns the list of options for given question
	 *
	 * @param questionId Given question id
	 * @return List Object
	 */
	public List<Choice> findByQuestion(Long questionId);
}