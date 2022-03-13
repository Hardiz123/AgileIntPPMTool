package com.ppmtool.personalprojecttool.repository;

import com.ppmtool.personalprojecttool.domain.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    
}