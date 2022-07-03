package com.example.global.error;

import com.example.global.error.ErrorResponse.CustomErrorResponse;
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
//    @ExceptionHandler(BindException.class)
//    public ResponseEntity<BindErrorResponse> bindExceptionHandling(BindException e) {
//        List<String> errorsList = new ArrayList<>();
//
//        for (FieldError error : e.getFieldErrors()) {
//            errorsList.add(error.getDefaultMessage());
//        }
//        BindErrorResponse errorResponse = BindErrorResponse.builder()
//                .status(HttpStatus.BAD_REQUEST.value())
//                .messages(errorsList)
//                .build();
//        @ExceptionHandler(AlreadyUserException.class)
//        public static ResponseEntity alreeadyuserexception (AlreadyUserException error){
//            return ResponseEntity.status(error.getErrorCode().getStatus())
//                    .body(error.getErrorCode().getMessage());
//        }
//        return new ResponseEntity<BindErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
}
