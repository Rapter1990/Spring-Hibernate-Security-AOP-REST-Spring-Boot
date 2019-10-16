package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressionsOrder {

	@Pointcut("execution(* com.aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create pointcut for getter methods
	@Pointcut("execution(* com.aop.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.aop.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut for setter methods
	@Pointcut("execution(* com.aop.aspect.MyDemoLoggingAspect.*(..))")
	public void excludeMyDemoLoggingAspect() {}
	
	// create pointcut: include package ... exclude getter/setter and MyDemoLoggingAspect
	@Pointcut("forDaoPackage() && !(getter() || setter()) && !excludeMyDemoLoggingAspect() ")
	public void forDaoPackageNoGetterSetter() {}

}
