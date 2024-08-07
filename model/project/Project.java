package com.springBoot.ProjectTracker.model.project;

import com.springBoot.ProjectTracker.model.project.issue.issue_types.Epic;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.Story;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Bug;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Task;
import com.springBoot.ProjectTracker.model.users.User;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectId;
    private String projectName;
    private String productOwner;
    private String projectManager;
    private String projectStatus;
    private String specialNotes;
    private LocalDate projectStartDate;
    private LocalDate projectEstimatedCompletionDate;
    //    private LocalDate projectActualCompletionDate;
//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<User> user;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User projectReporter;



    //    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private Set<Story> stories;

}
