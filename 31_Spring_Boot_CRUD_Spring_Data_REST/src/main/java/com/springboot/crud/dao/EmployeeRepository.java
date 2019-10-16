package com.springboot.crud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.springboot.crud.entity.Employee;

// Default REST ->  Employee -> /employees
@RepositoryRestResource(path="members") // -> / members
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!

	// UPDATE 
	// http://localhost:9091/magic-api/employees/10
	/*
 		{
		    "firstName": "Irmak",
		    "lastName": "Çömlekçümoğlu",
		    "email": "i@c.com"
		}

	 */
	
	// DELETE
	// http://localhost:9091/magic-api/employees/10
	// Spring data rest no response -> Status 204 No Content
	
	// SORTING
	// http://localhost:9091/magic-api/members?sort=lastName,DESC
	// http://localhost:9091/magic-api/members?sort=lastName
	
}











