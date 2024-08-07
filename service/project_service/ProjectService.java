package com.springBoot.ProjectTracker.service.project_service;

import com.springBoot.ProjectTracker.model.project.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project createProject(Project project);

    List<Project> getListOfAllProject(int pageNumber, int pageSize);

    Optional<Project> findAProjectById(int id);
}
