package com.example.study.domain.user.domain.repository;


import com.example.study.domain.user.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    Optional<UserEntity> findByAccountId(String accountId);
    List<UserEntity> findAllByOrderByIdAsc();
}
