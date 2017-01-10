package com.quiz.controller;

import com.crossover.test.dto.UserDTO;
import com.crossover.test.exception.BadRequestException;
import com.crossover.test.mapper.UserMapper;
import com.crossover.test.persistence.User;
import com.crossover.test.service.UserExamService;
import com.crossover.test.service.UserService;
import com.crossover.test.utils.Utils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * /**
 * This is a rest api class that provide user services to client.
 * Any client can access user api through end point url.
 *
 * @author vasim
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserController extends BaseController {

	private static Logger log = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@Autowired
	private UserExamService userExamService;

	@Autowired
	private UserMapper userMapper;

	/**
	 * Check user authentication
	 *
	 * @param userDTO User authentication details like email, password etc..
	 * @param result  Store validation result
	 * @return Loggedin user details
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public
	@ResponseBody
	UserDTO findExamById(@RequestBody @Valid UserDTO userDTO, BindingResult result) {

		// : TODO get examid from cookie or pass in login request
		Long examId = 1L;

		validate(result);

		log.info("Authenticating user for {} " + userDTO.getEmail());
		User user = userService.getByEmail(userDTO.getEmail());

		if (user != null && Utils.validateUserPassword(user, userDTO.getPassword())) {
			log.info("User authenticated successfully for {} " + userDTO.getEmail());
			return userMapper.convertToUserDTO(user);
		}

		throw new BadRequestException("Invalid Email/Password combination");
	}

}