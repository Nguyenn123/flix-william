package com.william.service;

import com.william.entity.VideosEntity;

public interface IVideoService {
    Iterable<VideosEntity> findAll();
    Object findById(int id);
    void deleteById(int id);
    void save(VideosEntity video);
}
