package com.crs.dao.impl;

import com.crs.dao.EmployeeDAO;
import com.crs.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public Employee loginEmployee(String uname, String pass) {
		Employee result = (Employee) sessionfactory.getCurrentSession().createQuery("from Employee where username = '"+uname+"' AND password = '"+pass+"'").uniqueResult();
		return result;
		
	}

	@Override
	public void saveEmployee(Employee employee) {
		sessionfactory.getCurrentSession().save(employee);

		
	}

	@Override
	public void updateEmployee(Employee employee) {
		sessionfactory.getCurrentSession().update(employee);
		
	}

	@Override
	public void deleteEmployee(Employee employee) {
		sessionfactory.getCurrentSession().delete(employee);
		
	}

	@Override
	public Employee getEmployeebyID(int id) {
		Employee result = (Employee) sessionfactory.getCurrentSession().createQuery("from Employee where id = '"+id+"'").uniqueResult();
		return result;
	}

}
