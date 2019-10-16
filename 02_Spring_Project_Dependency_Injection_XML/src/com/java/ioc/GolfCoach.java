package com.java.ioc;

public class GolfCoach implements ICoach {

	// define a private field for the dependency
	private FortuneService fortuneService;
	
	// define a constructor for dependency injection
	public GolfCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice your putting skills for 2 hours today";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
