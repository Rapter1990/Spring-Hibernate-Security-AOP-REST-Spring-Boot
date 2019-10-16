package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class SpringMyApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// get the bean from spring container(@Component)
		ICoach pingPongCoach = context.getBean("pingPongCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(pingPongCoach.getDailyWorkout());
		
		// get the bean from spring container(@Component)
		ICoach theTennisCoach = context.getBean("theTennisCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(theTennisCoach.getDailyWorkout());
				
		// close the context
		context.close();
		
				
	}
}
