package com.ayan.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayan.jpa.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

// Need to annotate this class, else spring can't find it during component scanning
@Repository
public class AppDAOImpl implements AppDAO{
	
//	Define field for entity manager.
	private EntityManager entityManager;

//	Inject entity manager using constructor injection
	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager= entityManager;
	}
		
	
	@Override
	@Transactional
	public void addEmployeeWithDevice(Employee employee) {
		System.out.println(employee);
		entityManager.persist(employee);
	}

	
	
	
	
	
	
	
	
}
