package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the query
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by firstName", Customer.class);

		// execute the query and get result
		List<Customer> customers = theQuery.getResultList();

		return customers;
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {

		// get the hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theCustomer);

	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();

		Customer theCustomer = currentSession.get(Customer.class, theId);

		return theCustomer;
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");

		theQuery.setParameter("customerId", theId);

		theQuery.executeUpdate();

	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String theSearchName) {

		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		if (theSearchName != null && theSearchName.trim().length() > 0) {
			theQuery = currentSession.createQuery(
					"from Customer where lower(firstName) like :theName or lower(lastName) like :theName",
					Customer.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");
		} else {
			theQuery = currentSession.createQuery("from Customer order by firstName");
		}

		List<Customer> theCustomers = theQuery.getResultList();

		return theCustomers;
	}

}
