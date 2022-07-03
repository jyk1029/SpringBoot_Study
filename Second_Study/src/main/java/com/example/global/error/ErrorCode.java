package com.example.global.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PASSWORD_NOT_MATCHED(400, "BAD_REQUEST : 잘못된 비밀번호 입니다."),
    ALREADY_USER(400,"BAD_REQUEST : 이미 존재하는 계정입니다." ),
    USER_NOT_FOUND(400,"해당 계정을 찾을 수 없습니다");

    private final Integer status;
    private final String message;
    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
