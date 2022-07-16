package com.example.study.global.exception;

import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;


public class PasswordNotMatchException extends CustomException {
    public static final CustomException EXCEPTION =
            new PasswordNotMatchException();

    private PasswordNotMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCHED);
    }
}
