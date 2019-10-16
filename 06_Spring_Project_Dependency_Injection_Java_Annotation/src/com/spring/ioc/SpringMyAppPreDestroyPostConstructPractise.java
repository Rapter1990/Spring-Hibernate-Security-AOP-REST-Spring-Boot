package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class SpringMyAppPreDestroyPostConstructPractise {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		ICoach footballCoach = context.getBean("footballCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(footballCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(footballCoach.getDailyFortune());
				
		// close the context
		context.close();	
		
				
	}
}
