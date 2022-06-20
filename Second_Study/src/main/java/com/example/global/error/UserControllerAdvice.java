package com.example.global.error;

import com.example.global.exception.AlreadyUserException;
import com.example.global.exception.PasswordNotMatchException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {
    @ExceptionHandler(PasswordNotMatchException.class)
    public static ResponseEntity exception(PasswordNotMatchException error){
        return ResponseEntity.status(error.getErrorCode().getStatus())
                .body(error.getErrorCode().getMessage());
    }
    @ExceptionHandler(AlreadyUserException.class)
    public static ResponseEntity alreeadyuserexception(AlreadyUserException error){
        return ResponseEntity.status(error.getErrorCode().getStatus())
                .body(error.getErrorCode().getMessage());
    }
}