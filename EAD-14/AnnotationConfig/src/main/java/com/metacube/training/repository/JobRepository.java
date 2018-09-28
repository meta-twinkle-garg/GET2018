package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.metacube.training.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

	@Modifying
	@Query("delete from Job where id=?1")
	void deleteJobById(int id);

	
}
