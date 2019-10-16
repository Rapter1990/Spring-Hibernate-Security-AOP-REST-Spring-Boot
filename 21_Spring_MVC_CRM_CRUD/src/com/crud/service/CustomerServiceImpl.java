package com.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dao.CustomerDao;
import com.crud.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.listAll();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDao.create(theCustomer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.get(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		// TODO Auto-generated method stub
		customerDao.delete(theId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		// TODO Auto-generated method stub
		return customerDao.searchCustomers(theSearchName);
	}
}
