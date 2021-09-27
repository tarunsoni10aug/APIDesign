package com.demo.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	
	@ManyToMany(targetEntity = Project.class, mappedBy = "employees", cascade = CascadeType.ALL)
	private Set<Project> employeeProjects  = new HashSet();
	
	private String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	

	public Set<Project> getEmployeeProjects() {
		return employeeProjects;
	}

	public void setEmployeeProjects(Set<Project> employeeProjects) {
		this.employeeProjects = employeeProjects;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	
	
}
