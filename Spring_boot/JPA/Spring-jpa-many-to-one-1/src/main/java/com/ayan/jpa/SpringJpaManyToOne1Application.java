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
			System.out.println("Runner stopped");
		};
	}
	
	public void addEmployee() {
		Employee employee= new Employee("Ayan", "Mandal");
		Device device1=  new Device("Mac book pro");
		Device device2=  new Device("Asus tuf gamming");
		List<Device> list= new ArrayList<>();
		list.add(device1);
		list.add(device2);
		employee.setDevices(list);
		
		appDAO.addEmployeeWithDevice(employee);
		
	}

}
