package com.springBoot.ProjectTracker.controller.project_controller.issue.issue_type.story.type;

import com.springBoot.ProjectTracker.dto.project_dto.issue.issue_type.story.type.SubTaskDto;
import com.springBoot.ProjectTracker.model.project.issue.issue_types.story.type.SubTask;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sub_task")
public class SubTaskController {
    @Autowired
    private SubTaskService subTaskService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/create")
    public SubTask createSubTask(@RequestBody SubTaskDto subTaskDto){
        SubTask subTaskToCreate=modelMapper.map(subTaskDto,SubTask.class);
        return subTaskService.createSubTask(subTaskToCreate);
    }
    @GetMapping("list-all")
    public List<SubTask> listOfAllSubTask(){
        return subTaskService.getALlSubTask();
    }
}
