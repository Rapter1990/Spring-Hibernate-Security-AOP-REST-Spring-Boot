package com.java.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {
		
	// define bean for our happy fortune service
	@Bean
	public IFortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public ICoach wrestlingCoach() {
		WrestlingCoach myWrestlingCoach = new WrestlingCoach(happyFortuneService());
		
		return myWrestlingCoach;
	}
	
}








