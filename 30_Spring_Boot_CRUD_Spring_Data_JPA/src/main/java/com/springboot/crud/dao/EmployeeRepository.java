package com.springboot.crud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.crud.entity.Employee;

// Entity -> Employee , Primary Key -> Integer
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
