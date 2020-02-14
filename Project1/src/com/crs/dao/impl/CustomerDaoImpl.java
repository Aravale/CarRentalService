package com.crs.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crs.model.Customer;
import com.crs.dao.CustomerDAO;

@Repository
public class CustomerDaoImpl implements CustomerDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Customer loginCustomer(String uname, String pass) {
		Customer result = (Customer) sessionfactory.getCurrentSession().createQuery("from Customer where username = '"+uname+"' AND password = '"+pass+"'").uniqueResult();
		return result;
			}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		
		return sessionfactory.getCurrentSession().createQuery("from Customer").list();
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		sessionfactory.getCurrentSession().save(customer);
	
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionfactory.getCurrentSession().update(customer);
		
	}

	@Override
	public void deleteCustomer(Customer customer) {
		sessionfactory.getCurrentSession().delete(customer);
		
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer result = (Customer)sessionfactory.getCurrentSession().createQuery("from Customer where id = '"+id+"'").uniqueResult();
		return result;
	}

}
