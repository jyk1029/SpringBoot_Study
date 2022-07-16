package com.example.study.global.error;

import com.example.study.global.error.errorResponse.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<CustomErrorResponse> customExceptionHandling(CustomException exception) {
        final ErrorCode errorCode = exception.getErrorCode();
        return new ResponseEntity<>(
                CustomErrorResponse.builder()
                        .status(errorCode.getStatus())
                        .message(errorCode.getMessage())
                        .build(),
                HttpStatus.valueOf(errorCode.getStatus())
        );
    }
}
