package com.app.exception;

public class RequestNotFound extends RuntimeException {
    public RequestNotFound(String message) {
        super(message);
    }
}
