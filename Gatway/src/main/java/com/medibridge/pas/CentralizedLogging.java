package com.medibridge.pas;


import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class CentralizedLogging {
	
	private static final Logger log = LoggerFactory.getLogger(CentralizedLogging.class); // this line not needed if lombok is working fine
	
	private static final String POINTCUT = "within(com.medibridge.pas.*)";
	
	@Around(POINTCUT)
	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
		log.info("Before {}", constructLogMsg(pjp));
		Object proceed = pjp.proceed();
		log.info("After {}, result: {}", constructLogMsg(pjp), proceed.toString());
		return null;
		
	}

	@AfterThrowing(pointcut = POINTCUT, throwing = "e")
	public void logAfterException(ProceedingJoinPoint jp, Exception e) {
		log.error("Exception during: {} with ex: {}", constructLogMsg(jp), e.toString());
	}
	
	private String constructLogMsg(ProceedingJoinPoint pjp) {
		return Arrays.asList(pjp.getArgs())
				.stream()
				.map(String::valueOf)
				.collect(Collectors.joining(",", "[", "]"));

	}
	
}
