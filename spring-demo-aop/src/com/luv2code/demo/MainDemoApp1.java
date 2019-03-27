package com.luv2code.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp1 {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> theAccounts = theAccountDao.findAccounts();
		
		context.close();
	}

}
