package com.java.ioc;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoachInjectingValuesFromPropertiesFile implements ICoach {

	private IFortuneService fortuneService;

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public SwimCoachInjectingValuesFromPropertiesFile(IFortuneService theFortuneService) {
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

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}	
	
}
