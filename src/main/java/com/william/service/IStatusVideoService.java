package com.william.service;

import com.william.entity.StatusVideoEntity;

import java.util.Optional;

public interface IStatusVideoService {
    Iterable<StatusVideoEntity> findAll();
    Optional<StatusVideoEntity> findById(int id);
    void save(StatusVideoEntity statusVideoEntity);
    void deleteById(int id);
}
