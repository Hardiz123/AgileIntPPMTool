package com.ppmtool.personalprojecttool.services;


import com.ppmtool.personalprojecttool.domain.Backlog;
import com.ppmtool.personalprojecttool.domain.ProjectTask;
import com.ppmtool.personalprojecttool.repository.BacklogRepository;
import com.ppmtool.personalprojecttool.repository.ProjectTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired 
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;


    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {

        //Exceptions: Project not found

        //PTs to be added to a specific project, project != null, BL exists
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        //set the BL to for each of the new project tasks
        projectTask.setBacklog(backlog);
        //we want out project sequence to be like: IDPROJECT-1, IDPROJECT-2, IDPROJECT-3...100 101 102 103...
        Integer BacklogSequence = backlog.getPTSequence();
        BacklogSequence++;

        backlog.setPTSequence(BacklogSequence);

        projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);
        //Update the BL with the new sequence

        //INITIAL Priority when priority is null
        if(projectTask.getPriority() == null || projectTask.getPriority() == 0) {
            projectTask.setPriority(3);
        }
        //INITIAL Status when status is null
        if(projectTask.getStatus() == null || projectTask.getStatus() == "") {
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);

    }


    public Iterable<ProjectTask> findBacklogById(String backlog_id) {
        return projectTaskRepository.findByProjectIdentifierOrderByPriority(backlog_id);
    }


    
}
