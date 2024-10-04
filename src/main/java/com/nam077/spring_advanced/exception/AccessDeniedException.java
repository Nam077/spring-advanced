package com.nam077.spring_advanced.exception;

/**
 * @author Nam077
 * Exception thrown when access is denied to a particular resource or operation.
 * This is a custom runtime exception that extends {@link RuntimeException}.
 *
 * @param message the detail message explaining the reason for the exception
 */
public class AccessDeniedException extends RuntimeException {
    public AccessDeniedException(String message) {
        super(message);
    }
}