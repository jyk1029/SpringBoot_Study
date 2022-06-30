package com.example.global.excepton;

import com.example.global.error.CustomException;
import com.example.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class UserNotFoundException extends CustomException {
    private static final CustomException EXCEPTION=
            new UserNotFoundException();

    private UserNotFoundException(){
        super(ErrorCode.USER_NOT_FOUND);
    }
}
