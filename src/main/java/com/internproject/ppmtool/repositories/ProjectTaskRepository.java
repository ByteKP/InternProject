package com.internproject.ppmtool.repositories;

import java.util.List;

import com.internproject.ppmtool.domain.ProjectTask;

import org.springframework.data.repository.CrudRepository;

public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);
}
