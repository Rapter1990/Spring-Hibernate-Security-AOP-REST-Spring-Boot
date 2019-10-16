package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class SpringMyApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean from spring container
		ICoach theCoach = context.getBean("tennisCoach", ICoach.class);

		ICoach alphaCoach = context.getBean("tennisCoach", ICoach.class);
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);

		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
		
		// close the context
		context.close();
		
				
	}
}
