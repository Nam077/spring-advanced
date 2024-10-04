package com.nam077.spring_advanced.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;

/**
 * Custom exception class that extends {@link MethodArgumentNotValidException}.
 * This exception is thrown when an invalid argument is encountered.
 * 
 * <p>
 * Note: The constructor currently passes null for both {@code BindingResult}
 * and {@code MethodParameter}. Modify these parameters as needed to provide
 * appropriate context for the exception.
 * </p>
 * 
 * @param message The detail message for the exception.
 */
public class InvalidArgumentException extends MethodArgumentNotValidException {
    public InvalidArgumentException(String message) {
        super(null, null); // Truyền đối tượng BindingResult và MethodParameter phù hợp nếu cần
    }
}
