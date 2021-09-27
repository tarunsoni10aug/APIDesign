package com.demo.runner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.entity.Department;
import com.demo.entity.Employee;
import com.demo.entity.Project;
import com.demo.repository.ProjectRepository;
@Component
public class TestRunner implements CommandLineRunner{

	@Autowired
	ProjectRepository projectRepository ;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello runner");
		Project project = new Project();
		project.setProjectID("P001");
		project.setProjectName("API Design");
		Employee employee= new Employee();
		employee.setEmpName("Tom");
		Set<Project>projects= new HashSet<>();
		projects.add(project);
		employee.setEmployeeProjects(projects);
		Employee employee1= new Employee();
		employee1.setEmpName("Jerry");
		employee1.setEmployeeProjects(projects);
		Department department= new Department();
		List<Project>projectList= new ArrayList<>();
		projectList.add(project);
		department.setDeptID("D001");
		department.setDeptName("Degital");
		department.setProjects(projectList);
		List<Department>departments= new ArrayList<Department>();
		departments.add(department);
		Set<Employee>employees= new HashSet<>();
		employees.add(employee);
		employees.add(employee1);
		project.setDepartments(departments);
		project.setEmployees(employees);
		Project save = projectRepository.save(project);
		System.out.println(save);
		
	}

}
