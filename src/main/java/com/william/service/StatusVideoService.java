package com.william.service;

import com.william.entity.StatusVideoEntity;
import com.william.repository.IStatusVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusVideoService implements IStatusVideoService {
    @Autowired
    private IStatusVideoRepository statusVideoRepository;

    @Override
    public Iterable<StatusVideoEntity> findAll() {
        return statusVideoRepository.findAll();
    }

    @Override
    public Optional<StatusVideoEntity> findById(int id) {
        return statusVideoRepository.findById(id);
    }

    @Override
    public void save(StatusVideoEntity statusVideoEntity) {
        statusVideoRepository.save(statusVideoEntity);
    }

    @Override
    public void deleteById(int id) {
        statusVideoRepository.deleteById(id);
    }
}
