package com.springBoot.ProjectTracker.service.project_service.project_service_implementation;

import com.springBoot.ProjectTracker.model.project.Project;
import com.springBoot.ProjectTracker.repository.project_repository.ProjectRepository;
import com.springBoot.ProjectTracker.service.project_service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getListOfAllProject(int pageNumber, int pageSize) {
        Pageable paging = PageRequest.of(pageNumber, pageSize);

        return projectRepository.findAll(paging).toList();
    }

    @Override
    public Optional<Project> findAProjectById(int id) {
        return projectRepository.findById(id);
    }
}
