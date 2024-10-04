package com.nam077.spring_advanced.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFoundException(ResourceNotFoundException ex,
            HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDetails> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorDetails> handleUnauthorizedException(UnauthorizedException ex,
            HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.UNAUTHORIZED.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDetails> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
            HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.CONFLICT.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException ex,
            HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.FORBIDDEN.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<ErrorDetails> handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException ex,
            HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.UNSUPPORTED_MEDIA_TYPE.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorDetails> handleHttpMediaTypeNotAcceptableException(
            HttpMediaTypeNotAcceptableException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.NOT_ACCEPTABLE.value(),
                ex.getMessage(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDetails> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex,
            HttpServletRequest request) {
        StringBuilder message = new StringBuilder(messageSource.getMessage("error.validation_failed", null, null));
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            message.append(fieldName).append(": ").append(errorMessage).append(", ");
        });
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.BAD_REQUEST.value(),
                message.toString(),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception ex, HttpServletRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                messageSource.getMessage("error.internal_server_error", null, null),
                request.getRequestURL().toString(),
                System.currentTimeMillis(),
                request.getRequestURI());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
