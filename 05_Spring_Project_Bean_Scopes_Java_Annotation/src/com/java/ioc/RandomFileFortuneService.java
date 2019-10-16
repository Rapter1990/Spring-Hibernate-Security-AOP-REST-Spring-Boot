package com.java.ioc;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RandomFileFortuneService implements IFortuneService{

	private String[] data;
	
	@Value("${fortune1}")
	private String fortune1;
	
	@Value("${fortune2}")
	private String fortune2;
	
	@Value("${fortune3}")
	private String fortune3;
	
	
	private Random random = new Random();
	
	@PostConstruct
    public void setupMyData() {        
        data = new String[3];       
        data[0] = fortune1;
        data[1] = fortune2;
        data[2] = fortune3;     
    }
	
	
	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		// pick a random string from the array
		int index = random.nextInt(data.length);

		String tempFortune = data[index];

		return tempFortune;
		
	}
	
}
