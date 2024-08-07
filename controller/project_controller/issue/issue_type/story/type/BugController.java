package com.springBoot.ProjectTracker.controller.project_controller.issue.issue_type.story.type;

import com.springBoot.ProjectTracker.dto.project_dto.issue.issue_type.story.type.BugDto;
import com.springBoot.ProjectTracker.exceptions.NoSuchBugFoundException;
import com.springBoot.ProjectTracker.model.project.Project;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.Bug;
import com.springBoot.ProjectTracker.service.project_service.ProjectService;
import com.springBoot.ProjectTracker.service.project_service.issue_service.issue_type_service.type_service.bug_service.BugService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bug")
public class BugController {
    @Autowired
    private BugService bugService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public Bug createBug(@RequestBody BugDto bugDto, @RequestParam(name="project-id")int projectId){
        Bug bugToCreate=modelMapper.map(bugDto,Bug.class);
        Optional<Project> project=projectService.findAProjectById(projectId);
        if(project.isPresent())
        {
            bugToCreate.setProject(project.get());
        }
        return bugService.createBug(bugToCreate);
    }
    @GetMapping("list-all")
    public List<Bug> listOfAllBug(){
        return bugService.getListOfAllBug();
    }
    @GetMapping("")
    public BugDto openBugWithId(@RequestParam(name="bug-id")int bugId){
        Optional<Bug> bug=bugService.findBugWithId(bugId);
        if(bug.isPresent()){
            BugDto bugDto=modelMapper.map(bug.get(),BugDto.class);
            return bugDto;
        }
        throw new NoSuchBugFoundException("searched bug is not found");
    }

}
