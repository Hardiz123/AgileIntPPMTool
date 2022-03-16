package com.ppmtool.personalprojecttool.repository;

import com.ppmtool.personalprojecttool.domain.ProjectTask;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
    

}
    
