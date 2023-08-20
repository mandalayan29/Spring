package com.ayan.jpa.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String skillName;
	
	@ManyToMany(fetch = FetchType.LAZY, 
			cascade = {
					CascadeType.DETACH, CascadeType.MERGE,
					CascadeType.PERSIST, CascadeType.REFRESH
					})
	@JoinTable(
			name="skill_employee",
			joinColumns = @JoinColumn(name="skill_id"),
			inverseJoinColumns = @JoinColumn(name="employee_id")
			)
	private List<Employee> skilledEmployee;
	
	public Skill() {
		super();
	}

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public List<Employee> getSkilledEmployee() {
		return skilledEmployee;
	}

	public void setSkilledEmployee(List<Employee> skilledEmployee) {
		this.skilledEmployee = skilledEmployee;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", skillName=" + skillName + ", skilledEmployee=" + skilledEmployee + "]";
	}

}
