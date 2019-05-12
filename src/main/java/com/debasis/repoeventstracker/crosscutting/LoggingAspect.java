package com.debasis.repoeventstracker.crosscutting;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.debasis.repoeventstracker.controller.RepoEventsTrackerContoller;

/**
 * <p>Class:LoggingAspect is used to measure api execution time in ms
 * @author Debasis Panda
 *
 */
@Aspect
@Component
public class LoggingAspect {
	private static final Logger LOGGER = LogManager.getLogger(RepoEventsTrackerContoller.class);

	  @Around("execution(* com.debasis.repoeventstracker.controller..*(..))")
	  public Object profileExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	    long start = System.currentTimeMillis();
	    String className = joinPoint.getSignature().getDeclaringTypeName();
	    String methodName = joinPoint.getSignature().getName();
	    String apiName =  new StringBuilder(className).append(".").append(methodName).toString();
	    Object result = joinPoint.proceed();
	    long elapsedTime = System.currentTimeMillis() - start;
	    LOGGER.info("Execution Time: [API: {}] {} ms ",apiName, elapsedTime);
	    return result;
	  }
}
