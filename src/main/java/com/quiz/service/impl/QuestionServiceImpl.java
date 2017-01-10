package com.quiz.service.impl;

import com.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ChoiceRepository choiceRepository;

	@Transactional
	public Question getByExam(Long examId, Long userId, int offset) {
		Question question = questionRepository.findByExam(examId, userId, offset);
		question.setChoiceCollection(choiceRepository.findByQuestion(question.getId()));
		return question;
	}

	@Transactional
	public List<Question> getByExam(Long examId) {
		return questionRepository.findByExam(examId);
	}

	@Transactional
	public Long getCountByExam(Long examId) {
		return questionRepository.findCountByExam(examId);
	}

	@Transactional
	public Question getById(Long id) {
		return questionRepository.findById(id);
	}

	@Transactional
	public List<Question> getUnAnsweredQuestions(Long examId, Long userId) {
		return questionRepository.findUnAnsweredQuestions(examId, userId);
	}

	@Transactional
	public Long getTotalScoreByExam(Long examId) {
		return questionRepository.findTotalScoreByExam(examId);
	}
