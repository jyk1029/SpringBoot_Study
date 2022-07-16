package com.example.study.global.exception;

import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;

public class IdNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new IdNotFoundException();

    public IdNotFoundException(){
        super(ErrorCode.ID_NOT_FOUND);
    }
}
