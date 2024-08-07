package com.springBoot.ProjectTracker.repository.project_repository.issue.issue_types.story.type;

import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Bug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug,Integer> {
}
