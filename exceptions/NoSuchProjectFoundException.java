package com.springBoot.ProjectTracker.exceptions;

public class NoSuchProjectFoundException extends RuntimeException{
    public NoSuchProjectFoundException() {
    }

    public NoSuchProjectFoundException(String message) {
        super(message);
    }

    public NoSuchProjectFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
