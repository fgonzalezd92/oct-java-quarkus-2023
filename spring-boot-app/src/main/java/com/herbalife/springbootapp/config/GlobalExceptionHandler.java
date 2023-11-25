package com.herbalife.springbootapp.config;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Component
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    public String handleRuntimeException(RuntimeException e) {
        return "Exception caught in handleRuntimeException: " + e.getMessage();
    }
}
