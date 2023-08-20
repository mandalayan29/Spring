package com.ayan.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayan.jpa.dao.AppDAO;
import com.ayan.jpa.model.Employee;
import com.ayan.jpa.model.EmployeeAddress;

@SpringBootApplication
public class SpringJpaOneToOne2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOneToOne2Application.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner->{
			System.out.println("Appication started");
//			addEmployees(appDAO);
			deleteByEmployeeAddress(3, appDAO);
		};
	}
	
	public void addEmployees(AppDAO appDAO) {
		
		Employee emp1= new Employee("Ayan", "Mandal", "ayan@gmail.com");
		EmployeeAddress add1= new EmployeeAddress("Haldia", "Sea beach");
		emp1.setEmployeeAddress(add1);
		
		Employee emp2= new Employee("Heman", "Mandal", "ayan@gmail.com");
		EmployeeAddress add2= new EmployeeAddress("Tamluk", "Sea beach");
		emp1.setEmployeeAddress(add2);

		appDAO.save(emp1);
		appDAO.save(emp2);
		
	}
	
	public void deleteByEmployeeAddress(int id, AppDAO appDAO) {
		System.out.println("Deletion started");
		appDAO.deleteEmployeeByAddress(id);
		System.out.println("Delete completed");
	}
	
	

}
