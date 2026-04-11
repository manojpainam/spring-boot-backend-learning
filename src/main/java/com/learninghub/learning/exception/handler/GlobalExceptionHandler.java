package com.learninghub.learning.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.exception.StudentExceptions;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentExceptions.class)
    public ResponseEntity<ApiResponse<Void>> handleStudentNotFound(StudentExceptions ex) {

        ApiResponse<Void> response = new ApiResponse<>(
            true,
            ex.getMessage(),
            null
        );

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}