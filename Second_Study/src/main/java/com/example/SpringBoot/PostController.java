package com.example.SpringBoot;

import Dto.LogInDto;
import com.example.SpringBoot.domain.PostEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class PostController {
    private final PostService postService;

    @PostMapping
    public void postEntity (@RequestBody @Valid PostRequest postRequest) throws Exception {
        postService.postEntity(postRequest);
    }
}
