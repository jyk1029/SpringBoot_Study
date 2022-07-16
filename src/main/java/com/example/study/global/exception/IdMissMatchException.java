package com.example.study.global.exception;

import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;

public class IdMissMatchException extends CustomException {
    public static final CustomException EXCEPTION=
            new IdMissMatchException();
    private IdMissMatchException(){
        super(ErrorCode.ID_MISS_MATCHED);
    }
}
