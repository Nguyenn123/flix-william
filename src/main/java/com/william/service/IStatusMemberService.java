package com.william.service;

import com.william.entity.StatusMemberEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface IStatusMemberService {
    Iterable<StatusMemberEntity> findAll();
    Optional<StatusMemberEntity> findById(int id);
    void save(StatusMemberEntity statusMemberEntity);
    void deleteById(int id);
}
