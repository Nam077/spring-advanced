package com.nam077.spring_advanced.exception;

import org.springframework.web.HttpMediaTypeNotSupportedException;

/**
 * Exception thrown when the media type is not supported.
 * 
 * <p>This exception is typically used to indicate that the server cannot process 
 * the request because the media type of the request is not supported by the server.</p>
 * 
 * @param message the detail message explaining the reason for the exception
 */
public class UnsupportedMediaTypeException extends HttpMediaTypeNotSupportedException {
    public UnsupportedMediaTypeException(String message) {
        super(message);
    }
}
