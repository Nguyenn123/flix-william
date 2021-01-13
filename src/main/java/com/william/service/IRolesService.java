package com.william.service;

import com.william.entity.RolesEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IRolesService {
    Iterable<RolesEntity> findAll();
    Optional<RolesEntity> findById(int id);
    RolesEntity save(RolesEntity rolesEntity);
    void deleteById(int id);
}
