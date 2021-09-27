package com.demo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.Employee;
import com.demo.entity.Project;
import com.demo.reponse.EmployeeResponse;
import com.demo.repository.ProjectRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class EmployeeService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ObjectMapper mapper;
	
	public String getEmployees(String pId) throws JsonProcessingException
	{
		List<String> employeeList=Collections.emptyList();
		Optional<Project> findById = projectRepository.findById(pId);
		if(findById.isPresent())
		{
			employeeList = findById.get().getEmployees().stream().map(Employee :: getEmpName).collect(Collectors.toList());
		}
		EmployeeResponse employeeResponse= new EmployeeResponse();
		employeeResponse.setEmployee(employeeList);
		  String writeValueAsString = mapper.writeValueAsString(employeeResponse);
		  System.out.println(writeValueAsString);
		  return writeValueAsString;
	}
}
