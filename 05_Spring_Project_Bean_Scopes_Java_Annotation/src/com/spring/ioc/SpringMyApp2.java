package com.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.ICoach;
import com.java.ioc.RugbyCoach;

public class SpringMyApp2 {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext2.xml");
				
		// get the bean from spring container
		ICoach rugbyCoach = context.getBean("rugbyCoach", ICoach.class);
		
		// call a method on the bean
		System.out.println(rugbyCoach.getDailyWorkout());

		// call method to get daily fortune
		System.out.println(rugbyCoach.getDailyFortune());
		
		
		System.out.println("---------------------------------------------------------------");
		
						
		// close the context
		context.close();
		
				
	}
}
