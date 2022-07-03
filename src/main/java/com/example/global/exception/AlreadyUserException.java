package com.example.global.exception;

import com.example.global.error.CustomException;
import com.example.global.error.ErrorCode;

public class AlreadyUserException extends CustomException {
    public static final CustomException EXCEPTION =
            new AlreadyUserException();

    private AlreadyUserException(){
        super(ErrorCode.ALREADY_USER);
    }
}
