package com.nam077.spring_advanced.exception;

import org.springframework.web.HttpMediaTypeNotAcceptableException;

/**
 * Exception thrown when a request is not acceptable according to the server's criteria.
 * This exception extends {@link org.springframework.web.HttpMediaTypeNotAcceptableException}.
 * 
 * <p>This exception is typically used to indicate that the server cannot produce a response 
 * matching the list of acceptable values defined in the request's proactive content negotiation headers.</p>
 * 
 * @param message the detail message explaining the reason for the exception
 */
public class NotAcceptableException extends HttpMediaTypeNotAcceptableException {
    public NotAcceptableException(String message) {
        super(message);
    }
}
