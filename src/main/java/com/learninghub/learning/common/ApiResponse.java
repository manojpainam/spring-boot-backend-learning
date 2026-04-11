package com.learninghub.learning.common;

public class ApiResponse<T> {

    private boolean error;
    private String message;
    private T data;

    public ApiResponse(boolean error, String message, T data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}