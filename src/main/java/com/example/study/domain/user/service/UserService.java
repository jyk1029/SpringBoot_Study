package com.example.study.domain.user.service;

import com.example.study.domain.user.domain.UserEntity;
import com.example.study.domain.user.domain.repository.UserRepository;
import com.example.study.domain.user.controller.dto.*;
import com.example.study.global.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void userEntity(UserRequest userRequest) {

        if (userRepository.findByAccountId(userRequest.getAccountId()).isPresent()) {
            throw AlreadyUserException.EXCEPTION;
        }

        UserEntity userEntity = UserEntity.builder()
                .accountId(userRequest.getAccountId())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .email(userRequest.getEmail())
                .name(userRequest.getName())
                .studentId(userRequest.getStudentId())
                .sex(userRequest.getSex())
                .build();

        userRepository.save(userEntity);
    }

    @Transactional
    public void validationLogin(LogInDto logInDto) {
        UserEntity loginUser = userRepository.findByAccountId(logInDto.getAccountId())
                .orElseThrow(() -> IdMissMatchException.EXCEPTION);

        if (!passwordEncoder.matches(logInDto.getPassword(), loginUser.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }
    }

    @Transactional(readOnly = true)
    public UserListResponse searchAllDesc() {
        List<UserResponse> userList = userRepository.findAllByOrderByIdAsc()
                .stream()
                .map(this::accountBuilder)
                .collect(Collectors.toList());
        return new UserListResponse(userList);
    }

    @Transactional
    public void delete(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> IdNotFoundException.EXCEPTION);
        userRepository.delete(userEntity);
    }

    @Transactional
    public void update(Long userId, UserEditDto userEditDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        userEntity.update(userEditDto.getAccountId(),
                userEditDto.getEmail(),
                passwordEncoder.encode(userEditDto.getPassword()),
                userEditDto.getName(),
                userEditDto.getStudentId(),
                userEditDto.getSex());
    }

    private UserResponse accountBuilder(UserEntity userEntity) {
        return UserResponse.builder()
                .accountId(userEntity.getAccountId())
                .password(userEntity.getPassword())
                .sex(userEntity.getSex())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .studentId(userEntity.getStudentId())
                .build();
    }
}
