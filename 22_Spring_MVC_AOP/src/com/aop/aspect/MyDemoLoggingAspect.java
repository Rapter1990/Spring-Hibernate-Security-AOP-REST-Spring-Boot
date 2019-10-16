package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	// let's start with an @Before advice

	//@Before("execution(public void addAccount())") // public void addAccount() önce çalýþýr
	//@Before("execution(public void com.aop.dao.AccountDAO.addAccount())") //AccountDAO daki addAccount önce çalýþtýrýr.
	@Before("execution(public void add*())") //add ile baþlayan ve return type void tüm fonfiyonlardan önce çalýþýr.
	public void beforeAddAccountAdvice1() {
		
		System.out.println("\n=====>>> MyDemoLoggingAspect | beforeAddAccountAdvice1 | Executing @Before advice on addAccount()");
		
	}
	
	// Parameters 
	// () ---> parametresiz fonksiyon
	// (*) ---> herhangi bir deðiþken türünde bir parametreli (List,int,String) fonksiyon
	// (..) ---> parametresiz veya  herhangi bir deðiþken türünde birden fazla  parametreli (List,int,String) fonksiyon
	
	//@Before("execution(* addAccount(com.aop.entity.Account))")
	// Parametre olarak Account olan ve herhangi bir return type olan addAccount fonksiyonu
	
	//@Before("execution(* addAccount(..))")
	//Birden fazla parametresi olan ve herhangi bir return type olan addAccount fonksiyonu
	
	//@Before("execution(* com.aop.entity.*.*(..))")
	// *.* -> Class.Method þeklinde ifade edilir
	//com.aop.entity paketin içindeki e herhangi bir return type olan herhangi bir fonksiyon
	
	@Before("execution(* add*(com.aop.entity.Account))")
	public void beforeAddAccountAdvice2() {
		
		System.out.println("\n=====>>> MyDemoLoggingAspect | beforeAddAccountAdvice2 | Executing @Before advice on add*(com.aop.entity.Account))");
		
	}
	
	@Before("execution(* add*(..))")
	public void beforeAddAccountAdvice3() {
		
		System.out.println("\n=====>>> MyDemoLoggingAspect | beforeAddAccountAdvice3 | Executing @Before advice on add*(..))");
		
	}
	
}










