package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage(){};
	
	// create pointcat for Getter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter(){};
	
	// create pointcat for Setter method
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter(){};
	
	// create pointcat for DAO package and no getter and setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaopackageNoGetterSetter(){};
}
