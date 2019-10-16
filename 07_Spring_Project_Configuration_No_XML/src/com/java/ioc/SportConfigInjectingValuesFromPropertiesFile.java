package com.java.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration // -> ApplicationContext.Xml dosyasýna gerek duymadan gerekli beanlarý buarada tanýmlayacaðýz
@PropertySource("classpath:sport.properties")
public class SportConfigInjectingValuesFromPropertiesFile {

	// add support to resolve ${...} properties
	//
	// NOTE: THIS IS ONLY REQUIRED FOR OLD VERSIONS OF SPRING: v4.2 and lower
	//
	// This is NOT required if using Spring v4.3+
	//
	@Bean
	public static PropertySourcesPlaceholderConfigurer
					propertySourcesPlaceHolderConfigurer() {
		
		return new PropertySourcesPlaceholderConfigurer();
	}
	
	// define bean for our sad fortune service
	@Bean
	public IFortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public ICoach swimCoach() {
		SwimCoachInjectingValuesFromPropertiesFile mySwimCoach = new SwimCoachInjectingValuesFromPropertiesFile(sadFortuneService());
		
		return mySwimCoach;
	}
}
