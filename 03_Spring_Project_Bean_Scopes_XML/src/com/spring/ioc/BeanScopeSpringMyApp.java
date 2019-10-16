package com.spring.ioc;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.ioc.CricketCoach;
import com.java.ioc.FootballCoach;
import com.java.ioc.ICoach;

public class BeanScopeSpringMyApp {

	public static void main(String[] args) {
		
		
		// Bean (prototype) olarak tanýmladýðýmýz için 2 bean myCoach 
		//olmasýna raðmen memory de farklý alanlarý gösteriyor.
		/*<bean id="myCoach"
		 		class="com.java.ioc.TrackCoach"
		 		scope="prototype">	*/
		
		// Bean (singleton) olarak tanýmladýðýmýz için 2 bean myCoach 
		// ve memoryda ayný yeri gösteriyor.
				/*<bean id="myCoach"
				 		class="com.java.ioc.TrackCoach"
				 		scope="singleton">	*/
		
		
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("xml/beanScope-applicationContext.xml");
				
		// retrieve bean from spring container
		ICoach theCoach = context.getBean("myCoach", ICoach.class);

		ICoach alphaCoach = context.getBean("myCoach", ICoach.class);
		
		
		// check if they are the same
		boolean result = (theCoach == alphaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + result);
		
		System.out.println("\nMemory location for theCoach: " + theCoach);

		System.out.println("\nMemory location for alphaCoach: " + alphaCoach + "\n");
	
		System.out.println("---------------------------------------------------------------");
		
		// retrieve bean from spring container
		ICoach myGolfAlphaCoach = context.getBean("myGolfCoach", ICoach.class);

		ICoach myGolfBetaCoach = context.getBean("myGolfCoach", ICoach.class);
		
		// check if they are the same
		boolean resultBean = (myGolfAlphaCoach == myGolfBetaCoach);
		
		// print out the results
		System.out.println("\nPointing to the same object: " + resultBean);
		
		System.out.println("\nMemory location for myGolfAlphaCoach: " + myGolfAlphaCoach);

		System.out.println("\nMemory location for myGolfBetaCoach: " + myGolfBetaCoach + "\n");
		
		
		// close the context
		context.close();
		
	}
}
