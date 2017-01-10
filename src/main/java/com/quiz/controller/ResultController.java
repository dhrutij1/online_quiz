package com.quiz.controller;

import com.crossover.test.dto.ResultDTO;
import com.crossover.test.service.QuestionService;
import com.crossover.test.service.UserAnswerService;
import com.crossover.test.service.UserExamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * /**
 * This is a rest api class that prepare exam result services to client.
 * Any client can access result api through end point url.
 * <p>
 * <p>
 * Class perform below operations.
 * <p>
 * <p>
 * 1. Prepare the exam results for given user and return the total score and percentage for that user.
 * <p>
 *
 * @author dhruti
 */
@Controller
@RequestMapping(value = "/api/result")
public class ResultController {

	private static Logger log = Logger.getLogger(ResultController.class);

	@Autowired
	private QuestionService questionService;

	@Autowired
	private UserAnswerService userAnswerService;

	@Autowired
	private UserExamService userExamService;

	/**
	 * Returns exam results for given user
	 *
	 * @param resultDTO Result Request
	 * @return ResultDTO Object
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public
	@ResponseBody
	ResultDTO result(@RequestBody ResultDTO resultDTO) {

		log.info("Calculating total score for given exam {} " + resultDTO.getExamId());

		Long totalScore = questionService.getTotalScoreByExam(resultDTO.getExamId());
		log.info("Total score for given exam {} " + totalScore);

		log.info("Calculating user score for given exam {} " + resultDTO.getExamId());

		Long userScore = userAnswerService.getScoreByUser(resultDTO.getUserId(), resultDTO.getExamId());
		log.info("User has got score for given exam {} " + userScore);

		log.info("Calculating percentage with given exam for user {} ");

		Long percentage = (userScore * 100) / totalScore;
		log.info("User has got percentage " + percentage + "for given exam {} " + resultDTO.getExamId());

		log.info("Storing user exam result into database table");
		userExamService.saveUserScore(userScore, percentage, resultDTO.getUserId(), resultDTO.getExamId());

		log.info("User result is stored in database table successfully");

		return new ResultDTO(userScore, totalScore, percentage);
	}

}

