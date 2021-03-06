package com.java.ioc;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

@Component // default bean definition tennisCoach
@Scope("prototype") // @Scope("prototype") -> objeyi request oldu�unda yarat�r (birden fazla) yan� adresi g�stermez
//|  @Scope("singleton") -> default olarak bu objeden bir tane yarat�p onu kullan�yor yan� adresi g�sterir. 
public class TennisCoach implements ICoach {

	
	private IFortuneService fortuneService;
	
	public TennisCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> TennisCoach: inside default constructor");
	}

	
	@Autowired // "Constructor Injection "
	// Constructor Injection kulland���m�z i�in onu burada tan�mlamam�z gerekir.
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
