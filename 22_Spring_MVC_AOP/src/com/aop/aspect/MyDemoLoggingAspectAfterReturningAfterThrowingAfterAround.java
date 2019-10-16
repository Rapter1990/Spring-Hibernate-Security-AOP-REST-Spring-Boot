package com.aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.aop.entity.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround {

	// add a new advice for @AfterReturning on the findAccounts method
	
	// Parameters 
	// () ---> parametresiz fonksiyon
	// (*) ---> herhangi bir deðiþken türünde bir parametreli (List,int,String) fonksiyon
	// (..) ---> parametresiz veya  herhangi bir deðiþken türünde birden fazla  parametreli (List,int,String) fonksiyon
	
	@AfterReturning(
			pointcut="execution(* com.aop.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
					JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | afterReturningFindAccountsAdvice | Executing @AfterReturning on method: " + method);
				
		// print out the results of the method call
		System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | afterReturningFindAccountsAdvice | result is: " + result);
		
		// let's post-process the data ... let's modify it :-)
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);

		System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | afterReturningFindAccountsAdvice | UpperCase result is: " + result);
		
	}

	private void convertAccountNamesToUpperCase(List<Account> result) {

		// loop through accounts

		for (Account tempAccount : result) {
			
			// get uppercase version of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
		}

	}


	@AfterThrowing(
			pointcut="execution(* com.aop.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
					JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | afterThrowingFindAccountsAdvice | Executing @AfterThrowing on method: " + method);
		
		// log the exception
		System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | afterThrowingFindAccountsAdvice | The exception is: " + theExc);
	
	}
	
	
	// Çalýþma Presibi @After  @AfterReturning ve  @AfterThrowing 'dan önce çalýþýr
	@After("execution(* com.aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> "
				+ "MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | afterFinallyFindAccountsAdvice |  Executing @After (finally) on method: " 
							+ method);
	
	}

	@Around("execution(* com.aop.service.*.getFortune(..))")	
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | aroundGetFortune | Executing @Around on method: " + method);
		
		// get begin timestamp
		long begin = System.currentTimeMillis();
		
		// now, let's execute the method 
		Object result = null;
		
		// Exception Handler
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			System.out.println("\n=====>>> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | aroundGetFortune | Exception : " + e);
			
			// give users a custom messagee
			result = "Major accident! But no worries, "
					+ "your private AOP helicopter is on the way!";
			
			// rethrow exception
			// @Around Rethrowing exception
			throw e;
		}

		// get end timestamp
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		System.out.println("\n=====> MyDemoLoggingAspectAfterReturningAfterThrowingAfterAround | aroundGetFortune | Duration: " + duration / 1000.0 + " seconds");
		
		return result;
	}
		
}










