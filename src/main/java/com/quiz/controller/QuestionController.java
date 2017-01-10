package com.quiz.controller;

import com.crossover.test.dto.QuestionDTO;
import com.crossover.test.dto.QuestionRequestDTO;
import com.crossover.test.exception.BadRequestException;
import com.crossover.test.mapper.QuestionMapper;
import com.crossover.test.persistence.Question;
import com.crossover.test.service.QuestionService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * /**
 * This is a rest api class that provide question services to client.
 * Any client can access question api through end point url.
 * <p>
 * <p>
 * Class perform below operations.
 * <p>
 * <p>
 * 1. Get Questions and It's options to candidate
 * <p>
 * 2. Get all questions to navigate to particular question.
 * <p>
 * 3. Get List of UnAnswered questions that user has not attempted
 *
 * @author dhruti
 */
@Controller
@RequestMapping(value = "/api/question")
public class QuestionController extends BaseController {

	private static final String OBJECT_NAME = "Question";
	private static Logger log = Logger.getLogger(QuestionController.class);
	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuestionMapper questionMapper;

	/**
	 * Return the question for candidate
	 *
	 * @param request Question request details like examid, userid, question number.
	 * @return Question and It's Choices
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public
	@ResponseBody
	QuestionDTO findQuestionByExamId(@RequestBody QuestionRequestDTO request) {

		log.info("Getting question for given exam id {} " + request.getExamId());

		if (request.getQuestionNumber() <= 0) {
			log.info("Invalid question number {} " + request.getQuestionNumber());
			throw new BadRequestException("You have given invalid question number");
		}

		Question question = questionService.getByExam(request.getExamId(), request.getUserId(), request.getQuestionNumber() - 1);
		checkNotFound(question, OBJECT_NAME, request.getExamId());

		log.info("Getting total questions for exam {} " + request.getExamId());
		Long count = questionService.getCountByExam(request.getExamId());

		log.info("Total questions found {} " + count);

		int nextQuestion = request.getQuestionNumber() + 1;
		boolean isLastQuestion = false;

		if (request.getQuestionNumber() >= count) {
			isLastQuestion = true;
		}

		log.info("Question found for given examid {} " + request.getQuestionNumber());

		QuestionDTO questionDTO = questionMapper.convertToQuestionDTO(question);
		questionDTO.setCurrentQuestion(request.getQuestionNumber());
		questionDTO.setNextQuestion(nextQuestion);
		questionDTO.setLastQuestion(isLastQuestion);

		return questionDTO;
	}

	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody QuestionDTO findQuestionById(@PathVariable("id") Long id){

		//: TODO Need to get exam id from cookie
		Long examId = 1L;

		log.info("Getting question for given id {} " + id);
		Question question = questionService.getById(id);

		checkNotFound(question, OBJECT_NAME, id);

		log.info("Getting total questions for exam {} " + examId);
		Long count = questionService.getCountByExam(examId);

		log.info("Total questions found {} " + count);
		boolean isLastQuestion = (question.getQuestionNumber() >= count) ? true : false;

		log.info("Question found for given id {} " + id);
		return questionMapper.convertToQuestionDTO(question, isLastQuestion);
	}*/

	/**
	 * Returns list of Questions with choices
	 *
	 * @param examId Given ExamId
	 * @return List Object
	 */
	@RequestMapping(value = "/list/{examId}", method = RequestMethod.GET)
	public
	@ResponseBody
	List<QuestionDTO> findAllQuestionByExamId(@PathVariable("examId") Long examId) {

		log.info("Getting all questions for exam {} " + examId);
		List<Question> questions = questionService.getByExam(examId);

		log.info("Questions found for exam {} " + questions.size());

		return questionMapper.convertToQuestionDTOs(questions);
	}

	/**
	 * Returns list of questions that are not answered
	 *
	 * @param examId Given ExamId
	 * @param userId Given UserId
	 * @return
	 */
	@RequestMapping(value = "/unanswer/{examId}/{userId}", method = RequestMethod.GET)
	public
	@ResponseBody
	List<QuestionDTO> findUnAnsweredQuestionByExamId(
			@PathVariable("examId") Long examId, @PathVariable("userId") Long userId) {

		log.info("Getting not answered questions for exam {} " + examId);
		List<Question> questions = questionService.getUnAnsweredQuestions(examId, userId);

		log.info("Questions with no answer found for exam {} " + questions.size());

		return questionMapper.convertToQuestionDTOs(questions);
	}
}