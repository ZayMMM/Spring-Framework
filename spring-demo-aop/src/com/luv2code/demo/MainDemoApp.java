package com.luv2code.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.Account;
import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		AccountDAO theAccountDao = context.getBean("accountDAO", AccountDAO.class);

		MemberShipDAO theMemberAccountDao = context.getBean("memberShipDAO", MemberShipDAO.class);

		Account theAccount = new Account();
		theAccount.setName("joe");
		theAccount.setLevel("000");
		theAccountDao.addAccount(theAccount, true);
		theAccountDao.addSillyMember();
		
		theAccountDao.setName("Zay");
		theAccountDao.setServiceCode("000");
		
		String name = theAccountDao.getName();
		String serviceCode = theAccountDao.getServiceCode();

		theMemberAccountDao.addAccount();
		theMemberAccountDao.isCorrect();

		context.close();
	}

}
