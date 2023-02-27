package com.eteration.simplebanking.model;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = InsufficientBalanceException.class)
    protected ResponseEntity<Object> handleCLLException(InsufficientBalanceException exception, WebRequest request) {
        return ResponseEntity.badRequest().body(exception.getExMsg());
    }
}
