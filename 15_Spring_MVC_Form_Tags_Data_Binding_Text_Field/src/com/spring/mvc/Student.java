package com.spring.mvc;

import java.io.Serializable;

public class Student implements Serializable{

	private String firstName;
	private String lastName;
		
	public Student() {
		super();
	}
	
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
			
}
