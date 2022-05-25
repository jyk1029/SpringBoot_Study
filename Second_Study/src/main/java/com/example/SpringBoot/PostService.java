package com.example.SpringBoot;

import Dto.LogInDto;
import Dto.PostListResponse;
import Dto.PostRequest;
import Dto.PostResponse;
import com.example.SpringBoot.domain.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Id;
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
    public PostListResponse searchAllDesc() {
        List<PostResponse> userList = postRepository.findAllByOrderByIdDesc()
                .stream()
                .map(this::accountBuilder)
                .collect(Collectors.toList());
        return new PostListResponse(userList);
    }
    private PostResponse accountBuilder(PostEntity entity) {
        return PostResponse.builder()
                .accountId(entity.getAccountId())
                .sex(entity.getSex())
                .name(entity.getName())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .studentId(entity.getStudentId())
                .build();
    }

    @Transactional
    public void delete(Long id){
        PostEntity postEntity = postRepository.findById(id)
                .orElseThrow(()-> new
                        IllegalArgumentException("해당 계정이 없습니다. id="+id));
        postRepository.delete(postEntity);

    }
}