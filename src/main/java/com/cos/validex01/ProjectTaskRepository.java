package com.cos.validex01;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long>{
	//ProjectTask getById(Long id);
	
}
