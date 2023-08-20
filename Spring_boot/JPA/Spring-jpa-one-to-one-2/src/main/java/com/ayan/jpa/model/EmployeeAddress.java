package com.ayan.jpa.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="employee_address")
public class EmployeeAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="landmark")
	private String landmark;
	
	@OneToOne(mappedBy="employeeAddress", cascade = {
										CascadeType.DETACH,
										CascadeType.MERGE,
										CascadeType.PERSIST,
										CascadeType.REFRESH,
										CascadeType.REMOVE
										})
	private Employee employee;

	public EmployeeAddress() {
		super();
	}

	public EmployeeAddress(String address, String landmark) {
		super();
		this.address = address;
		this.landmark = landmark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmployeeAddress [id=" + id + ", address=" + address + ", landmark=" + landmark + ", employee="
				+ employee + "]";
	}

	
}
