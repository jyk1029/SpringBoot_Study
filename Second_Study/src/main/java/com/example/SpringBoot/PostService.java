package com.example.SpringBoot;

import Dto.LogInDto;
import Dto.PostRequest;
import Dto.PostResponse;
import com.example.SpringBoot.domain.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void postEntity(PostRequest postRequest) throws Exception {

        if (postRepository.findByAccountId(postRequest.getAccountId()).isPresent()) {
            throw new RuntimeException();
        }

        PostEntity postEntity = PostEntity.builder()
                .accountId(postRequest.getAccountId())
                .password(passwordEncoder.encode(postRequest.getPassword()))
                .email(postRequest.getEmail())
                .name(postRequest.getName())
                .studentId(postRequest.getStudentId())
                .sex(postRequest.getSex())
                .build();

        postRepository.save(postEntity);
    }

    @Transactional
    public String validationLogin(LogInDto logInDto) {
        PostEntity loginUser = postRepository.findByAccountId(logInDto.getAccountId())
                .orElseThrow(RuntimeException::new);

        if (!passwordEncoder.matches(logInDto.getPassword(), loginUser.getPassword())) {
            throw new RuntimeException();
        }

        return "로그인 성공";
    }

    @Transactional(readOnly = true)
    public List<PostResponse> queryUser() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(postEntity -> PostResponse.builder()
                        .accountId(postEntity.getAccountId())
                        .password(postEntity.getPassword())
                        .email(postEntity.getEmail())
                        .name(postEntity.getName())
                        .studentId(postEntity.getStudentId())
                        .sex(postEntity.getSex())
                        .build())
                .collect(Collectors.toList());
    }
}