package com.first.app.exceptions;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({UserNotFoundException.class, IllegalArgumentException.class, NullPointerException.class})
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            Exception exception
    ) {
        Map<String , Object> errorRes = new HashMap<>();
        errorRes.put("timestamp", LocalTime.now());
        errorRes.put("error", "User Not Found");
        errorRes.put("Status", HttpStatus.BAD_REQUEST.value());
        errorRes.put("message", exception.getMessage());
        return new ResponseEntity<>(errorRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<Map<String, Object>> handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException exception
    ){
        Map<String,Object> errorRes = new HashMap<>();
        errorRes.put("timestamp", LocalTime.now());
        errorRes.put("error", "Method Not Allowed");
        errorRes.put("status", HttpStatus.METHOD_NOT_ALLOWED.value());
        errorRes.put("message", "calling request method not found");
        return new ResponseEntity<>(errorRes, HttpStatus.METHOD_NOT_ALLOWED);
    }
}
