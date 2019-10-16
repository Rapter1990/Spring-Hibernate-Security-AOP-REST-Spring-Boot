package com.spring.ioc;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.CricketCoach;
import com.java.ioc.FootballCoach;
import com.java.ioc.ICoach;

public class SpringMyApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Ýlk baþta applicationContext.xml yukarýdan aþaðýya doðru class larý compile eder. 
		
		
		// Constructor Injection
		ICoach coach = context.getBean("myCoach", ICoach.class);
		
		// call methods on the bean
		System.out.println(coach.getDailyWorkout());
		
		// let's call our new method for fortunes
		System.out.println(coach.getDailyFortune());
		
		System.out.println("-----------------------------------------------------------");
		
		// Setter Injection
		// retrieve bean from spring container
		CricketCoach theCoach = context.getBean("myCricketCoach", CricketCoach.class);
		
		// call methods on the bean
		// ... let's come back to this ...
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		System.out.println("-----------------------------------------------------------");
		
		// Injecting Literal Values
		FootballCoach myFootballCoach = context.getBean("myFootballCoach", FootballCoach.class);
		System.out.println(myFootballCoach.getEmailAddress());
		System.out.println(myFootballCoach.getTeam());
		System.out.println(myFootballCoach.getDailyWorkout());
		System.out.println(myFootballCoach.getDailyFortune());
		
		System.out.println("-----------------------------------------------------------");
		
		// Injecting Literal Values From Properties File
		FootballCoach myFootballCoachFromPropertiesFile = context.getBean("myFootballCoachFromPropertiesFile", FootballCoach.class);
		System.out.println(myFootballCoachFromPropertiesFile.getEmailAddress());
		System.out.println(myFootballCoachFromPropertiesFile.getTeam());
		System.out.println(myFootballCoachFromPropertiesFile.getDailyWorkout());
		System.out.println(myFootballCoachFromPropertiesFile.getDailyFortune());
		
		System.out.println("-----------------------------------------------------------");
		
		// retrieve bean from spring container
		ICoach myGolfCoach = context.getBean("myGolfCoach", ICoach.class);
		
		// call methods on the bean
		System.out.println(myGolfCoach.getDailyWorkout());
		System.out.println(myGolfCoach.getDailyFortune());
		
		// close the context
		context.close();
		
		
	}
}
