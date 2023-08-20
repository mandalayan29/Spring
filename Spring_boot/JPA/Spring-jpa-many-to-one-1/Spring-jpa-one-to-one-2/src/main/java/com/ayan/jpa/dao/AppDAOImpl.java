package com.ayan.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayan.jpa.model.Employee;
import com.ayan.jpa.model.EmployeeAddress;

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
	public void save(Employee employee) {
//		Cascade type is all, so no need to save related mapped address, itt will save automatically
		entityManager.persist(employee);
	}

	@Override
	@Transactional
	public Employee findById(int employee_id) {
//		It will also retrieve Employee Address, because the default behavior of OneToOne mapping is fetch type eager
		return entityManager.find(Employee.class, employee_id);
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int employee_id) {
		Employee employee= entityManager.find(Employee.class, employee_id);
		entityManager.remove(employee);
	}

	@Override
	@Transactional
	public void deleteEmployeeByAddress(int address_id) {
		System.out.println("Address ID : "+address_id);
		EmployeeAddress address= entityManager.find(EmployeeAddress.class, address_id);
		System.out.println(address.toString());
		entityManager.remove(address);
	}
	
	
	
	
	
}
