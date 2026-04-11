package com.learninghub.learning.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.learninghub.learning.common.ApiResponse;
import com.learninghub.learning.exception.StudentExceptions;

@RestControllerAdvice
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

    //Generic fallback handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGenericException(Exception ex) {

        ApiResponse<Void> response = new ApiResponse<>(
            true,
            "Something went wrong",
            null
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}