package com.william.service;

import com.william.entity.VideosEntity;

import java.util.Optional;

public interface IVideoService {
    Iterable<VideosEntity> findAll();
    Optional<VideosEntity> findById(int id);
    void deleteById(int id);
    void save(VideosEntity video);
}
