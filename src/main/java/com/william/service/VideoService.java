package com.william.service;

import com.william.entity.VideosEntity;
import com.william.repository.IVideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class VideoService implements IVideoService {
    @Autowired
    private IVideoRepository videoRepository;

    @Override
    public Iterable<VideosEntity> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<VideosEntity> findById(int id) {
        return videoRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        videoRepository.deleteById(id);
    }

    @Override
    public void save(VideosEntity video) {
        videoRepository.save(video);
    }
}
