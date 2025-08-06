package com.educational.MyForumHub.infra.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandling {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity error400(DataIntegrityViolationException ex){
        var errors = ex.getLocalizedMessage();
        return ResponseEntity.badRequest().body(errors);
    }
}
