package com.william.repository;

import com.william.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;

public interface IProductRepository extends CrudRepository<ProductEntity,Integer> {

}
