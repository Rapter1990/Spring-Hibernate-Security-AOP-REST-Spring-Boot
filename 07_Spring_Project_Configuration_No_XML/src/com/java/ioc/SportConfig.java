package com.java.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // -> ApplicationContext.Xml dosyas�na gerek duymadan gerekli beanlar� buarada tan�mlayaca��z
@ComponentScan("com.java") //-> Buraya tan�mlad���m�z bean' ler oldu�u i�in @ComponentScan gerek yok
public class SportConfig {

	// define bean for our sad fortune service
	@Bean
	public IFortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	// define bean for our swim coach AND inject dependency
	@Bean
	public ICoach swimCoach() {
		SwimCoach mySwimCoach = new SwimCoach(sadFortuneService());
		
		return mySwimCoach;
	}
}
