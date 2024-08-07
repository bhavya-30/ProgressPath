package com.springBoot.ProjectTracker.exceptions;

public class NoSuchStoryFoundException extends RuntimeException{
    public NoSuchStoryFoundException() {
    }

    public NoSuchStoryFoundException(String message) {
        super(message);
    }

    public NoSuchStoryFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
