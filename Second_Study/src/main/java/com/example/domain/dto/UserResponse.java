package com.example.domain.dto;

import com.example.global.type.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {
    private final String accountId;
    private final String password;
    private final String email;
    private final String name;
    private final Long studentId;
    private final Sex sex;
}
