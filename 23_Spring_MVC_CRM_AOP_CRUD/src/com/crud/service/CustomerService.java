package com.crud.service;

import java.util.List;

import com.crud.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	
	public Customer getCustomer(int customerId);
	
	public void deleteCustomer(int theId);
	
	public List<Customer> searchCustomers(String theSearchName);
}
