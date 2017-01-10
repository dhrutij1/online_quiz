package com.quiz.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * /**
 * This is a rest api class that provide exam services to client.
 * Any client can access exam api through end point url.
 * <p>
 * <p>
 * Class perform below operations.
 * <p>
 * <p>
 * 1. Get Exam Details
 * <p>
 * 2. Start selected Exam
 * <p>
 *
 * @author dhruti
 */
@Controller
@RequestMapping(value = "/api/exam")
public class ExamController extends BaseController {

	private static final String OBJECT_NAME = "Exam";
	private static Logger log = Logger.getLogger(ExamController.class);
	@Autowired
	private ExamService examService;

	@Autowired
	private ExamMapper examMapper;

	@Autowired
	private UserExamService userExamService;

	/**
	 * Get the exam details for given exam id
	 *
	 * @param id Given exam id
	 * @return Exam Details
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public
	@ResponseBody
	ExamDTO findExamById(@PathVariable("id") Long id) throws ObjectNotFoundException {

		log.info("Getting exam details for given id {} " + id);

		Exam exam = examService.getById(id);
		checkNotFound(exam, OBJECT_NAME, id);

		log.info("Exam found for given id {} " + id);

		return examMapper.convertToExamDTO(exam);
	}

	/**
	 * Start the exam for user and store exam information for that user
	 *
	 * @param examDTO ExamDTO Object
	 * @return ExamDTO object
	 */
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public
	@ResponseBody
	ExamDTO startExam(@RequestBody ExamDTO examDTO) {

		log.info(String.format("Saving user exam with exam id %s for user %s {} ", examDTO.getId(), examDTO.getUserId()));

		UserExam userExam = userExamService.getByExamAndUser(examDTO.getId(), examDTO.getUserId());

		if (userExam == null) {
			userExamService.saveUserExam(examDTO.getId(), examDTO.getUserId());
			log.info(String.format("User exam with exam id %s for user %s saved.", examDTO.getId(), examDTO.getUserId()));
		}

		log.info(String.format("User exam with exam id %s for user %s already exists.", examDTO.getId(), examDTO.getUserId()));
		return new ExamDTO(examDTO.getId());
	}
}