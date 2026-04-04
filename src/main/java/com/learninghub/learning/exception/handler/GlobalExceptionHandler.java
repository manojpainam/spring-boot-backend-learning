package com.learninghub.learning.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learninghub.learning.exception.StudentExceptions;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentExceptions.class)
    public ResponseEntity<String> handleStudentNotFound(StudentExceptions ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}