package com.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.config.DemoConfig;
import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;
import com.aop.entity.Account;


public class MainDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		System.out.println("------------------theAccountDAO.addAccount(myAccount, true) start------------------------");
		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		System.out.println("------------------theAccountDAO.addAccount(myAccount, true) end------------------------");
		
		System.out.println("------------------theAccountDAO.doWork() start------------------------");
		theAccountDAO.doWork();
		System.out.println("------------------theAccountDAO.doWork() end------------------------");
		
		System.out.println("------------------theAccountDAO getter/setter methods start------------------------");
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		System.out.println("------------------theAccountDAO getter/setter methods end------------------------");
		
		System.out.println("------------------theAccountDAO.addSillyMember() start------------------------");
		// call the membership business method
		theMembershipDAO.addSillyMember();
		System.out.println("------------------theAccountDAO.addSillyMember() end------------------------");
		
		System.out.println("------------------theAccountDAO.goToSleep() start------------------------");
		theMembershipDAO.goToSleep();
		System.out.println("------------------theAccountDAO.goToSleep() end------------------------");
		
		// close the context
		context.close();
	}

}










