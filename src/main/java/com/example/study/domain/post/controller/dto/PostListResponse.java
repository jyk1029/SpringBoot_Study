package com.example.study.domain.post.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponse {

    private final List<PostResponse> postList;

    @Getter
    @Builder
    public static class PostResponse {
        private final String title;
        private final String content;
    }
}
