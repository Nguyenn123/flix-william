package com.william.service;

import com.william.entity.CommentEntity;
import com.william.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CommentService implements ICommentService {
    @Autowired
    private ICommentRepository commentRepository;

    @Override
    public Iterable<CommentEntity> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<CommentEntity> findById(int id) {
        return commentRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentEntity save(CommentEntity commentEntity) {
        return commentRepository.save(commentEntity);
    }
}
