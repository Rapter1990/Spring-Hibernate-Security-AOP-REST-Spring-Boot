package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class BeanLifeCycleDemoApp {
	
	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("xml/beanLifeCycle-applicationContext.xml");
				
		// retrieve bean from spring container
		ICoach theCoach = context.getBean("myCoach", ICoach.class);

		System.out.println(theCoach.getDailyWorkout());
		
		// close the context
		context.close();
	}

}








