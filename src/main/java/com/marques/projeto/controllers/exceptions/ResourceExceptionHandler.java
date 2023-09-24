package com.marques.projeto.controllers.exceptions;

import com.marques.projeto.service.exceptions.DatabaseException;
import com.marques.projeto.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> notFound(ResourceNotFoundException e, HttpServletRequest req){
        String error = "Resource Not Found";
        HttpStatus http = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(Instant.now(),http.value(),error, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(http).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(ResourceNotFoundException e, HttpServletRequest req){
        String error = "Database Error";
        HttpStatus http = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError(Instant.now(),http.value(),error, e.getMessage(), req.getRequestURI());
        return ResponseEntity.status(http).body(err);
    }
}
