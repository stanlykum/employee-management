package com.jpmc.ems.exception;

import com.jpmc.ems.domain.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request) {
        var errorDetails = ErrorResponse.builder().statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).errorCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timestamp(LocalDateTime.now()).message(ex.getMessage()).details(request.getDescription(false)).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleResourceNotFoundException(BusinessException ex, WebRequest request) {
        var errorDetails = ErrorResponse.builder().statusCode(HttpStatus.BAD_REQUEST.value()).errorCode(ex.getErrorCode())
                .timestamp(LocalDateTime.now()).message(ex.getMessage()).details(request.getDescription(false)).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(NotFoundException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        var errorDetails = ErrorResponse.builder().statusCode(HttpStatus.NOT_FOUND.value()).errorCode(HttpStatus.NOT_FOUND.value())
                .timestamp(LocalDateTime.now()).message(ex.getMessage()).details(request.getDescription(false)).build();
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }
}
