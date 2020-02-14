package com.crs.service.impl;

import com.crs.dao.EmployeeDAO;
import com.crs.model.Employee;
import com.crs.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Transactional
	public Employee loginEmployee(String uname, String pass) {
		
		return employeeDAO.loginEmployee(uname, pass);
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	@Transactional
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(Employee employee) {
		employeeDAO.deleteEmployee(employee);
	}

	@Transactional
	public Employee getEmployeebyID(int id) {
		
		return employeeDAO.getEmployeebyID(id);
	}		

}
