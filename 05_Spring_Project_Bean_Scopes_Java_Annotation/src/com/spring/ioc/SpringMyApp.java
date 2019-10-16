package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;

public class SpringMyApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// get the bean from spring container
		ICoach tennisCoach = context.getBean("tennisCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(tennisCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(tennisCoach.getDailyFortune());
		
		System.out.println("---------------------------------------------------------------");
		
		// get the bean from spring container
		ICoach footballCoach = context.getBean("footballCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(footballCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(footballCoach.getDailyFortune());
		
		System.out.println("---------------------------------------------------------------");
		
		// get the bean from spring container
		ICoach basketballCoach = context.getBean("basketballCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(basketballCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(basketballCoach.getDailyFortune());
		
		System.out.println("---------------------------------------------------------------");
		
		// get the bean from spring container
		ICoach golfCoach = context.getBean("golfCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(golfCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(golfCoach.getDailyFortune());
		
		System.out.println("---------------------------------------------------------------");
				
		// close the context
		context.close();
		
				
	}
}
