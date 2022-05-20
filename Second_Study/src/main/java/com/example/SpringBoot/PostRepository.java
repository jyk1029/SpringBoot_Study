package com.example.SpringBoot;


import com.example.SpringBoot.domain.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PostRepository extends CrudRepository<PostEntity, Long> {
    Optional<PostEntity> findById(String  accountId);
}