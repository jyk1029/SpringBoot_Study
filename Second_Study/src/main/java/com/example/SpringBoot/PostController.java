package com.example.SpringBoot;

import Dto.LogInDto;
import Dto.PostRequest;
import Dto.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class PostController {
    private final PostService postService;

    @PostMapping
    public void postEntity(@Valid @RequestBody PostRequest postRequest) throws Exception {
        postService.postEntity(postRequest);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LogInDto logInDto) {
        return postService.validationLogin(logInDto);
    }

    @GetMapping
    public List<PostResponse> queryUser() {
        return postService.queryUser();
    }
}