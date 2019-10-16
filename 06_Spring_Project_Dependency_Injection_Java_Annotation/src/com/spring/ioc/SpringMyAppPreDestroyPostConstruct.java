package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class SpringMyAppPreDestroyPostConstruct {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		ICoach theCoach = context.getBean("pingPongCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method on the bean
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
		
				
	}
}
