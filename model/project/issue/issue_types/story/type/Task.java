package com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type;

import com.springBoot.ProjectTracker.constants.Status;
import com.springBoot.ProjectTracker.model.Label;
import com.springBoot.ProjectTracker.model.project.Project;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.Story;
import com.springBoot.ProjectTracker.model.project.sprint.Sprint;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    private String taskName;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //    private IssueType  issueType;
    private Status taskStatus;
    private String taskSummary;
    private String taskDescription;


    private int taskStoryPointEstimate;

    @OneToOne
    private User taskReporter;

    @ManyToOne
    private User taskAssignee;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Label> taskLabels;

    @ManyToOne
    private Story taskParent;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Sprint sprint;

    @OneToMany(mappedBy = "subTaskParent", cascade = CascadeType.ALL)
    private Set<SubTask> subTasks;
}
