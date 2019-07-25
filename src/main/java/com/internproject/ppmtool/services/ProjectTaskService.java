package com.internproject.ppmtool.services;

import com.internproject.ppmtool.domain.Backlog;
import com.internproject.ppmtool.domain.ProjectTask;
import com.internproject.ppmtool.repositories.BacklogRepository;
import com.internproject.ppmtool.repositories.ProjectTaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository ProjectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask) {
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);

        projectTask.setBacklog(backlog);
        Integer BacklogSequence = backlog.getPTSequence();
        BacklogSequence++;
        backlog.setPTSequence(BacklogSequence);
        projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        if (projectTask.getPriority() == null) {
            projectTask.setPriority(3);
        }
        if (projectTask.getStatus() == "" || projectTask.getStatus() == null) {
            projectTask.setStatus("TO_DO");
        }
        return ProjectTaskRepository.save(projectTask);
    }

    public Iterable<ProjectTask> findBacklogById(String id){
        return ProjectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

}