package com.example.study.domain.controller;

import com.example.study.domain.controller.dto.UserEditDto;
import com.example.study.domain.controller.dto.UserListResponse;
import com.example.study.domain.controller.dto.UserRequest;
import com.example.study.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.example.study.domain.controller.dto.LogInDto;

import javax.validation.Valid;


@RequiredArgsConstructor
@RequestMapping("/account")
@RestController
public class UserController {

    private final UserService userService;

    @CrossOrigin("*")
    @PostMapping
    public void userEntity(@Valid @RequestBody UserRequest userRequest) {
        userService.userEntity(userRequest);
    }

    @PostMapping("/login")
    public void login(@Valid @RequestBody LogInDto logInDto) {
        userService.validationLogin(logInDto);
    }

    @GetMapping("/list")
    public UserListResponse UserList() {
        return userService.searchAllDesc();
    }

    @DeleteMapping("/delete/{accountId}")
    public void delete(@PathVariable("accountId") Long userId) {
        userService.delete(userId);
    }

    @PutMapping("/update/{accountId}")
    public void update(@PathVariable("accountId") Long userId, @RequestBody UserEditDto userEditDto) {
        userService.update(userId, userEditDto);
    }
}
