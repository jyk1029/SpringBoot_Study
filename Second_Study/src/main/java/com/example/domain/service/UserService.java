package com.example.domain.service;


import com.example.domain.domain.UserEntity;
import com.example.domain.dto.*;
import com.example.domain.domain.repository.UserRepository;
import com.example.global.excepton.AlreadyUserException;
import com.example.global.excepton.PasswordNotMatchException;
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
                .orElseThrow(() -> new RuntimeException("Account Id Miss Match"));

        if (!passwordEncoder.matches(logInDto.getPassword(), loginUser.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }
    }

    @Transactional(readOnly = true)
    public UserListResponse searchAllDesc() {
        List<UserResponse> userList = userRepository.findAllByOrderByIdDesc()
                .stream()
                .map(this::accountBuilder)
                .collect(Collectors.toList());
        return new UserListResponse(userList);
    }

    @Transactional
    public void delete(String accountId) {
        UserEntity userEntity = userRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("해당 계정이 없습니다. id=" + accountId));
        userRepository.delete(userEntity);
    }

    @Transactional
    public void update(Long userId, UserEditDto userEditDto) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + userId));

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
