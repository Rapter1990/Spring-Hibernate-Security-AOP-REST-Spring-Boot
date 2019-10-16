package com.java.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // -> ApplicationContext.Xml dosyasýna gerek duymadan gerekli beanlarý buarada tanýmlayacaðýz
@ComponentScan("com.java") //-> Buraya tanýmladýðýmýz bean' ler olduðu için @ComponentScan gerek yok
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
