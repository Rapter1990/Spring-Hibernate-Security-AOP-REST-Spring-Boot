package com.java.ioc;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Component // default bean definition tennisCoach
public class TennisCoach implements ICoach {

	
	private IFortuneService fortuneService;
	
	public TennisCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> TennisCoach: inside default constructor");
	}

	
	@Autowired // "Constructor Injection "
	// Constructor Injection kullandýðýmýz için onu burada tanýmlamamýz gerekir.
	public TennisCoach(@Qualifier("happyFortuneService") IFortuneService theFortuneService) {
		System.out.println(">> TennisCoach: constructor injection");
		fortuneService = theFortuneService;
	}
	
	/*@Autowired // "Method Injection "
	public void doActivity(IFortuneService theFortuneService) {
		System.out.println(">> TennisCoach| doActivity : Method Injection");
		fortuneService = theFortuneService;
	}*/
	

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
