package com.william.service;

import com.william.entity.CommentEntity;

import java.util.Optional;

public interface ICommentService {
    Iterable<CommentEntity> findAll();
    Optional<CommentEntity> findById(int id);
    void deleteById(int id);
    CommentEntity save(CommentEntity commentEntity);
}
