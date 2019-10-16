package com.java.ioc;

import org.springframework.stereotype.Component;

@Component("theTennisCoach")
public class TennisCoach implements ICoach {

	// define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
		
	@Override
	public String getDailyWorkout() {
		return "Practice your tennis drop shot";
	}

}
