package com.springBoot.ProjectTracker.model.users;

import com.springBoot.ProjectTracker.constants.RoleName;
import com.springBoot.ProjectTracker.model.project.Project;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.Epic;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.Story;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Bug;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.SubTask;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Task;
import com.springBoot.ProjectTracker.model.project.sprint.Sprint;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(nullable = false)
    private Integer id;

    //    @Column(nullable = false)
    private String fullName;

    //    @Column(unique = true, length = 100, nullable = false)
    private String email;

    //    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
//    @Column(name = "updated_at")
    private LocalDate updatedAt;

    //@Column(nullable = false)
    private RoleName roleName;

    @ManyToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Project> projects;

//    @OneToMany(mappedBy = "projectReporter", cascade = CascadeType.ALL)
//    private Set<Project> project;



    @OneToMany(mappedBy = "storyAssignee", cascade = CascadeType.ALL)
    private Set<Story> stories;

    @OneToOne(mappedBy = "storyReporter", cascade = CascadeType.ALL)
    private Story story;



    /* overrides of methods of UserDetails interface of Spring security*/
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roleName.name());
        return List.of(authority);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
