package com.example.domain.controller;

import com.example.domain.dto.UserEditDto;
import com.example.domain.dto.UserListResponse;
import com.example.domain.dto.UserRequest;
import com.example.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/account")
@RestController
public class UserController {

    private final UserService userService;

    @CrossOrigin("*")
    @PostMapping
    public void postEntity(@Valid @RequestBody UserRequest postRequest) {
        userService.postEntity(postRequest);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody Dto.LogInDto logInDto) {
        userService.validationLogin(logInDto);
    }

    @GetMapping("/list")
    public UserListResponse UserList() {
        return userService.searchAllDesc();
    }

    @DeleteMapping("/delete/{accountId}")
    public void delete(@PathVariable("accountId") String accountId) {
        userService.delete(accountId);
    }

    @PutMapping("/update/{accountId}")
    public void update(@PathVariable("accountId") Long userId, @RequestBody UserEditDto userEditDto) {
        userService.update(userId, userEditDto);
    }
}
