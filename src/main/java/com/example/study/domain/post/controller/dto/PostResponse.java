package com.example.study.domain.post.controller.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostResponse {

    private final String title;
    private final String content;

}
