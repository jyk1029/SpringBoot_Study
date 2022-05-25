package com.example.SpringBoot;

import Dto.LogInDto;
import Dto.PostListResponse;
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
    public PostListResponse UserList(){
        return postService.searchAllDesc();
    }

    @DeleteMapping("/delete/{account_id}")
    public void delete(@PathVariable("account_id") long id){
        postService.delete(id);
    }
}