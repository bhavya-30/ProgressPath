package com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.story_service;

import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.Story;

import java.util.List;
import java.util.Optional;

public interface StoryService {
    Story createStory(Story story);

    List<Story> getListOfAllStory();

    Optional<Story> findStoryById(int storyId);
}
