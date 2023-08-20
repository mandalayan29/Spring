package com.ayan.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ayan.jpa.model.Device;
import com.ayan.jpa.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		System.out.println(employee.getFirstName());
		entityManager.persist(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
//		return entityManager.find(Employee.class, 1);
		return null;
	}
	
	@Override
	public Employee getEmployee() {
		return entityManager.find(Employee.class, 1);
	}


	@Override
	public List<Device> getEmployeeDevices(long employeeId) {
		TypedQuery<Device> query= entityManager.createQuery(
										"from Device where employee.id= :data", Device.class);
		query.setParameter("data", employeeId);
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public void updateEmployee(Employee employee) {
//		System.out.println(employee);
		entityManager.merge(employee);
	}


	@Override
	@Transactional
	public void updateEmployeeDevice(Device device) {
		entityManager.merge(device);
		
	}


	@Override
	@Transactional
	public void deleteEmployee(long id) {
		Employee e= entityManager.find(Employee.class, 1);
		entityManager.remove(e);
		
	}

	@Override
	@Transactional
	public void deleteDevice(long id) {
		Device device= entityManager.find(Device.class, id);
		entityManager.remove(device);
	}

	
	
	
	
	
	
	
	
}
