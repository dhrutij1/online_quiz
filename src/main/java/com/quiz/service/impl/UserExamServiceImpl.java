package com.quiz.service.impl;

import com.quiz.persistence.UserExam;
import com.quiz.service.UserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserExamServiceImpl implements UserExamService {

	@Autowired
	private UserExamRepository userExamRepository;

	@Transactional
	public UserExam getByExamAndUser(Long examId, Long userId) {
		return userExamRepository.findByExamAndUser(examId, userId);
	}

	@Transactional
	public void saveUserExam(Long examId, Long userId) {
		UserExam userExam = new UserExam(new Exam(examId), new User(userId), new Date());
		userExamRepository.save(userExam);
	}

	@Transactional
	public UserExam saveUserScore(Long score, Long percentage, Long userId, Long examId) {

		UserExam userExam = this.getByExamAndUser(examId, userId);
		userExam.setScore(score);
		userExam.setPercentage(percentage);

		return userExamRepository.update(userExam);
	}
}