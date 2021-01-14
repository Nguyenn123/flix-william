package com.william.service;

import com.william.entity.ProductEntity;

import java.util.Optional;

public interface IProductService {
    Iterable<ProductEntity> findAll();
    Optional<ProductEntity> findById(int id);
    void save(ProductEntity productEntity);
    void deleteById(int id);
}
