package com.ayan.jpa.dao;

import java.util.List;

import com.ayan.jpa.model.Employee;
import com.ayan.jpa.model.Skill;

public interface AppDAO {

	public void addEmployee(Employee emp);
	
	public void addSkill(Skill skill);
	
	public Employee getEmployee(long id);
	
	public List<Skill> getEmployeeSkill(long id);
	
}
