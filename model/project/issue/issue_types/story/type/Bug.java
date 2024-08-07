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
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bugId;

    private String bugName;

    //    private IssueType  issueType;
    private Status bugStatus;
    private String bugSummary;
    private String bugDescription;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private int bugStoryPointEstimate;

    @OneToOne
    private User bugReporter;

    @ManyToOne
    private User bugAssignee;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Label> bugLabels;

    @ManyToOne
    private Story bugParent;

    @ManyToOne
    private Project project;

//    @ManyToOne
//    private Sprint sprint;
}
