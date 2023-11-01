package com.aash.mangetask.manage_task.exception;

public class AccessDeniedException extends RuntimeException{
    public AccessDeniedException(String exception){
        super(exception);
    }
}
