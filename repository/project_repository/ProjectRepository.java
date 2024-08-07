package com.springBoot.ProjectTracker.repository.project_repository;

import com.springBoot.ProjectTracker.model.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
}
