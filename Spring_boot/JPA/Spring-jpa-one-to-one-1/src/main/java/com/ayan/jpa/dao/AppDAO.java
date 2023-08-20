package com.ayan.jpa.dao;

import com.ayan.jpa.model.Employee;

public interface AppDAO {
	
	void save(Employee employee);
	
	Employee findById(int employee_id);
	
	void deleteEmployeeById(int employee_id);
}
