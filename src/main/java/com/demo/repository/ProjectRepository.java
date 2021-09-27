package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Project;
public interface ProjectRepository extends JpaRepository<Project,String>{

}
