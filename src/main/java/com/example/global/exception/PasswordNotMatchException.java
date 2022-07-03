package com.example.global.exception;

import com.example.global.error.CustomException;
import com.example.global.error.ErrorCode;


public class PasswordNotMatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordNotMatchException();

    private PasswordNotMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCHED);
    }
}
