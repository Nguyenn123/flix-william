package com.william.repository;

import com.william.entity.VideosEntity;
import org.springframework.data.repository.CrudRepository;

public interface IVideoRepository extends CrudRepository<VideosEntity,Integer> {
}
