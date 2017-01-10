package com.quiz.service.impl;

import com.quiz.persistence.User;
import com.quiz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}