package com.spring.ioc;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class SpringMyApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean from spring container
		ICoach myTrackCoach = context.getBean("myTrackCoach", ICoach.class);
		
		// call methods on the bean
		System.out.println(myTrackCoach.getDailyWorkout());
		
		ICoach myBaseballCoach = context.getBean("myBaseballCoach", ICoach.class);
		System.out.println(myBaseballCoach.getDailyWorkout());
		
		ICoach myGolfCoach = context.getBean("myGolfCoach", ICoach.class);
		System.out.println(myGolfCoach.getDailyWorkout());
	
		// close the context
		context.close();
		
				
	}
}
