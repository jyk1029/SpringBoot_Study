package com.example.domain.domain.repository;

import com.example.domain.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByAccountId(String accountId);
    List<UserEntity> findAllByOrderByIdDesc();
}
