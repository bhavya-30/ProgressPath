package com.springBoot.ProjectTracker.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(ProjectExceptionHandler.class);

    @ExceptionHandler(value = NoSuchProjectFoundException.class)
    public String noSuchProjectFoundExceptionHandler(){
        return "No such Project Found....";
    }

    @ExceptionHandler(value = NoSuchEpicFoundException.class)
    public String noSuchEpicFoundException(){
        return "No such Epic Found....";
    }

    @ExceptionHandler(value = NoSuchStoryFoundException.class)
    public String noSuchStoryFoundException(){
        return "No such Story Found....";
    }

    @ExceptionHandler(value = NoSuchTaskFoundException.class)
    public String noSuchTaskFoundException(){
        return "No such Task Found....";
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String methodArgumentNotValidException(MethodArgumentNotValidException ex){

//       log.error(messageSourceResolvable.getDefaultMessage());
        return ex.getMessage() ;
    }
}
