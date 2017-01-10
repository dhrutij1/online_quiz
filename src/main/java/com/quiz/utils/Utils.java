package com.quiz.utils;

import com.quiz.persistence.User;

/**
 * This is a class that is responsible to handle utilities operations
 *
 * @author dhruti
 */
public class Utils {

	public static boolean validateUserPassword(User user, String password) {
		return user.getPassword().equals(password);
	}
}