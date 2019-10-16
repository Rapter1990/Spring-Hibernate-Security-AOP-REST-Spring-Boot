package com.java.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements ICoach{
	
	@Autowired // Field Injection (No need setter getter method)
	@Qualifier("databaseFortuneService")
	private IFortuneService fortuneService;
	
	public BasketballCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> BasketballCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your free shot activity";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
