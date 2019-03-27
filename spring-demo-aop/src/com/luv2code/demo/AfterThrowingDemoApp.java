package com.luv2code.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class AfterThrowingDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

		Boolean tripWire = true;
		List<Account> theAccounts = theAccountDao.findAccounts(tripWire);

		context.close();
	}

}
