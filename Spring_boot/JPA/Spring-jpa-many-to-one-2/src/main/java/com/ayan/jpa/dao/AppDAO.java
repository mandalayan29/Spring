package com.ayan.jpa.dao;

import java.util.List;

import com.ayan.jpa.model.Device;
import com.ayan.jpa.model.Employee;

public interface AppDAO {
	
	void addEmployeeWithDevice(Employee employee);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployee();

	List<Device> getEmployeeDevices(long employeeId);
	
	public void updateEmployee(Employee employee);
	
	public void updateEmployeeDevice(Device device);
	
	public void deleteEmployee(long id);
	
	public void deleteDevice(long id);
	
	
}
