package com.demo.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Employee;
import com.demo.entity.Project;
import com.demo.repository.ProjectRepository;
import com.demo.service.EmployeeService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class EmployeeController {
	@Autowired
private	EmployeeService  employeeService;
	
	@GetMapping("/employees/{projectId}")
	public ResponseEntity< String> getProjectEmployees(@PathVariable(name = "projectId") String projectId) throws JsonProcessingException
	{
		String employees = employeeService.getEmployees(projectId);
		return new ResponseEntity<>( employees,HttpStatus.OK);
	}
}
