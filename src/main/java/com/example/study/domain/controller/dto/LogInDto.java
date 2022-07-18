package com.example.study.domain.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LogInDto {
    private String accountId;
    private String password;
}
