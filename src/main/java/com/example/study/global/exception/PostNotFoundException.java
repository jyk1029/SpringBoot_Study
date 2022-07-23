package com.example.study.global.exception;

import com.example.study.global.error.CustomException;
import com.example.study.global.error.ErrorCode;

public class PostNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new PostNotFoundException();

    public PostNotFoundException(){
        super(ErrorCode.ID_NOT_FOUND);
    }
}
