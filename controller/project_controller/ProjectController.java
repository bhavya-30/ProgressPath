package com.springBoot.ProjectTracker.controller.project_controller;

import com.springBoot.ProjectTracker.dto.project_dto.ProjectDto;
import com.springBoot.ProjectTracker.exceptions.NoSuchProjectFoundException;
import com.springBoot.ProjectTracker.model.project.Project;
import com.springBoot.ProjectTracker.model.users.User;
import com.springBoot.ProjectTracker.service.project_service.ProjectService;
import com.springBoot.ProjectTracker.service.users_service.UserService;
import com.springBoot.ProjectTracker.utility.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;



    @PostMapping("/create")
    public ResponseEntity<Response> createNewProject(@RequestBody ProjectDto projectDto) {
        Response response = new Response();
        projectDto.setProjectStartDate(LocalDate.now());
        projectDto.setProjectEstimatedCompletionDate(LocalDate.now().plusDays(15));
        Project project = modelMapper.map(projectDto, Project.class);
        Optional<User> user = userService.searchUserByEmail(SecurityContextHolder.getContext().getAuthentication().getName());
        if (user.isPresent()) {
            project.setProjectReporter(user.get());
        }

        Project createdProject = projectService.createProject(project);
        response.setStatus(HttpStatus.ACCEPTED.value());
        response.setMessage("Project details saved");
        response.setProject(createdProject);
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("project_created", "true")
                .body(response);
    }


    @GetMapping("/list-all")
    public List<Project> listOfAllProject(@RequestParam(name = "page-number", defaultValue = "0") int pageNumber,
                                          @RequestParam(name = "page-size", defaultValue = "2") int pageSize) {

        return projectService.getListOfAllProject(pageNumber, pageSize);
    }

    // get details of a project
    @GetMapping("")
    public ProjectDto openProjectWithId(@RequestParam(name = "project-id", required = true) int id) {
        Optional<Project> aProjectById = projectService.findAProjectById(id);
        if (aProjectById.isPresent()) {
            ProjectDto projectResponse = modelMapper.map(aProjectById.get(), ProjectDto.class);
            return projectResponse;
        }
        throw new NoSuchProjectFoundException("project looking for is not available");
    }
}
