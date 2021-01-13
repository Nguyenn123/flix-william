package com.william.service;

import com.william.entity.RolesEntity;
import com.william.repository.IRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class RolesService implements IRolesService {
    @Autowired
    private IRolesRepository rolesRepository;

    @Override
    public Iterable<RolesEntity> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<RolesEntity> findById(int id) {
        return rolesRepository.findById(id);
    }

    @Override
    public RolesEntity save(RolesEntity rolesEntity) {
        rolesRepository.save(rolesEntity);
        return rolesEntity;
    }

    @Override
    public void deleteById(int id) {
        rolesRepository.deleteById(id);
    }
}
