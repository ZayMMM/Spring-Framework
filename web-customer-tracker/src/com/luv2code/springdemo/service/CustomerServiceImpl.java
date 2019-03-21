package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;

	@Override
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		customerDao.saveCustomer(theCustomer);	
	}

	@Override
	public Customer getCustomer(int theId) {
		return customerDao.getCustomer(theId);
	}

	@Override
	public void deleteCustomer(int theId) {
		customerDao.deleteCustomer(theId);
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		return customerDao.searchCustomer(theSearchName);
	}

}
