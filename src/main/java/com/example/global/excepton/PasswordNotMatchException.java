package com.example.global.excepton;

import com.example.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class PasswordNotMatchException extends RuntimeException {
    private PasswordNotMatchException(){
        super(ErrorCode.PASSWORD_NOT_MATCHED.getMessage());
    }
    public static final RuntimeException EXCEPTION =
            new RuntimeException();
}
