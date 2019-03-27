package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.dao.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoogingAspect {

	// @Before("execution(* add*(com.luv2code.aopdemo.dao.Account))")

	// @Before("forDaoPackage()")
	/*
	 * @Before(
	 * "com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaopackageNoGetterSetter()")
	 * public void beforeAddAccountAdvice() { System.out.
	 * println("\n=======>>> Execution @Before advice on addAccount()"); }
	 */

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaopackageNoGetterSetter()")
	public void beforeAddAccountAdviceWithMethodArgument(JoinPoint theJoinpoint) {
		System.out.println("\n=====>>>> Execution @Before advice on method");

		// display the method signature
		MethodSignature methodSign = (MethodSignature) theJoinpoint.getSignature();

		System.out.println("Method : " + methodSign);

		// get arg
		Object[] args = theJoinpoint.getArgs();

		// loops the args
		for (Object tempArg : args) {
			System.out.println(tempArg);

			if (tempArg instanceof Account) {
				// downcast and print account info
				Account theAccount = (Account) tempArg;

				System.out.println("Account Name : " + theAccount.getName());
				System.out.println("Account Level : " + theAccount.getLevel());
			}
		}

	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {

		// print out the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Execution @AfterReturning on method : " + method);

		// print out the result of the method call
		System.out.println("\n====>>>> Result is : " + result);

		// convert name to Upper Case
		convertAccountNamesToUpperCase(result);

		// print out the result of the method call
		System.out.println("\n====>>>> Result is : " + result);
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {

		// print out the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Execution @AfterThrowing on method : " + method);

		// log the exception
		System.out.println("\n====>>>> The exception is : " + theExc);
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {

		// print out the method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Execution @After (Finally) on method : " + method);
	}

	/*@Around("execution(* com.luv2code.aopdemo.service.TrafficFortuneService.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {

		// print out the method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>>> Execution @Around on method : " + method);

		long begin = System.currentTimeMillis();

		Object result = theProceedingJoinPoint.proceed();

		long end = System.currentTimeMillis();

		long duration = end - begin;
		System.out.println("\n====>>>> Duration : " + duration / 1000.0 + " seconds");

		return result;
	}*/

	private void convertAccountNamesToUpperCase(List<Account> result) {

		for (Account tempAccount : result) {
			String theUpperName = tempAccount.getName().toLowerCase();

			tempAccount.setName(theUpperName);

		}
	}
}
