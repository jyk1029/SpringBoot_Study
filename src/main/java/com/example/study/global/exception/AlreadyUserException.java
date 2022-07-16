package com.example.study.global.exception;

import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;

public class AlreadyUserException extends CustomException {
    public static final CustomException EXCEPTION =
            new AlreadyUserException();

    private AlreadyUserException(){
        super(ErrorCode.ALREADY_USER);
    }
}
