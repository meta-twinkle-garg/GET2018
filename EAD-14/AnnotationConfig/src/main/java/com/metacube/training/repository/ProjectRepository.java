package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metacube.training.model.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {

	@Modifying
	@Query("delete from Project where id = ?1")
	int deleteProjectById(int id);
	
	
	
}
