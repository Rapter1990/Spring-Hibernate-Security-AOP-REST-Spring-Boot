package com.java.ioc;

import org.springframework.stereotype.Component;

@Component
public class WrestlingCoach implements ICoach {

	private IFortuneService fortuneService;
			
	public WrestlingCoach(IFortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your double leg takedown.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
