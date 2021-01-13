package com.william.service;

import com.william.entity.StatusEntity;

import java.util.Optional;

public interface IStatusService {
    StatusEntity save(StatusEntity accountEntity);
    Optional<StatusEntity> findById(int id);
    Iterable<StatusEntity> findAll();
    boolean remove(int id);
}
