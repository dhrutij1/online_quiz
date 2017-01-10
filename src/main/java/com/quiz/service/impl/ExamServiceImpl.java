package com.quiz.service.impl;

import com.quiz.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamRepository examRepository;

	@Transactional
	public Exam getById(Long id) {
		return examRepository.findById(id);
	}
}
