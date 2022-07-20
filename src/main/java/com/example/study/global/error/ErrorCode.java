package com.example.study.global.error;

import lombok.Getter;

@Getter
public enum ErrorCode {
    PASSWORD_NOT_MATCHED(400, "잘못된 비밀번호 입니다."),
    ALREADY_USER(400,"이미 존재하는 계정입니다." ),
    USER_NOT_FOUND(404, "사용자를 찾을 수 없습니다."),
    ID_MISS_MATCHED(400,"아이디가 올바르지 않습니다."),
    ID_NOT_FOUND(404,"해당 계정이 없습니다.");

    private final Integer status;
    private final String message;
    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
