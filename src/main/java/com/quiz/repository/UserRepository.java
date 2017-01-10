package com.quiz.repository;

import com.quiz.persistence.User;

/**
 * This interface is responsible to perform the database operations for user.
 *
 * @author vasim
 */
public interface UserRepository extends GenericRepository<User, Long> {

	/**
	 * Returns the user details for given user email
	 *
	 * @param email Given email
	 * @return User object
	 */
	public User findByEmail(String email);
}