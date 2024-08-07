package com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.type_service.bug_service.bug_service_implementation;

import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Bug;
import com.springBoot.ProjectTracker.repository.project_repository.issue.issue_types.story.type.BugRepository;
import com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.type_service.bug_service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BugServiceImpl implements BugService {
    @Autowired
    private BugRepository bugRepository;

    @Override
    public Bug createBug(Bug bug) {
        return bugRepository.save(bug);
    }

    @Override
    public List<Bug> getListOfAllBug() {
        return bugRepository.findAll();
    }

    @Override
    public Optional<Bug> findBugWithId(int bugId) {
        return bugRepository.findById(bugId);
    }
}
