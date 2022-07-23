package com.example.study.domain.post.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PostRequest {

    @NotNull
    @Size(max = 20, message = "제목은 20자까지 가능합니다.")
    private String title;

    @NotNull
    @Size(max = 1000, message = "내용는 1000자까지 가능합니다.")
    private String content;

}
