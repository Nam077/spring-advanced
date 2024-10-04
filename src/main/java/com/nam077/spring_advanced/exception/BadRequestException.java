package com.nam077.spring_advanced.exception;

/**
 * Exception thrown to indicate that a bad request was made.
 * This exception extends {@link RuntimeException} and is typically used
 * to signal that the server cannot or will not process the request due to
 * a client error (e.g., malformed request syntax, invalid request message framing, or deceptive request routing).
 *
 * @param message the detail message, which is saved for later retrieval by the {@link #getMessage()} method.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
