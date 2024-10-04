package com.nam077.spring_advanced.exception;

/**
 * Exception thrown when a requested resource is not found.
 * This exception extends {@link RuntimeException}.
 * 
 * @param message the detail message explaining the reason for the exception
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
