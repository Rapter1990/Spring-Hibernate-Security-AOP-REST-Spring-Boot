package com.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.ioc.ICoach;
import com.java.ioc.SportConfig;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		// swimCoach -> SportConfig.java -> methodaki ad -> public ICoach |swimCoach()| 
		ICoach theCoach = context.getBean("swimCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
			
		// close the context
		context.close();
		
	}

}


