package com.example.study.domain.post.service;

import com.example.study.domain.post.controller.dto.PostRequest;
import com.example.study.domain.post.domain.PostEntity;
import com.example.study.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public void postEntity(PostRequest postRequest) {

        PostEntity postEntity = PostEntity.builder()
                .title(postRequest.getTitle())
                .content(postRequest.getContent())
                .build();

        postRepository.save(postEntity);
    }
}
