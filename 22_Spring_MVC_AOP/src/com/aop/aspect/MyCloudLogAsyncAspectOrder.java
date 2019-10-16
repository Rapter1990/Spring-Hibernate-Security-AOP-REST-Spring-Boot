package com.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspectOrder {

	@Before("com.aop.aspect.LuvAopExpressionsOrder.forDaoPackageNoGetterSetter()")
	public void logToCloudAsync() {
		System.out.println("\n=====>>> MyCloudLogAsyncAspectOrder | Logging to Cloud in async fashion");		
	}

}
