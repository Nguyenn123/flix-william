package com.william.repository;

import com.william.entity.StatusMemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStatusMemberRepository extends CrudRepository<StatusMemberEntity, Integer> {
}
