package com.blog.blog.handler;

import com.blog.blog.exception.NotFoundException;
import com.blog.blog.exception.NotFoundExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class NotFoundExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<NotFoundExceptionDetails> notFoundExceptionDetails(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(NotFoundExceptionDetails.builder()
                .title("Não encontrado")
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .build());
    }
}
