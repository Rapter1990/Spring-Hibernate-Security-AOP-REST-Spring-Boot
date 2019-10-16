package com.java.ioc;

public class MyApp {

	public static void main(String[] args) {
		
		// create a object
		BaseballCoach baseballCoach = new BaseballCoach();
		
		// call function
		System.out.println(baseballCoach.getDailyWorkout());
		
		// Create interface
		ICoach coach1 = new BaseballCoach();
		System.out.println(coach1.getDailyWorkout());
		
		// Create interface
		ICoach coach2 = new TrackCoach();
		System.out.println(coach2.getDailyWorkout());
	}
}
