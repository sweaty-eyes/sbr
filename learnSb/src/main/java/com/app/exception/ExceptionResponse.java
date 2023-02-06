package com.app.exception;

import com.app.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionResponse {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        System.out.println("in handle MethodArgumentNotValidException " + e);
        // how to get list of field specific errs
        List<FieldError> list = e.getFieldErrors();
        Map<String, String> map = list.stream() // Stream<FieldError>
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));// f -> f.getField(), f
        // ->
        // f.getDefaultMessage()
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    // catch-all : RuntimeExc
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        System.out.println("in catch-all run time exc" + e);
        //	e.printStackTrace();
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(new ApiResponse(e.getMessage()));

    }

    // catch-all : Exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        System.out.println("in catch-all exc " + e);
        //		e.printStackTrace();
        return ResponseEntity.
                status(HttpStatus.INTERNAL_SERVER_ERROR).
                body(new ApiResponse(e.getMessage()));

    }
}
