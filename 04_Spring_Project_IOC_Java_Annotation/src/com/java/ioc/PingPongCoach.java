package com.java.ioc;

import org.springframework.stereotype.Component;

@Component // default bean Id -> pingPongCoach
public class PingPongCoach implements ICoach {

	// define a default constructor
	public PingPongCoach() {
		System.out.println(">> PingPongCoach: inside default constructor");
	}
		
	@Override
	public String getDailyWorkout() {
		return "Practice your pingpong drop shot";
	}

}
