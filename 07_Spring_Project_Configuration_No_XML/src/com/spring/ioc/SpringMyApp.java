package com.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.config.logger.LoggerConfig;
import com.java.ioc.ICoach;
import com.java.ioc.SportConfig;

public class SpringMyApp {

	public static void main(String[] args) {
		
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		
		// get the bean from spring container
		ICoach theCoach = context.getBean("tennisCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
					
		// close the context
		context.close();
		
				
	}
}
