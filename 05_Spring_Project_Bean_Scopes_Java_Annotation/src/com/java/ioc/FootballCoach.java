package com.java.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // default bean definition footballCoach
public class FootballCoach implements ICoach{

	private IFortuneService fortuneService;
	
	public FootballCoach() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println(">> FootballCoach: inside default constructor");
	}

	public IFortuneService getFortuneService() {
		return fortuneService;
	}

	@Autowired // "Setter Injection "
	@Qualifier("RESTFortuneService") // @Qualifier -> birden fazla Implementaion class olduðundan hangisi seçmek istiyorsak onu belirlememiz gerekir.
	public void setFortuneService(IFortuneService fortuneService) {
		System.out.println(">> FootballCoach | setFortuneService : Setter Injection");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice your shot activity";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}

}
