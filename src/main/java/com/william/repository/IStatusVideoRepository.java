package com.william.repository;

import com.william.entity.StatusVideoEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStatusVideoRepository extends CrudRepository<StatusVideoEntity,Integer> {
}
