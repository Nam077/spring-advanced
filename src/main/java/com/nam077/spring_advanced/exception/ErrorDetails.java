package com.nam077.spring_advanced.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
class FieldErrorDetail {
    private String field;
    private String message;

  
}

/**
 * Represents the details of an error that occurs within the application.
 * This class includes information such as the status code, error message,
 * detailed description, timestamp of the error, and the path where the error
 * occurred.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    private int statusCode;
    private String message;
    private List<FieldErrorDetail> details; // Thay đổi từ List<String> thành List<FieldErrorDetail>
    private long timestamp;
    private String path;
}
