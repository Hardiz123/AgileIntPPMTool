package com.ppmtool.personalprojecttool.repository;

import java.util.List;

import com.ppmtool.personalprojecttool.domain.ProjectTask;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
    
        List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);
    
}
    
