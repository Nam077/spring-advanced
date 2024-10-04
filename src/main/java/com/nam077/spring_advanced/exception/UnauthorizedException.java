package com.nam077.spring_advanced.exception;

/**
 * Exception thrown when an unauthorized action is attempted.
 * This exception extends {@link RuntimeException}.
 * 
 * @param message the detail message explaining the reason for the exception
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(String message) {
        super(message);
    }
}
