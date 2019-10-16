package com.crud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crud.entity.Customer;

@Repository
public class CustomerDao extends HibernateDao<Customer> implements GeneticDao<Customer>{
	

	public CustomerDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Customer create(Customer t) {
		// TODO Auto-generated method stub
		return super.create(t);
	}

	@Override
	public Customer update(Customer t) {
		// TODO Auto-generated method stub
		return super.update(t);
	}

	@Override
	public Customer get(Object id) {
		// TODO Auto-generated method stub
		return super.get(Customer.class, id);
	}

	@Override
	public void delete(Object id) {
		// TODO Auto-generated method stub
		super.delete(Customer.class, id);
	}

	@Override
	public List<Customer> listAll() {
		// TODO Auto-generated method stub
		return super.getListAll("Customer.findAll");
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return super.getCountAll("Customer.countAll");
	}
	
	public List<Customer> searchCustomers(String theSearchName){
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {
			System.out.println("List<Customer> searchCustomers |  theSearchName != null " +theSearchName );
			return super.findByNameQuery("Customer.search", "theName", theSearchName);
		}
		else {
			System.out.println("List<Customer> searchCustomers | theSearchName " +theSearchName);
			return super.getListAll("Customer.findAll");
		}
		
	}

}
