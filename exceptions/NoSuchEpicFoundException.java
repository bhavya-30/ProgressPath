package com.springBoot.ProjectTracker.exceptions;

public class NoSuchEpicFoundException extends RuntimeException{
    public NoSuchEpicFoundException() {
    }

    public NoSuchEpicFoundException(String message) {
        super(message);
    }

    public NoSuchEpicFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
