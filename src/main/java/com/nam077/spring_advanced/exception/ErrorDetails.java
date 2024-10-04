package com.nam077.spring_advanced.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the details of an error that occurs within the application.
 * This class includes information such as the status code, error message,
 * detailed description, timestamp of the error, and the path where the error
 * occurred.
 * 
 * <p>
 * Example usage:
 * 
 * <pre>
 * {@code
 * ErrorDetails errorDetails = new ErrorDetails(404, "Not Found", "The requested resource was not found",
 *         System.currentTimeMillis(), "/api/resource");
 * }
 * </pre>
 * </p>
 * 
 * @author
 * @version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private int statusCode;
    private String message;
    private String details;
    private long timestamp;
    private String path;
}
