package com.interswitch.customer.exception;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<Object> CustomerExceptionHandler(CustomerException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatusCode.valueOf(404));

    }
}
