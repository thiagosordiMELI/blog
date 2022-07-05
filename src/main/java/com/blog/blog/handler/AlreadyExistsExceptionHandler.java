package com.blog.blog.handler;

import com.blog.blog.exception.AlreadyExistsException;
import com.blog.blog.exception.AlreadyExistsExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class AlreadyExistsExceptionHandler {
    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<AlreadyExistsExceptionDetails> alreadyExistsExceptionDetails(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(AlreadyExistsExceptionDetails.builder()
                .title("Registro já existe")
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }
}
