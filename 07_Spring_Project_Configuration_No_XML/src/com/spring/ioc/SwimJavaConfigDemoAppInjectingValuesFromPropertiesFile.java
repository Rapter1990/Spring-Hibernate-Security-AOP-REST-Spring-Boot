package com.spring.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.java.ioc.SportConfigInjectingValuesFromPropertiesFile;
import com.java.ioc.SwimCoachInjectingValuesFromPropertiesFile;

public class SwimJavaConfigDemoAppInjectingValuesFromPropertiesFile {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfigInjectingValuesFromPropertiesFile.class);
		
		// get the bean from spring container
		SwimCoachInjectingValuesFromPropertiesFile theCoach = context.getBean("swimCoach", SwimCoachInjectingValuesFromPropertiesFile.class);
		
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
				
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
			
		// call our new swim coach methods ... has the props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
			
	}

}


