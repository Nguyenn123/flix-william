package com.william.repository;

import com.william.entity.StatusEntity;
import org.springframework.data.repository.CrudRepository;

public interface IStatusRepository extends CrudRepository<StatusEntity,Integer>
{
}
