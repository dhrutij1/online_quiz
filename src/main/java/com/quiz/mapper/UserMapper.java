package com.quiz.mapper;

import com.quiz.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * This is a mapper class that map User data transportation object to user persistence object.
 *
 * @author dhruti
 */
@Component
public class UserMapper {

	public UserDTO convertToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setFirstName(user.getFirstName());
		userDTO.setLastName(user.getLastName());
		userDTO.setEmail(user.getEmail());

		return userDTO;
	}
}