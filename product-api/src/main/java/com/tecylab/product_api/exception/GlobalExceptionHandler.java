package com.tecylab.product_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> handleResourceNotFoundException(
            ResourceNotFoundException exception) {
        Map<String,String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InsufficientStockException.class)
    public ResponseEntity<Map<String,String>> handleInsufficientStockException(
            InsufficientStockException exception) {
        Map<String,String> response = new HashMap<>();
        response.put("Error", exception.getMessage());
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
