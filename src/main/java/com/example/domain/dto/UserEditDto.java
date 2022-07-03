package com.example.domain.dto;

import com.example.global.type.Sex;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserEditDto {
    private String accountId;
    private String password;
    private String email;
    private String name;
    private Long studentId;
    private Sex sex;
}
