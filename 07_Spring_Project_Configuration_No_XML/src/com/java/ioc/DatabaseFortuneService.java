package com.java.ioc;

import org.springframework.stereotype.Component;

@Component
public class DatabaseFortuneService implements IFortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "DatabaseFortuneService";
	}

}
