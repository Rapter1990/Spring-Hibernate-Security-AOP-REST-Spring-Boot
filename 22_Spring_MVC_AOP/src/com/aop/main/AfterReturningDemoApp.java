package com.aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aop.config.DemoConfig;
import com.aop.dao.AccountDAO;
import com.aop.entity.Account;


public class AfterReturningDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call method to find the accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display the accounts
		System.out.println("\n\n-------Main Program: AfterReturningDemoApp-----------------");
		System.out.println("----");
		
		System.out.println(theAccounts);
		
		System.out.println("\n--------------------------------------------------------------");
		
		// close the context
		context.close();
	}

}










