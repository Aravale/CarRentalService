package com.crs.dao;

import com.crs.model.Employee;

public interface EmployeeDAO {

	Employee loginEmployee(String uname,String pass);
	void saveEmployee(Employee employee);
	void updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	Employee getEmployeebyID(int id);
	
	
	
}
