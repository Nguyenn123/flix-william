package com.william.repository;

import com.william.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepository extends CrudRepository<CategoryEntity,Integer> {
}
