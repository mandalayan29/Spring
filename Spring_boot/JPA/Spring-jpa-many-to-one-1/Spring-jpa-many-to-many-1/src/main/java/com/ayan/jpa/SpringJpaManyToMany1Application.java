package com.ayan.jpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ayan.jpa.dao.AppDAO;
import com.ayan.jpa.model.Employee;
import com.ayan.jpa.model.Skill;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringJpaManyToMany1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaManyToMany1Application.class, args);
	}
	
	@Bean
	CommandLineRunner cmdRunner() {
		return runner->{
			System.out.println("Application started");
			addEmployee();
			
			viewEmployee();
			
			System.out.println("------ Completed -------");
		};
	}

	@Autowired AppDAO appDAO;
	
	public void viewEmployee() {
		long id= 1;
		Employee e= appDAO.getEmployee(id);
		List<Skill> skills= new ArrayList<>();
		skills= appDAO.getEmployeeSkill(id);
		e.setSkills(skills);
		System.out.println(e.toString());
		
	}
	
	public void addEmployee() {
		
		Employee emp1= new Employee("Ayan", "Mandal");
		Employee emp2= new Employee("Mandal", "Ayan");
		Employee emp3= new Employee("Mr", "Ayan");
		
		Skill skill1= new Skill("JAVA");
		Skill skill2= new Skill("Angular");
		Skill skill3= new Skill("Node");
		Skill skill4= new Skill("Spring");
		Skill skill5= new Skill("HTML");
		Skill skill6= new Skill("CSS");
		
		emp1.addSkill(skill1);
		emp1.addSkill(skill2);
		emp1.addSkill(skill4);
		
		emp2.addSkill(skill6);
		
		emp3.addSkill(skill5);
		emp3.addSkill(skill3);
//		emp3.addSkill(skill6);
		
		appDAO.addEmployee(emp1);
		appDAO.addEmployee(emp2);
		appDAO.addEmployee(emp3);
		
		
	}
}
