package com.quiz.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * This is a logger class that log the api service execution.
 * It log service end point, http method, class, method execution.
 * It also log the result of api call.
 *
 * @author dhruti
 */
@Aspect
@Component
public class ServiceLogger {

	private static Logger log = Logger.getLogger(ServiceLogger.class);

	@Autowired
	private HttpServletRequest request;

	@Before("execution(* com.crossover.test.controller.*.*(..))")
	public void logServiceEntry(JoinPoint joinPoint) {
		log.info("Service end point : " + request.getRequestURI());
		log.info("Service http method : " + request.getMethod());
		log.info("Service class : " + joinPoint.getTarget().getClass().getName());
		log.info("Service method : " + joinPoint.getSignature().getName());
	}

	@AfterReturning(
			pointcut = "execution(* com.crossover.test.controller.*.*(..))", returning = "result")
	public void logServiceResponse(JoinPoint joinPoint, Object result) {
		log.info("Service Response :" + result);
	}

	@AfterThrowing(pointcut = "execution(* com.crossover.test.controller.*.*(..))", throwing = "e")
	public void logServiceException(JoinPoint joinPoint, Exception e) {
		log.error("We have caught exception in method : "
				+ joinPoint.getSignature().getName() + " \n Exception is: "
				+ e.getMessage(), e);
	}
}