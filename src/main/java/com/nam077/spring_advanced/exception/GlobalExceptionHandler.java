package com.nam077.spring_advanced.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import jakarta.validation.ConstraintViolationException;

import org.springframework.web.bind.MethodArgumentNotValidException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;


import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        List<FieldErrorDetail> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(new FieldErrorDetail(error.getField(), error.getDefaultMessage()));
        }

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage("Validation errors occurred");
        errorDetails.setDetails(errors);
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<FieldErrorDetail> errors = new ArrayList<>();
        ex.getConstraintViolations().forEach(violation -> {
            errors.add(new FieldErrorDetail(violation.getPropertyPath().toString(), violation.getMessage()));
        });

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage("Constraint violations occurred");
        errorDetails.setDetails(errors);
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorDetails handleUsernameNotFound(UsernameNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorDetails.setMessage("Authentication failed");
        errorDetails.setDetails(List.of(new FieldErrorDetail("username", "User not found: " + ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorDetails handleBadCredentials(BadCredentialsException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorDetails.setMessage("Authentication failed");
        errorDetails.setDetails(List.of(new FieldErrorDetail("credentials", "Invalid credentials provided")));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorDetails handleAccessDenied(AccessDeniedException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.FORBIDDEN.value());
        errorDetails.setMessage("Access Denied");
        errorDetails.setDetails(List.of(new FieldErrorDetail("access", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails handleBadRequest(BadRequestException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage("Bad Request");
        errorDetails.setDetails(List.of(new FieldErrorDetail("request", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDetails handleInvalidArgument(InvalidArgumentException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage("Invalid Argument");
        errorDetails.setDetails(List.of(new FieldErrorDetail("argument", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(NotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ErrorDetails handleNotAcceptable(NotAcceptableException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
        errorDetails.setMessage("Not Acceptable");
        errorDetails.setDetails(List.of(new FieldErrorDetail("acceptability", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorDetails handleResourceNotFound(ResourceNotFoundException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setMessage("Resource Not Found");
        errorDetails.setDetails(List.of(new FieldErrorDetail("resource", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorDetails handleUnauthorized(UnauthorizedException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorDetails.setMessage("Unauthorized Access");
        errorDetails.setDetails(List.of(new FieldErrorDetail("authorization", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(UnsupportedMediaTypeException.class)
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public ErrorDetails handleUnsupportedMediaType(UnsupportedMediaTypeException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        errorDetails.setMessage("Unsupported Media Type");
        errorDetails.setDetails(List.of(new FieldErrorDetail("mediaType", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    //conflic
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ErrorDetails handleConflict(ConflictException ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.CONFLICT.value());
        errorDetails.setMessage("Conflict");
        errorDetails.setDetails(List.of(new FieldErrorDetail("conflict", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDetails handleAllExceptions(Exception ex, WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDetails.setMessage("An error occurred");
        errorDetails.setDetails(List.of(new FieldErrorDetail("error", ex.getMessage())));
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getDescription(false));
        return errorDetails;
    }
}
