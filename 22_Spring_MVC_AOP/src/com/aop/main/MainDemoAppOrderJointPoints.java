package com.aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.config.DemoConfig;
import com.aop.dao.AccountDAO;
import com.aop.dao.MembershipDAO;
import com.aop.entity.Account;


public class MainDemoAppOrderJointPoints {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = 
				context.getBean("membershipDAO", MembershipDAO.class);
		
		System.out.println("------------------theAccountDAO.addAccount() start------------------------");
		// call the business method
		theAccountDAO.addAccount();		
		System.out.println("-----------------theAccountDAO.addAccount() end----------------------");
		
		System.out.println("------------------theAccountDAO.addAccount(myAccount) start------------------------");
		// call the business method with Parameter
		Account myAccount = new Account();
		myAccount.setName("Madhu");
		myAccount.setLevel("Platinum");
		theAccountDAO.addAccount(myAccount);
		System.out.println("------------------theAccountDAO.addAccount(myAccount) end------------------------");
		
		System.out.println("------------------theAccountDAO.addAccount(myAccount, true); start------------------------");
		// call the business method with Two Parameter
		theAccountDAO.addAccount(myAccount, true);
		System.out.println("------------------theAccountDAO.addAccount(myAccount, true); end------------------------");
		
		System.out.println("------------------theMembershipDAO.addSillyMember() start ------------------------");
		// call the membership business method
		theMembershipDAO.addSillyMember();
		System.out.println("------------------theMembershipDAO.addSillyMember() end------------------------");
		
		System.out.println("------------------theMembershipDAO.goToSleep() start------------------------");
		theMembershipDAO.goToSleep();
		System.out.println("------------------theMembershipDAO.goToSleep() end------------------------");

		System.out.println("------------------theAccountDAO getter/setter methods start------------------------");
		// call the accountdao getter/setter methods
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		System.out.println("------------------theAccountDAO getter/setter methods end------------------------");
				
		// close the context
		context.close();
	}

}










