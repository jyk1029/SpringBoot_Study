package com.example.study.domain.post.domain.repository;

import com.example.study.domain.post.domain.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long> {

    Optional<PostEntity> findById(Long postId);
    List<PostEntity> findAllByUserId(Long userId);

}
