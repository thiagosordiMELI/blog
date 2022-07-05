package com.blog.blog.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class NotFoundExceptionDetails {
    private String title;
    private String message;
    private LocalDateTime timestamp;
}
