package com.java.ioc;

public class SwimCoach implements ICoach {

	private IFortuneService fortuneService;

	public SwimCoach(IFortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warm up.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
