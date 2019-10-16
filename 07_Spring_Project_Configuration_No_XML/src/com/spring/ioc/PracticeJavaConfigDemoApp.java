package com.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.ioc.ICoach;
import com.java.ioc.PracticeSportConfig;

public class PracticeJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		
		// get the bean from spring container
		// PracticeSportConfig.class -> public ICoach wrestlingCoach()
		ICoach theCoach = context.getBean("wrestlingCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method on the bean
		System.out.println(theCoach.getDailyFortune());

		// close the context
		context.close();
		
	}

}


