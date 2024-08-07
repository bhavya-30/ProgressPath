package com.springBoot.ProjectTracker.utility.response;

import com.springBoot.ProjectTracker.model.project.Project;
import lombok.Data;

@Data
public class Response {
    private int status;
    private String message;
    private Project project;
}
