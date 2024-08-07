package com.springBoot.ProjectTracker.exceptions;

public class NoSuchBugFoundException extends RuntimeException{
    public NoSuchBugFoundException() {
    }

    public NoSuchBugFoundException(String message) {
        super(message);
    }

    public NoSuchBugFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
