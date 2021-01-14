package com.william.repository;

import com.william.entity.CommentEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICommentRepository extends PagingAndSortingRepository<CommentEntity,Integer> {
}
