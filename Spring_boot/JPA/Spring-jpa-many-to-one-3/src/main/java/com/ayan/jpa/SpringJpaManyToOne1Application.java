package com.ayan.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayan.jpa.dao.AppDAO;
import com.ayan.jpa.model.Device;
import com.ayan.jpa.model.Employee;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringJpaManyToOne1Application {

	@Autowired AppDAO appDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaManyToOne1Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner() {
		return runner->{
			System.out.println("Runner started");
			addEmployee();
			System.out.println("Add employee completed");
//			viewEmployee();
			System.out.println("---------");
//			updateEmployee();
//			
//			viewEmployee();
			
//			System.out.println("Device update");
//			updateDevice();
//			System.out.println("---------");
//			
//			System.out.println("Device delete");
//			deleteDevice();
//			viewEmployee();
//			
//			System.out.println("Delete employee");
//			deleteEmployee();
			
			System.out.println("Runner stopped");
		};
	}
	
	public void addEmployee() {
		Employee employee= new Employee("Ayan", "Mandal");

		employee.addDevice(new Device("Mac book pro"));
		employee.addDevice(new Device("Asus tuf gamming"));
		
		System.out.println(employee);
		
		appDAO.addEmployeeWithDevice(employee);
		
		
	}
	
	public void viewAllEmployee() {
		
	}
	
	
	public void viewEmployee() {
		Employee e= appDAO.getEmployee();	
		List<Device> devices= appDAO.getEmployeeDevices(1);
		e.setDevices(devices);
		System.out.println(e.toString());
	}
	
	public void updateEmployee() {
		Employee e= appDAO.getEmployee();	
		e.setFirstName("New Name");
		appDAO.updateEmployee(e);
		e= appDAO.getEmployee();
		System.out.println(e.getFirstName());
	}
	
	public void updateDevice() {
		List<Device> devices= appDAO.getEmployeeDevices(1);
		devices.get(1).setDeviceName("Updated name");
		System.out.println("New device name: "+devices.get(1).getDeviceName());
		appDAO.updateEmployeeDevice(devices.get(1));
		viewEmployee();
	}
	
	public void deleteEmployee() {
		appDAO.deleteEmployee(1);
	}
	
	public void deleteDevice() {
		appDAO.deleteDevice(1);
		System.out.println("Deleted successfully");
	}

}
