package com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type;

import com.springBoot.ProjectTracker.constants.PriorityLevel;
import com.springBoot.ProjectTracker.constants.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;

@Entity
@Data
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subTaskId;
    private String subTaskName;
    private PriorityLevel subTaskPriority;
    private String subtaskDescription;
    private Status subTaskStatus;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    private User subTaskAssignee;

    @ManyToOne
    private Task subTaskParent;

    @OneToOne
    private User subTaskReporter;
}
