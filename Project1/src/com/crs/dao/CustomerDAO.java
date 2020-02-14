package com.crs.dao;

import java.util.List;

import com.crs.model.Customer;

public interface CustomerDAO {
	Customer loginCustomer(String uname,String pass);
	void saveCustomer(Customer customer);
	void updateCustomer(Customer customer);
	void deleteCustomer(Customer customer);
	List<Customer>  getCustomers();
	Customer getCustomerById(int id);
}
