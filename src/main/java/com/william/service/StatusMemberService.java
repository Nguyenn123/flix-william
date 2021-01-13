package com.william.service;

import com.william.entity.StatusMemberEntity;
import com.william.repository.IStatusMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class StatusMemberService implements IStatusMemberService {
    @Autowired
    private IStatusMemberRepository statusMemberRepository;

    @Override
    public Iterable<StatusMemberEntity> findAll() {
        return statusMemberRepository.findAll();
    }

    @Override
    public Optional<StatusMemberEntity> findById(int id) {
        return statusMemberRepository.findById(id);
    }

    @Override
    public void save(StatusMemberEntity statusMemberEntity) {
        statusMemberRepository.save(statusMemberEntity);
    }

    @Override
    public void deleteById(int id) {
        statusMemberRepository.deleteById(id);
    }
}
