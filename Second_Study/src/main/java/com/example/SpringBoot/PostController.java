package com.example.SpringBoot;

import Dto.LogInDto;
import Dto.PostEditDto;
import Dto.PostListResponse;
import Dto.PostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account")
public class PostController {
    private final PostService postService;

    @CrossOrigin("*")
    @PostMapping
    public void postEntity(@Valid @RequestBody PostRequest postRequest) throws Exception {
        postService.postEntity(postRequest);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LogInDto logInDto) {
        return postService.validationLogin(logInDto);
    }

    @GetMapping
    public PostListResponse UserList() {
        return postService.searchAllDesc();
    }

    @DeleteMapping("/delete/{account-id}")
    public void delete(@PathVariable("account-id") Long id) {
        postService.delete(id);
    }

    @PutMapping("/edit/{account-id}")
    public String edit(@PathVariable("account-id") Long id, @RequestBody PostEditDto postEditDto) {
        return postService.edit(id, postEditDto);
    }
}