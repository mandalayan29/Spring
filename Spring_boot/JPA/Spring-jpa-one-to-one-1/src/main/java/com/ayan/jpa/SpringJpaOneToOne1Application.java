package com.ayan.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayan.jpa.dao.AppDAO;
import com.ayan.jpa.model.Employee;
import com.ayan.jpa.model.EmployeeAddress;

@SpringBootApplication
public class SpringJpaOneToOne1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaOneToOne1Application.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner->{
			System.out.println("Started");
			createEmployee(appDAO);
			deleteEmployee(1, appDAO);
		};
	}
    
    public void createEmployee(AppDAO appDAO){
    	Employee employee= new Employee(
    			"Ayan1",
    			"Mandal",
    			"mandalayan@gmail.com"
    			);
    	EmployeeAddress address= new EmployeeAddress(
    			"Tamluk",
    			"Salgechia High School"
    			);
    	employee.setEmployeeAddress(address);
    	appDAO.save(employee);
    	System.out.println(employee);
    	System.out.println("Completed");
    }
    
    public void deleteEmployee(int id, AppDAO appDAO) {
    	System.out.println("Delete function called");
    	appDAO.deleteEmployeeById(id);
    	System.out.println("Deletion finished");
    }

}
