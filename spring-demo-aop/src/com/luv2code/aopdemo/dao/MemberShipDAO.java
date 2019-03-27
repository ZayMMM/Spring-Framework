package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

	public void addAccount() {
		System.out.println(getClass() + "DOING MY DB WORK : ADDING AN ACCOUNT");
	}

	public boolean isCorrect() {

		System.out.println(getClass() + "Is Correct !");
		return true;
	}

}
