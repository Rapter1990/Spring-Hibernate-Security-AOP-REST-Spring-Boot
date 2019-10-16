package com.java.ioc;

public class BaseballCoach implements ICoach{

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public BaseballCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes on batting practise";
	}
	
	@Override
	public String getDailyFortune() {		
		// use my fortuneService to get a fortune		
		return fortuneService.getFortune();
	}
}
