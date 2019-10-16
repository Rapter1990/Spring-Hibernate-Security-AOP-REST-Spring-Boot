package com.java.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements ICoach{
	
	@Autowired // Field Injection (No need setter getter method)
	@Qualifier("fileFortuneService")
	private IFortuneService fortuneService;
	
	public GolfCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> GolfCoach: inside default constructor");
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your golf shot activity";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
