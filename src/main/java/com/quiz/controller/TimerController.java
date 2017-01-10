package com.quiz.controller;

import com.crossover.test.dto.TimerDTO;
import com.crossover.test.exception.ForbiddenException;
import com.crossover.test.persistence.UserExam;
import com.crossover.test.service.UserExamService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Date;

/**
 * /**
 * This is a rest api class for timer services to client.
 * Any client can access timer api through end point url.
 *
 * @author dhruti
 */
@Controller
@RequestMapping(value = "/api/timer")
public class TimerController {

	private static Logger log = Logger.getLogger(TimerController.class);

	@Autowired
	private UserExamService userExamService;

	/**
	 * Check that wheather user has exceeded exam completion time is or not
	 *
	 * @param timerDTO TimerDTO Object
	 * @throws Exception throw forbidden exception when user exceeded the exam duration time.
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public
	@ResponseBody
	void timer(@RequestBody @Valid TimerDTO timerDTO) throws Exception {

		// : TODO get exam & user details from cookie or pass in request
		log.info("Checking user exam time exceed or not for exam {} " + timerDTO.getExamId());

		UserExam userExam = userExamService.getByExamAndUser(timerDTO.getExamId(), timerDTO.getUserId());

		Long startDate = userExam.getStartDate().getTime();
		Long todate = new Date().getTime();
		Long distance = todate - startDate;
		Long duration = timerDTO.getDuration() * 1000;

		log.info("Start datetime  {} " + startDate);
		log.info("Current datetime {} " + todate);
		log.info("Time remains to exceed time in millis {}  " + distance);

		if (distance >= duration) {
			log.info("User has exceeded time for exam {} " + timerDTO.getExamId());
			throw new ForbiddenException("Your time has been exceeded.");
		}
	}
}