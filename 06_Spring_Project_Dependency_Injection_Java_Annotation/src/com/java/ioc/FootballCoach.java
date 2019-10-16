package com.java.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component // default bean definition footballCoach
public class FootballCoach implements ICoach {

	
	private IFortuneService fortuneService;
	
	public FootballCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> FootballCoach: inside default constructor");
	}

	
	@Autowired // "Constructor Injection "
	// Constructor Injection kullandýðýmýz için onu burada tanýmlamamýz gerekir.
	public FootballCoach(@Qualifier("randomFortuneService") IFortuneService theFortuneService) {
		System.out.println(">> FootballCoach: constructor injection");
		fortuneService = theFortuneService;
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> FootballCoach: inside of doMyStartupStuff()");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println(">> FootballCoach: inside of doMyCleanupStuff()");		
	}
	

	@Override
	public String getDailyWorkout() {
		return "Practice your ball shot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
