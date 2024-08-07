package com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.type_service.bug_service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Bug;

import java.util.List;
import java.util.Optional;

public interface BugService {
     Bug createBug(Bug bug);
     List<Bug> getListOfAllBug();
     Optional<Bug> findBugWithId(int bugId);
}
