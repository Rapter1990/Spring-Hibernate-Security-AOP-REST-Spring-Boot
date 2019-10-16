package com.java.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class RugbyCoach implements ICoach{
	
	@Autowired // Field Injection (No need setter getter method)
	@Qualifier("randomFileFortuneService")
	private IFortuneService fortuneService;
	
	public RugbyCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> RugbyCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your Rugby shot activity";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
