package com.quiz.service;

import com.quiz.persistence.User;

/**
 * This interface define service layer operations for user.
 * <p>
 * UserServiceImpl class implements all operation for this interface.
 *
 * @author vasim
 */
public interface UserService {

	/**
	 * Get the user by given email
	 *
	 * @param email Given email
	 * @return User object
	 */
	public User getByEmail(String email);
}
