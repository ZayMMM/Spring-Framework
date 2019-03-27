package com.luv2code.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = null;	

		Boolean tripWire = false;
		theAccounts = theAccountDao.findAccounts(tripWire);

		context.close();
	}

}
