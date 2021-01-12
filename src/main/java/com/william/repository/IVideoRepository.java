package com.william.repository;

import com.william.entity.VideosEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IVideoRepository extends PagingAndSortingRepository<VideosEntity,Integer> {
}
