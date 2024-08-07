package com.springBoot.ProjectTracker.model.project.issue.issue_types.story;

import com.springBoot.ProjectTracker.model.project.Project;
import com.springBoot.ProjectTracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String storyName;
    private String storyStatus;
    private String storySummary;
    private String storyDescription;
    private int storyStoryPointEstimate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    @ManyToOne
    private User storyAssignee;

    @OneToOne
    private User storyReporter;
}
