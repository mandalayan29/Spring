package com.ayan.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayan.jpa.model.Employee;
import com.ayan.jpa.model.Skill;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Service
public class AppDAOImpl implements AppDAO{
	
	@Autowired EntityManager entityManager;

	@Override
	@Transactional
	public void addEmployee(Employee emp) {
		entityManager.persist(emp);
	}

	@Override
	public void addSkill(Skill skill) {
		entityManager.persist(skill);
	}

	@Override
	public Employee getEmployee(long id) {
		return entityManager.find(Employee.class, id);
		
	}

	@Override
	@Transactional
	public List<Skill> getEmployeeSkill(long id) {
		List<Skill> skills= entityManager.find(Employee.class, id).getSkills();
//		for(Skill s: skills) {
//			s.setSkilledEmployee(null);
//		}
		System.out.println(skills.toString());
		return skills;
	}

}
