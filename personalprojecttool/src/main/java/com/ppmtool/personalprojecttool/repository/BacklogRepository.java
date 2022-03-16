package com.ppmtool.personalprojecttool.repository;

import com.ppmtool.personalprojecttool.domain.Backlog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BacklogRepository extends CrudRepository<Backlog, Long> {

    Backlog findByProjectIdentifier(String projectIdentifier);

}
    
