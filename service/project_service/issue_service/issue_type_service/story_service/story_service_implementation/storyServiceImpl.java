package com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.story_service.story_service_implementation;

import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.Story;
import com.springBoot.ProjectTracker.repository.project_repository.issue.issue_types.story.StoryRepository;
import com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.story_service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class storyServiceImpl implements StoryService {

    @Autowired
    private StoryRepository storyRepository;

    @Override
    public Story createStory(Story story) {
        return storyRepository.save(story);
    }

    @Override
    public List<Story> getListOfAllStory() {
        return storyRepository.findAll();
    }

    @Override
    public Optional<Story> findStoryById(int storyId) {
        return storyRepository.findById(storyId);
    }
}
