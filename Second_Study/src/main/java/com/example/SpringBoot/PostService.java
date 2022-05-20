package com.example.SpringBoot;

import com.example.SpringBoot.domain.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor

public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public void postEntity (PostRequest postRequest) throws Exception {

        PostEntity postEntity = PostEntity.builder()
                .accountId(postRequest.getAccountId())
                .password(postRequest.getPassword())
                .email(postRequest.getEmail())
                .name(postRequest.getName())
                .studentId(postRequest.getStudentId())
                .sex(postRequest.getSex())
                .build();

        postRepository.save(postEntity);
    }

}
