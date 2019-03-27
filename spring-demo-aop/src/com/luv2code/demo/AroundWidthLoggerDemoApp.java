package com.luv2code.demo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWidthLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWidthLoggerDemoApp.class.getName());

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("Calling getFortune()");
		Boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire);

		myLogger.info(data);
		myLogger.info("Finished!");
		context.close();
	}

}
