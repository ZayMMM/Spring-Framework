package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(4)
public class MyDemoLoogingAspect1 {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());

	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====>>>> Execution @Around on method : " + method);

		long begin = System.currentTimeMillis();

		Object result = theProceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;
		myLogger.info("\n====>>>> Duration : " + duration / 1000.0 + " seconds");

		return result;
	}
	
	@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object afterGetFurtune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			myLogger.warning(e.getMessage());
			
			// show the message without handle exception
			result = "Major accident! But no worries, "
					+ " your private AOP helioper is on my way!";
			
			// @Around handle exception
			// throw e;
		}
		
		return result;
	}

}
