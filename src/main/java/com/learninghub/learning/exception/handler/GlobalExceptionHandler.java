package com.learninghub.learning.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String, String>>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        ApiResponse<Map<String, String>> response =
                new ApiResponse<>(true, "Validation failed", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}